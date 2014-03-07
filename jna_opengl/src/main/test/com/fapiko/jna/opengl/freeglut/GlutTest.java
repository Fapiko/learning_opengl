package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GlutTest {
    private FreeglutLibrary glut = FreeglutLibraryFactory.getInstance();

    @Test
    public void testGlutInit() {
        glut.glutInit(new IntByReference(1), new StringArray(new String[] { "java" }));
    }

    @Test
    public void testGlutInitDisplayMode() {
        Set displayMode = EnumSet.of(
                DisplayMode.GLUT_DOUBLE,
                DisplayMode.GLUT_ALPHA,
                DisplayMode.GLUT_DEPTH,
                DisplayMode.GLUT_STENCIL
        );

        glut.glutInitDisplayMode(DisplayMode.getValue(displayMode));
    }

    @Test
    public void testGlutInitContextVersion() {
        glut.glutInitContextVersion(4, 3);
    }

    @Test
    public void testGlutInitContextProfile() {
        glut.glutInitContextProfile(GLUT.CORE_PROFILE);
    }

    @Test
    public void testGlutInitContextFlags() {
        glut.glutInitContextFlags(GLUT.DEBUG);
    }

    @Test
    public void testGlutInitWindowSize() {
        glut.glutInitWindowSize(500, 600);
    }

    @Test
    public void testGlutInitWindowPosition() {
        glut.glutInitWindowPosition(300, 300);
    }

    @Test
    public void testGlutCreateWindow() {
        assertEquals(1, glut.glutCreateWindow("Arnold Facepalmer"));
    }

//    @Test
//    public void testGlutSetOption() {
//        glut.glutSetOption(GLUT.ACTION_ON_WINDOW_CLOSE, GLUT.ACTION_CONTINUE_EXECUTION);
//    }
}
