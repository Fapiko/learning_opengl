package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.freeglut.Freeglut;
import com.fapiko.jna.opengl.types.GL;
import com.fapiko.jna.opengl.types.GLEnum;
import com.sun.jna.ptr.LongByReference;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GlewTest {

    private Glew glew = GlewFactory.getInstance();

    @BeforeClass
    public static void beforeClass() {
        Freeglut.init();
        Freeglut.createWindow("Test Sauce");
    }

    @Test
    public void testGlewInit() {
        assertEquals(0, glew.glewInit());
    }

    @Test
    public void testCreateShader() {
        glew.glewInit();

        assertNotEquals(0, glew.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue()));
    }
}
