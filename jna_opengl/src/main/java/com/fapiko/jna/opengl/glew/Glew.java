package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.types.GLEnum;
import com.fapiko.jna.opengl.types.GLUnsignedInteger;
import com.sun.jna.Library;

public interface Glew extends Library {
    public long glCreateShader(GLEnum shaderType);
}
