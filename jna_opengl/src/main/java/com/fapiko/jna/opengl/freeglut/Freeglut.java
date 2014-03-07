package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

import java.util.EnumSet;
import java.util.Set;

public abstract class Freeglut  {
    private static final FreeglutLibrary freeglutLibrary = FreeglutLibraryFactory.getInstance();

    public static void init() {
        freeglutLibrary.glutInit(new IntByReference(0), new StringArray(new String[] {}));
    }

    public static void init(int numArguments, String[] arguments) {
        freeglutLibrary.glutInit(new IntByReference(numArguments), new StringArray(arguments));
    }

    public static void initDisplayMode(Set<DisplayMode> displayModes) {
        freeglutLibrary.glutInitDisplayMode(DisplayMode.getValue(displayModes));
    }

    public static void initContextVersion(int major, int minor) {
        freeglutLibrary.glutInitContextVersion(major, minor);
    }

    public static void initContextProfile(int flags) {
        freeglutLibrary.glutInitContextProfile(flags);
    }

    public static void initContextFlags(int flags) {
        freeglutLibrary.glutInitContextFlags(flags);
    }

    public static void createWindow(String name) {
        freeglutLibrary.glutCreateWindow(name);
    }

    public static void setOption(int option, int value) {
        freeglutLibrary.glutSetOption(option, value);
    }

    public static void initWindowSize(int width, int height) {
        freeglutLibrary.glutInitWindowSize(width, height);
    }

    public static void initWindowPosition(int x, int y) {
        freeglutLibrary.glutInitWindowPosition(x, y);
    }

    public static void swapBuffers() {
        freeglutLibrary.glutSwapBuffers();
    }

    public static void mainLoop() {
        freeglutLibrary.glutMainLoop();
    }

    public static void setDisplayCallback(FreeglutLibrary.DisplayCallback displayCallback) {
        freeglutLibrary.glutDisplayFunc(displayCallback);
    }
}
