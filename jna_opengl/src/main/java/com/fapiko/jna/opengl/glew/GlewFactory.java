package com.fapiko.jna.opengl.glew;

import com.sun.jna.Native;
import org.apache.commons.lang.SystemUtils;

public class GlewFactory {
    private static Glew glew;

    public static Glew getInstance() {
        if (glew != null) {
            return glew;
        }

        String glewPath;
        if (SystemUtils.IS_OS_WINDOWS) {
            glewPath = "/glew/1.10.0/win32/bin/Release/x64/glew32.dll";
        } else  {
            glewPath = "/glew/1.10.0/linux/lib/libGLEW.so";
        }

        glew = (Glew) Native.loadLibrary(glewPath, Glew.class);

        return glew;
    }
}
