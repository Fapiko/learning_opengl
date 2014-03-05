package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.glew.types.GLEnum;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class GlewTest {
    @Test
    public void testCreateShader() {
        Glew glew = GlewFactory.getInstance();

        System.out.println(glew.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue()));
        System.out.println(glew.glGetError());

        assertNotEquals(0, glew.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue()));
    }
}
