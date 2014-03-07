package com.fapiko.jna.opengl.glew;

import com.sun.jna.Library;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface Glew extends StdCallLibrary {
    public int glewInit();
    public int glCreateShader(LongByReference shaderType);
    public ByteByReference __glewCreateShader(long flags);
    public long glGetError();
    public String glewGetString(int stringFlag);
    public ByteByReference __glewGetStringi(int string, int index);
    public long glEnable(long feature);
}
