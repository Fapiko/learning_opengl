package com.fapiko.jna.opengl.glew;

import com.sun.jna.Native;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

public class Glew {
    public static native void glAttachShader(int program, int shader);
    public static native void glCompileShader(int shader);
    public static native int glCreateProgram();
    public static native int glCreateShader(long shaderType);
    public static native long glGetError();
    public static native long glGetProgramiv(int programIndex, int parameterName, IntByReference params);
    public static native void glGetShaderiv(int shader, int parameterName, IntByReference params);
    public static native long glEnable(long feature);
    public static native void glLinkProgram(int program);
    public static native void glShaderSource(int shader, int count, StringArray sourceCode, int[] length);
    public static native int glewInit();

    static {
        Native.register("libGLEW");
    }
}
