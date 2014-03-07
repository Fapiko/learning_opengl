package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.freeglut.Freeglut;
import com.fapiko.jna.opengl.types.GL;
import com.fapiko.jna.opengl.types.GLEnum;
import com.google.common.io.Files;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
        assertNotEquals(0, glew.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue()));
    }

    @Test
    public void testGlCreateShaderLoop() throws IOException, URISyntaxException {
        String shader = Files.toString(
                new File(GlewTest.class.getResource("/com/fapiko/jna/opengl/glew/vertexShader.vert").toURI()),
                Charset.defaultCharset()
        );

        assertNotNull(shader);

        int shaderIndex = glew.glCreateShader(GLEnum.GL_VERTEX_SHADER.getValue());
        glew.glShaderSource(shaderIndex, 1, new String[] { shader }, new int[] { shader.length() });
        glew.glCompileShader(shaderIndex);

        IntByReference shaderCompileStatus = new IntByReference();
        glew.glGetShaderiv(shaderIndex, GL.COMPILE_STATUS, shaderCompileStatus);
        assertEquals(1, shaderCompileStatus.getValue());
    }
}
