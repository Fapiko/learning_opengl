package com.fapiko.jna.opengl.glew.experimental;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

public interface GlewLibrary extends Library {
    public static final int GL_OK = 0;

    public void glAttachShader(int program, int shader);
    public void glBindBuffer(int target, int buffer);
    public void glBindVertexArray(int array);
    public void glBufferData(int target, int size, float[] data, int usage);
    public void glClear(int bufferMask);
    public void glClearColor(float red, float green, float blue, float alpha);
    public void glCompileShader(int shader);
    public int glCreateProgram();
    public int glCreateShader(long shaderType);
    public void glDebugMessageCallbackARB(DebugCallback debugCallback, int userParam);
    public void glDeleteShader(int shaderIndex);
    public int glDetachShader(int programIndex, int shaderIndex);
    public int glDisableVertexAttribArray(int attributeIndex);
    public void glDrawArrays(int mode, int first, int count);
    public int glEnableVertexAttribArray(int attributeIndex);
    public void glGenBuffers(int numBuffers, IntByReference buffers);
    public void glGenVertexArrays(int numVertexArrays, IntByReference vertexArrays);
    public long glGetError();
    public long glGetProgramiv(int programIndex, int parameterName, IntByReference params);
    public void glGetShaderiv(int shader, int parameterName, IntByReference params);
    public void glEnable(int feature);
    public void glLinkProgram(int program);
    public void glShaderSource(int shader, int count, StringArray sourceCode, int[] length);
    public void glUseProgram(int programIndex);
    public void glVertexAttribPointer(int attributeIndex, int size, int type, boolean normalized,
                                                    int stride, IntByReference component);
    public void glViewport(int x, int y, int width, int height);
    public int glewInit();

    public interface DebugCallback extends Callback {
        public void invoke(int source, int type, int id, int severity, int length, String message, IntByReference userParam);
    }
}
