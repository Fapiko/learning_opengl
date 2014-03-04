package com.fapiko.jna.opengl.glew;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GlewFactoryTest {
    @Test
    public void testGetInstance() {
        assertNotNull(GlewFactory.getInstance());
    }
}
