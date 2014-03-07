package com.fapiko.gltut.tutorial1;

import com.fapiko.jna.opengl.freeglut.*;
import com.fapiko.jna.opengl.glew.Buffer;
import com.fapiko.jna.opengl.glew.Glew;
import com.fapiko.jna.opengl.glew.Program;
import com.fapiko.jna.opengl.glew.Shader;
import com.fapiko.jna.opengl.types.GL;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class HelloTriangle {

    private static HelloTriangle instance;
    IntByReference positionBuffer;
    private Program program;

    public static void main(String[] args) {
        if (HelloTriangle.instance == null) {
            instance = new HelloTriangle();
            instance.applicationLoop(args);
        }
    }

    public void applicationLoop(String[] args) {
        Freeglut.init(args.length, args);

        Set displayMode = EnumSet.of(
                DisplayMode.GLUT_DOUBLE,
                DisplayMode.GLUT_ALPHA,
                DisplayMode.GLUT_DEPTH,
                DisplayMode.GLUT_STENCIL
        );
        Freeglut.initDisplayMode(displayMode);
        Freeglut.initContextVersion(4, 3);
        Freeglut.initContextProfile(GLUT.CORE_PROFILE);
        Freeglut.initContextFlags(GLUT.DEBUG);
        Freeglut.initWindowPosition(300, 200);
        Freeglut.initWindowSize(500, 500);
        Freeglut.createWindow("Hello Triangle");
        Freeglut.setOption(GLUT.ACTION_ON_WINDOW_CLOSE, GLUT.ACTION_CONTINUE_EXECUTION);

        Set<Shader> shaders = new HashSet<Shader>(2);
        shaders.add(new Shader(Shader.VERTEX_SHADER, "/com/fapiko/gltut/tutorial1/vertexShader.vert"));
        shaders.add(new Shader(Shader.FRAGMENT_SHADER, "/com/fapiko/gltut/tutorial1/fragmentShader.frag"));

        program = new Program(shaders);

        // Free this guy up for GC
        shaders = null;

        // Initialize vertex buffer
        final float[] vertexPositons = {
                0.75f, 0.75f, 0.0f, 1.0f,
                0.75f, -0.75f, 0.0f, 1.0f,
                -0.75f, -0.75f, 0.0f, 1.0f,
        };

        positionBuffer = new IntByReference();
        Glew.glGenBuffers(1, positionBuffer);
        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, positionBuffer.getValue());
        Glew.glBufferData(Buffer.ARRAY_BUFFER, vertexPositons.length, vertexPositons, Buffer.STATIC_DRAW);
        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, 0);

        // Initialize vertex array
        IntByReference vertexArray = new IntByReference();
        Glew.glGenVertexArrays(1, vertexArray);
        Glew.glBindVertexArray(vertexArray.getValue());



        Glew.glViewport(0, 0, 500, 500);

        FreeglutLibrary freeglutLibrary = FreeglutLibraryFactory.getInstance();
        freeglutLibrary.glutDisplayFunc(new FreeglutLibrary.DisplayCallback() {
            @Override
            public void invoke() {
                display();
            }
        });
        Freeglut.mainLoop();
    }

    public void display() {
        // Display some shit
        Glew.glClearColor(0, 0, 0, 0);
        Glew.glClear(Buffer.COLOR_BUFFER_BIT);
        Glew.glUseProgram(program.getProgramIndex());

        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, positionBuffer.getValue());
        Glew.glEnableVertexAttribArray(0);
        Glew.glVertexAttribPointer(0, 4, GL.FLOAT, false, 0, new IntByReference(0));

        Glew.glDrawArrays(GL.TRIANGLES, 0, 3);

        Glew.glDisableVertexAttribArray(0);
        Glew.glUseProgram(0);

        Freeglut.swapBuffers();
    }
}
