package com.fapiko.jna.opengl.glew;

import com.sun.jna.*;
import com.sun.jna.ptr.LongByReference;
import org.apache.commons.lang.SystemUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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

        Map options = new HashMap<String, Object>();
        options.put(Library.OPTION_CALLING_CONVENTION, Function.C_CONVENTION);
        /*options.put("invocation-mapper",
            new InvocationMapper() {
                @Override
                public InvocationHandler getInvocationHandler(NativeLibrary lib, Method m) {
                    System.out.println(m.getName());
                    if (m.getName().equals("glCreateShader")) {
                        final Function f = lib.getFunction("__glewCreateShader");
                        return new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                LongByReference[] newArgs = new LongByReference[1];
                                newArgs[0] = (LongByReference)args[0];
                                f.invokeInt(newArgs);
                                return null;
                            }
                        };
//                        return f;
                    }
                    return null;
                }
            }
        );*/
//        glew = (GlewLibrary)Native.loadLibrary(glewPath, GlewLibrary.class, options);
        glew = new Glew();


        return glew;
    }
}
