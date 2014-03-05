package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.Native;
import org.apache.commons.lang.SystemUtils;

public class FreeGlutFactory {
    private static FreeGlut freeGlut;

    public static FreeGlut getInstance() {
        if (freeGlut != null) {
            return freeGlut;
        }

        String freeGlutPath = "freeglut";
        if (SystemUtils.IS_OS_WINDOWS) {
            freeGlutPath = "/freeglut/2.8.1-1/win64/bin/x64/freeglut.dll";
        }

        freeGlut = (FreeGlut) Native.loadLibrary(freeGlutPath, FreeGlut.class);

        return freeGlut;
    }
}
