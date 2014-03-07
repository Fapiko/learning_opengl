package com.fapiko.jna.opengl.microsoft_opengl;

import com.fapiko.jna.opengl.types.GL;
import com.fapiko.jna.opengl.types.GLEnum;
import com.sun.jna.Native;
import org.junit.Test;

public class OpenGLTest {
    @Test
    public void testCreateProgram() {
        OpenGL openGL = (OpenGL) Native.loadLibrary("/opengl32.dll", OpenGL.class);
        System.out.println(openGL.glGetString(GL.VERSION));
        openGL.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue());

    }
}
