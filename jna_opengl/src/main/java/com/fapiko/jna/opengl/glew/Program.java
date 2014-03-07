package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.types.GL;
import com.sun.jna.ptr.IntByReference;

import java.util.Set;

public class Program {
    public static final int LINK_STATUS = 0x8B82;

    private int programIndex;

    public Program(Set<Shader> shaders) {
        programIndex = Glew.glCreateProgram();
        for (Shader shader : shaders) {
            attachShader(programIndex, shader);
        }
        Glew.glLinkProgram(programIndex);

        if (!getParameter(LINK_STATUS)) {
            try {
                throw new Exception("Could not link program");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void attachShader(int programIndex, Shader shader) {
        Glew.glAttachShader(programIndex, shader.getShaderIndex());
    }

    private boolean getParameter(int parameterName) {
        IntByReference value = new IntByReference();
        Glew.glGetProgramiv(programIndex, parameterName, value);

        if (value.getValue() == GL.TRUE) {
            return true;
        } else {
            return false;
        }
    }
}
