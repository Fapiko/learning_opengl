package com.fapiko.jna.opengl.microsoft_opengl;

public interface OpenGL {
    public int glCreateShader(long flags);
    public String glGetString(long stringId);
}
