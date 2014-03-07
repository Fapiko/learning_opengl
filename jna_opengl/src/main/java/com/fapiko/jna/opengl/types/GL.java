package com.fapiko.jna.opengl.types;

public interface GL {
    public static final int VERSION = 0x1F02;

    /**
     * glGetShaderiv
     */
    public static final int COMPILE_STATUS = 0x8B81;
    public static final int DELETE_STATUS = 0x8B80;
    public static final int SHADER_TYPE = 0x8B4F;

    /**
     * Booleans
     */
    public static final int FALSE = 0;
    public static final int TRUE = 1;

    public static final int FLOAT = 0x1406;

    public static final int TRIANGLES = 4;
}
