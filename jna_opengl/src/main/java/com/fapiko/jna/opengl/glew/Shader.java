package com.fapiko.jna.opengl.glew;

import com.fapiko.jna.opengl.types.GL;
import com.google.common.io.Files;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class Shader {
    public static final int COMPILE_STATUS = 0x8B81;
    public static final int DELETE_STATUS = 0x8B80;
    public static final int SHADER_TYPE = 0x8B4F;
    public static final int FRAGMENT_SHADER = 0x8B30;
    public static final int VERTEX_SHADER = 0x8B31;

    private int shaderIndex;
    private int shaderType;

    public Shader(int shaderType, String shaderUri) {
        String shaderSource = null;
        try {
            shaderSource = Files.toString(new File(Shader.class.getResource(shaderUri).toURI()),
                    Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        shaderIndex = Glew.glCreateShader(shaderType);
        if (shaderIndex == 0) {
            try {
                throw new Exception("Unable to create shader");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Glew.glShaderSource(
                shaderIndex,
                1,
                new StringArray(new String[] { shaderSource }),
                new int[] { shaderSource.length() }
        );
        Glew.glCompileShader(shaderIndex);

        if (!getShaderParameter(shaderIndex, COMPILE_STATUS)) {
            try {
                throw new Exception("Unable to compile shader");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean getShaderParameter(int shaderIndex, int parameterName) {
        IntByReference status = new IntByReference();
        Glew.glGetShaderiv(shaderIndex, parameterName, status);

        if (status.getValue() == GL.TRUE) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getShaderiv(int shaderIndex, int parameterName) {
        return getShaderParameter(shaderIndex, parameterName);
    }

    public int getShaderIndex() {
        return shaderIndex;
    }

}
