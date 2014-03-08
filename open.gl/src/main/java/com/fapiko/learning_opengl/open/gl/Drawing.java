package com.fapiko.learning_opengl.open.gl;

import com.fapiko.jna.opengl.freeglut.Freeglut;
import com.fapiko.jna.opengl.freeglut.FreeglutLibrary;
import com.fapiko.jna.opengl.glew.Buffer;
import com.fapiko.jna.opengl.glew.Glew;
import com.fapiko.jna.opengl.glew.Program;
import com.fapiko.jna.opengl.glew.Shader;
import com.fapiko.jna.opengl.types.GL;
import com.sun.jna.ptr.IntByReference;

import java.util.HashSet;
import java.util.Set;

public class Drawing {

    private static Drawing instance;
    private Program program;

    public static void main(String[] args) {
        Drawing instance = getInstance();
        instance.init();
    }

    private void init() {
        Freeglut.init();
        Freeglut.initContextVersion(4, 3);
        Freeglut.createWindow("Hello Triangle");

        int status = Glew.glewInit();
        if (status != Glew.GL_OK) {
            try {
                throw new Exception("glewInit Failed!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        float[] vertices = {
                0.0f,  0.5f, // Vertex 1 (X, Y)
                0.5f, -0.5f, // Vertex 2 (X, Y)
                -0.5f, -0.5f  // Vertex 3 (X, Y)
        };

        IntByReference vertexBufferObject = new IntByReference();
        Glew.glGenBuffers(1, vertexBufferObject);
        Glew.glBindBuffer(Buffer.ARRAY_BUFFER, vertexBufferObject);
        Glew.glBufferData(Buffer.ARRAY_BUFFER, vertices.length, vertices, Buffer.STATIC_DRAW);

        Shader vertexShader = new Shader(Shader.VERTEX_SHADER, "/com/fapiko/learning_opengl/open.gl/vertexShader.vert");
        Shader fragmentShader = new Shader(Shader.FRAGMENT_SHADER,
                "/com/fapiko/learning_opengl/open.gl/fragmentShader.frag");

        Set<Shader> shaders = new HashSet<Shader>(2);
        shaders.add(vertexShader);
        shaders.add(fragmentShader);

        program = new Program(shaders);

        Freeglut.setDisplayCallback(new FreeglutLibrary.DisplayCallback() {
            @Override
            public void invoke() {
                draw();
            }
        });

        Freeglut.mainLoop();
    }

    private void draw() {
        Glew.glClearColor(0f, 0f, 0f, 0f);
        Glew.glClear(Buffer.COLOR_BUFFER_BIT);

        Glew.glUseProgram(program.getProgramIndex());
        int positionAttribute = Glew.glGetAttribLocation(program.getProgramIndex(), "position");
        Glew.glVertexAttribPointer(positionAttribute, 2, GL.FLOAT, false, 0, 0);
        Glew.glEnableVertexAttribArray(positionAttribute);

        IntByReference vertexArrayObject = new IntByReference();
        Glew.glGenVertexArrays(1, vertexArrayObject);
        Glew.glBindVertexArray(vertexArrayObject);

        Glew.glDrawArrays(GL.TRIANGLES, 0, 3);
        Freeglut.swapBuffers();
    }

    private static Drawing getInstance() {
        if (instance == null) {
            instance = new Drawing();
        }

        return instance;
    }
}
