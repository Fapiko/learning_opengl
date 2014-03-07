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
//        assertEquals(0, glew.glewInit());
    }

    @Test
    public void testCreateShader() {
        System.out.println(glew.glewInit());
        System.out.println(glew.glewGetString(1));
//        glew.__glewCreateShader(new Long(GLEnum.GL_VERTEX_SHADER.getValue()).intValue());
        System.out.println(glew.glCreateShader(new LongByReference(GLEnum.GL_VERTEX_SHADER.getValue())));
//
//        System.out.println(glew.__glewGetStringi(GL.VERSION, 0));
        System.out.println(glew.glGetError());

        assertNotEquals(0, glew.glCreateShader(new LongByReference(GLEnum.GL_VERTEX_SHADER.getValue())));
    }
}
