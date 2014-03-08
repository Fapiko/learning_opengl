package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;


public interface FreeglutLibrary extends Library {
    public int glutCreateWindow(String name);
    public void glutDisplayFunc(DisplayCallback display);
    public void glutInit(IntByReference argCount, StringArray arguments);
    public void glutInitContextFlags(int contextFlags);
    public void glutInitContextProfile(int contextProfile);
    public void glutInitContextVersion(int majorVersion, int minorVersion);
    public void glutInitDisplayMode(int displayMode);
    public void glutInitWindowPosition(int x, int y);
    public void glutInitWindowSize(int width, int height);
    public void glutKeyboardFunc(KeyboardCallback keyboardCallback);
    public void glutMainLoop();
    public void glutLeaveMainLoop();
    public void glutReshapeFunc(ReshapeCallback reshapeCallback);
    public void glutSetOption(int option, int value);
    public void glutSwapBuffers();

    public interface DisplayCallback extends Callback {
        void invoke();
    }

    public interface ReshapeCallback extends Callback {
        void invoke(int width, int height);
    }

    public interface KeyboardCallback extends Callback {
        void invoke(char key, int x, int y);
    }
}
