package com.fapiko.jna.opengl.freeglut;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public enum DisplayMode {
    GLUT_RGB(0),
    GLUT_RGBA(0),
    GLUT_INDEX(1),
    GLUT_SINGLE(0),
    GLUT_DOUBLE(2),
    GLUT_ACCUM(4),
    GLUT_ALPHA(8),
    GLUT_DEPTH(0x10),
    GLUT_STENCIL(0x20),
    GLUT_MULTISAMPLE(0x80),
    GLUT_STEREO(0x100),
    GLUT_LUMINANCE(0x200);

    private final long value;

    public static int getValue(Set<DisplayMode> flags) {
        int value = 0;

        for (DisplayMode flag : flags) {
            value |= flag.getValue();
        }

        return value;
    }
}
