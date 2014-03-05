package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class GlutTest {
    @Test
    public void testGlutInit() {
        FreeGlut glut = FreeGlutFactory.getInstance();

        glut.glutInit(new IntByReference(1), new StringArray(new String[] { "java" }));
        // No exception thrown is good enough
    }

    @Test
    public void testGlutInitDisplayMode() {
        FreeGlut glut = FreeGlutFactory.getInstance();

        Set displayMode = EnumSet.of(
                DisplayMode.GLUT_DOUBLE,
                DisplayMode.GLUT_ALPHA,
                DisplayMode.GLUT_DEPTH,
                DisplayMode.GLUT_STENCIL
        );

        glut.glutInitDisplayMode(DisplayMode.getValue(displayMode));
    }
}
