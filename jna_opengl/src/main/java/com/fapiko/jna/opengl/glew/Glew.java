package com.fapiko.jna.opengl.glew;

import com.sun.jna.Library;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface Glew extends StdCallLibrary {
    public int glewInit();
    public void glCompileShader(int shader);
    public int glCreateShader(long shaderType);
    public long glGetError();
    public void glGetShaderiv(int shader, int parameterName, IntByReference params);
    public long glEnable(long feature);
    public void glShaderSource(int shader, int count, String[] sourceCode, int[] length);

}
