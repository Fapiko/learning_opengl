package com.fapiko.jna.opengl.glew;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

public interface GlewLibrary extends Library {
    public void glAttachShader(int program, int shader);
    public void glCompileShader(int shader);
    public int glCreateProgram();
    public int glCreateShader(long shaderType);
    public long glGetError();
    public void glGetShaderiv(int shader, int parameterName, IntByReference params);
    public long glEnable(long feature);
    public void glLinkProgram(int program);
    public void glShaderSource(int shader, int count, String[] sourceCode, int[] length);
    public int glewInit();

}
