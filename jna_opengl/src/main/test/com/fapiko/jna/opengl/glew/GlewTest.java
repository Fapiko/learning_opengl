package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.types.GLEnum;
import org.junit.Test;

public class GlewTest {
    @Test
    public void testCreateShader() {
        Glew glew = GlewFactory.getInstance();

        System.out.println(glew.glCreateShader(GLEnum.GL_VERTEX_SHADER));
    }
}
