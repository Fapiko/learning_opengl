package com.fapiko.gltut.tutorial1.jogl;

import javax.media.opengl.GL4;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloTriangle {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello Triangle");
        GLProfile.initSingleton();
        GLProfile glProfile = GLProfile.get(GLProfile.GL4);
        GLCanvas canvas = new GLCanvas(new GLCapabilities(glProfile));

        frame.add(canvas);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        GL4 gl = canvas.getGL().getGL4();

        int vertexShader = gl.glCreateShader(GL4.GL_VERTEX_SHADER);
        int fragmentShader = gl.glCreateShader(GL4.GL_FRAGMENT_SHADER);
    }
}
