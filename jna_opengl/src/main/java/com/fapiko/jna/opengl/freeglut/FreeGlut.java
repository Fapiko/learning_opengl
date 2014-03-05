package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.Library;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

public interface FreeGlut extends Library {
    public void glutInit(IntByReference argCount, StringArray arguments);
    public void glutInitWindowPosition(int x, int y);
    public void glutInitWindowSize(int width, int height);
}
