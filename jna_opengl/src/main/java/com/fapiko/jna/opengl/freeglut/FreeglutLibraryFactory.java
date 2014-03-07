package com.fapiko.jna.opengl.freeglut;

import com.sun.jna.Native;
import org.apache.commons.lang.SystemUtils;

public class FreeglutLibraryFactory {
    private static FreeglutLibrary freeglut;

    public static FreeglutLibrary getInstance() {
        if (freeglut != null) {
            return freeglut;
        }

        String freeGlutPath;
        if (SystemUtils.IS_OS_WINDOWS) {
            freeGlutPath = "/freeglut/2.8.1-1/win64/bin/x64/freeglut.dll";
        } else {
            freeGlutPath = "/freeglut/2.8.1-1/linux/src/.libs/libglut.so";
        }

        freeglut = (FreeglutLibrary) Native.loadLibrary(freeGlutPath, FreeglutLibrary.class);

        return freeglut;
    }
}
