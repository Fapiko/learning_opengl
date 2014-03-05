package com.fapiko.jna.opengl.glew.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GLEnum {
    GL_VERTEX_SHADER(0x8B31);

    private final long value;
}