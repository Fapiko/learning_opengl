package com.fapiko.jna.opengl.glew;

import com.sun.jna.Library;

public interface Glew extends Library {
    public long glCreateShader(long shaderType);
    public long glGetError();
    public long glEnable(long feature);
}
