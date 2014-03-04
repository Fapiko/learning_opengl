package com.fapiko.jna.opengl.glew;

import com.sun.jna.Native;

public class GlewFactory {
    private static Glew glew;

    public static Glew getInstance() {
        if (glew == null) {
            return glew;
        }

        glew = (Glew) Native.loadLibrary("/lib/glew/1.10.0/win32/bin/Release/x64/glew32.dll", Glew.class);

        return glew;
    }
}
