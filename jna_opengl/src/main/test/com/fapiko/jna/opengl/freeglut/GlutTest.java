package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GlutTest {
    @Test
    public void testGlut() {
        FreeGlut glut = FreeGlutFactory.getInstance();

        glut.glutInit(new IntByReference(1), new StringArray(new String[] { "java" }));
        // No exception thrown is good enough
    }
}
