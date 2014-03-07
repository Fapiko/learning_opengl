package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.freeglut.DisplayMode;
import com.fapiko.jna.opengl.types.GL;
import com.fapiko.jna.opengl.types.GLEnum;
import org.junit.Test;
import com.fapiko.jna.opengl.glew.TestLibrary;

public class TestLibraryTest {
    @Test
    public void testTestLibrary() {
        System.out.println(TestLibrary.INSTANCE.glewInit());
//        TestLibrary.INSTANCE.PFNGLCREATESHADERPROC(GLEnum.GL_VERTEX_SHADER.getValue());
    }
}
