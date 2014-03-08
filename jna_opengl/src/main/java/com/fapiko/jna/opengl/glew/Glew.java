package com.fapiko.jna.opengl.glew;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.omg.CORBA._PolicyStub;

import java.nio.Buffer;

public class Glew {
    public static native void glAttachShader(int program, int shader);
    public static native void glBindBuffer(int target, int buffer);
    public static native void glBindVertexArray(int array);
    public static native void glBufferData(int target, int size, float[] data, int usage);
    public static native void glClear(int bufferMask);
    public static native void glClearColor(float red, float green, float blue, float alpha);
    public static native void glCompileShader(int shader);
    public static native int glCreateProgram();
    public static native int glCreateShader(long shaderType);
    public static native void glDebugMessageCallbackARB(DebugCallback debugCallback, Pointer userParam);
    public static native void glDeleteShader(int shaderIndex);
    public static native int glDetachShader(int programIndex, int shaderIndex);
    public static native int glDisableVertexAttribArray(int attributeIndex);
    public static native void glDrawArrays(int mode, int first, int count);
    public static native int glEnableVertexAttribArray(int attributeIndex);
    public static native void glGenBuffers(int numBuffers, IntByReference buffers);
    public static native void glGenVertexArrays(int numVertexArrays, IntByReference vertexArrays);
    public static native long glGetError();
    public static native long glGetProgramiv(int programIndex, int parameterName, IntByReference params);
    public static native void glGetShaderiv(int shader, int parameterName, IntByReference params);
    public static native long glEnable(long feature);
    public static native void glLinkProgram(int program);
    public static native void glShaderSource(int shader, int count, StringArray sourceCode, int[] length);
    public static native void glUseProgram(int programIndex);
    public static native void glVertexAttribPointer(int attributeIndex, int size, int type, boolean normalized,
                                                    int stride, IntByReference component);
    public static native void glViewport(int x, int y, int width, int height);
    public static native int glewInit();

    public interface DebugCallback extends Callback {
        public void invoke(int source, int type, int id, int severity, int length, String message, Pointer userParam);
    }

    static {
        Native.register("libGLEW");
    }
}
