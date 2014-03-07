package com.fapiko.gltut.tutorial1;

import com.fapiko.jna.opengl.freeglut.*;
import com.fapiko.jna.opengl.glew.Shader;

import java.util.EnumSet;
import java.util.Set;

public class HelloTriangle {
    public static void main(String[] args) {
        Freeglut.init(args.length, args);

        Set displayMode = EnumSet.of(
                DisplayMode.GLUT_DOUBLE,
                DisplayMode.GLUT_ALPHA,
                DisplayMode.GLUT_DEPTH,
                DisplayMode.GLUT_STENCIL
        );
        Freeglut.initDisplayMode(displayMode);
        Freeglut.initContextVersion(4, 3);
        Freeglut.initContextProfile(GLUT.CORE_PROFILE);
        Freeglut.initContextFlags(GLUT.DEBUG);
        Freeglut.initWindowPosition(300, 200);
        Freeglut.initWindowSize(500, 500);
        Freeglut.createWindow("Hello Triangle");
        Freeglut.setOption(GLUT.ACTION_ON_WINDOW_CLOSE, GLUT.ACTION_CONTINUE_EXECUTION);

        Shader vertexShader = new Shader();
    }
}
