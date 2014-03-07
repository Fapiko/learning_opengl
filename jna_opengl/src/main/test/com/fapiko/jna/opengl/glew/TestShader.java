package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.freeglut.Freeglut;
import com.google.common.io.Files;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TestShader {

    @BeforeClass
    public static void setUp() {
        Freeglut.init();
        Freeglut.createWindow("Test Shader");
    }

    @Test
    public void testShader() throws URISyntaxException, IOException {
        Shader shader = new Shader(Shader.VERTEX_SHADER, "/com/fapiko/jna/opengl/glew/vertexShader.vert");
        assertNotEquals(0, shader.getShaderIndex());
    }
}
