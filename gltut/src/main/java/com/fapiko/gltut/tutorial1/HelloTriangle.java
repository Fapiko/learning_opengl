package com.fapiko.gltut.tutorial1;

import com.fapiko.jna.opengl.freeglut.*;
import com.fapiko.jna.opengl.glew.*;
import com.fapiko.jna.opengl.glew.experimental.GlewLibrary;
import com.fapiko.jna.opengl.types.GL;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class HelloTriangle {

    private static HelloTriangle instance;
    private IntByReference bufferObject;
    private Program program;
    private Set<Shader> shaders;
    private IntByReference vertexArray;

    private final float[] vertexPositons = {
            0.75f, 0.75f, 0.0f, 1.0f,
            0.75f, -0.75f, 0.0f, 1.0f,
            -0.75f, -0.75f, 0.0f, 1.0f
    };

    public static void main(String[] args) {
        if (HelloTriangle.instance == null) {
            instance = new HelloTriangle();
            instance.frameworkMain(args);
        }
    }

    public void frameworkMain(String[] args) {
        Freeglut.init(args.length, args);

        Set displayMode = EnumSet.of(
                DisplayMode.GLUT_DOUBLE,
                DisplayMode.GLUT_ALPHA,
                DisplayMode.GLUT_DEPTH,
                DisplayMode.GLUT_STENCIL
        );
        System.out.println(Glew.glGetError());
        Freeglut.initDisplayMode(displayMode);
        Freeglut.initContextVersion(4, 3);
//        Freeglut.initContextVersion(4, 2);
        Freeglut.initContextProfile(GLUT.CORE_PROFILE);
        System.out.println(Glew.glGetError());
        Freeglut.initContextFlags(GLUT.DEBUG);
        Freeglut.initWindowPosition(300, 200);
        Freeglut.initWindowSize(500, 500);
        Freeglut.createWindow("Hello Triangle");
        System.out.println("hello " + Glew.glGetError());
        Pointer glewExperimental = NativeLibrary.getInstance("libGLEW").getGlobalVariableAddress("glewExperimental");
        glewExperimental.setInt(0, 1);
        int status = Glew.glewInit();
        if (status != Glew.GL_OK) {
            try {
                throw new Exception("glewInit Failed!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Glew.glGetError());
        Freeglut.setOption(GLUT.ACTION_ON_WINDOW_CLOSE, GLUT.ACTION_CONTINUE_EXECUTION);
        System.out.println(Glew.glGetError());
        Glew.glEnable(GL.DEBUG_OUTPUT_SYNCHRONOUS_ARB);
        Glew.glDebugMessageCallbackARB(new Glew.DebugCallback() {
            public void invoke(int source, int type, int id, int severity, int length, Pointer message, IntByReference userParam) {
                logShit(source, type, id, severity, length, message, userParam);
            }
        }, 15);

        System.out.println("/invoke " + Glew.glGetError());
        init();
        System.out.println(Glew.glGetError());
        Freeglut.setDisplayCallback(new FreeglutLibrary.DisplayCallback() {
            @Override
            public void invoke() {
                display();
            }
        });
        Freeglut.setReshapeCallback(new FreeglutLibrary.ReshapeCallback() {
            public void invoke(int width, int height) {
                reshape(width, height);
            }
        });
        Freeglut.setKeyboardCallback(new FreeglutLibrary.KeyboardCallback() {
            @Override
            public void invoke(char key, int x, int y) {
                keyboard(key, x, y);
            }
        });
        System.out.println(Glew.glGetError());
        Freeglut.mainLoop();
    }

    public void logShit(int source, int type, int id, int severity, int length, Pointer message, IntByReference userParam) {
        System.out.printf("%s %s %s %s %s %s\n", source, type, id, severity, length, message);
    }

    public void init() {
        initializeProgram();
        initializeVertexBuffer();

        // Initialize vertex array
        vertexArray = new IntByReference();
        Glew.glGenVertexArrays(1, vertexArray);
        Glew.glBindVertexArray(vertexArray.getValue());
    }

    public void initializeProgram() {
        shaders = new HashSet<Shader>(2);
        shaders.add(new Shader(Shader.VERTEX_SHADER, "/com/fapiko/gltut/tutorial1/vertexShader.vert"));
        shaders.add(new Shader(Shader.FRAGMENT_SHADER, "/com/fapiko/gltut/tutorial1/fragmentShader.frag"));

        program = new Program(shaders);

        // Not sure why this is happening but, meh
//        for (Shader shader : shaders) {
//            Glew.glDeleteShader(shader.getShaderIndex());
//        }
    }

    public void initializeVertexBuffer() {
        bufferObject = new IntByReference();
        Glew.glGenBuffers(1, bufferObject);
        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, bufferObject.getValue());
        Glew.glBufferData(Buffer.ARRAY_BUFFER, vertexPositons.length, vertexPositons, Buffer.STATIC_DRAW);
        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, 0);
    }

    public void display() {
        // Display some shit
        Glew.glClearColor(0, 0, 0, 0);
        Glew.glClear(Buffer.COLOR_BUFFER_BIT);
        Glew.glUseProgram(program.getProgramIndex());
        for (Shader shader : shaders) {
            if (shader.getShaderType() == Shader.FRAGMENT_SHADER) {
                Glew.glBindFragDataLocation(program.getProgramIndex(), 0, "outputColor");
            }

            PointerByReference pointer = new PointerByReference();
            IntByReference length = new IntByReference();
            Glew.glGetShaderInfoLog(shader.getShaderIndex(), 2048, length, pointer);
            System.out.printf("[%s] %s\n", length.getValue(), pointer.getValue());
        }

        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, bufferObject.getValue());
        int positionAttribute = Glew.glGetAttribLocation(program.getProgramIndex(), "position");
        Glew.glVertexAttribPointer(positionAttribute, 4, GL.FLOAT, false, 0, 0);
        Glew.glEnableVertexAttribArray(positionAttribute);
        Glew.glDrawArrays(GL.TRIANGLES, 0, 3);

//        Glew.glDisableVertexAttribArray(0);
//        Glew.glUseProgram(0);

        System.out.println("Swapping buffers...");

        Freeglut.swapBuffers();
        System.out.println(Glew.glGetError());
    }

    public void reshape(int width, int height) {
        Glew.glViewport(0, 0, width, height);
    }

    public void keyboard(char key, int x, int y) {
        switch (key) {
            case 27:
                Freeglut.leaveMainLoop();
        }
    }
}
