package com.fapiko.jna.opengl.freeglut;

public interface FreeGlut {
    public void glutInit(int argCount, String[] arguments);
    public void glutInitWindowPosition(int x, int y);
    public void glutInitWindowSize(int width, int height);
}
