package com.fapiko.jna.opengl.freeglut;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FreeGlutFactoryTest {
    @Test
    public void testGetInstance() {
        FreeglutLibrary freeGlut = FreeglutLibraryFactory.getInstance();

        assertNotNull(freeGlut);
    }
}
