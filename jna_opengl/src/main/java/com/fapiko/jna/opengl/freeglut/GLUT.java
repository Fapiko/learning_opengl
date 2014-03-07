package com.fapiko.jna.opengl.freeglut;

public class GLUT {
    /**
     * glutInitContextProfile
     */
    public static int CORE_PROFILE = 1;
    public static int COMPATABILITY_PROFILE = 2;

    /**
     * glutInitContextFlags
     */
    public static int DEBUG = 1;
    public static int FORWARD_COMPATIBLE = 2;

    /**
     * glutSetOption and glutGet
     */
    public static int INIT_STATE = 0x7C;
    public static int ACTION_ON_WINDOW_CLOSE = 0x1F9;
    public static int WINDOW_BORDER_WIDTH = 0x1FA;
    public static int WINDOW_BORDER_HEIGHT = 0x1FB;
    public static int VERSION = 0x1FC;
    public static int RENDERING_CONTEXT = 0x1FD;
    public static int DIRECT_RENDERING = 0x1FE;
    public static int FULL_SCREEN = 0x1FF;
    public static int SKIP_STALE_MOTION_EVENTS = 0x204;

    // Window exit actions
    public static int ACTION_EXIT = 0;
    public static int ACTION_GLUTMAINLOOP_RETURNS = 1;
    public static int ACTION_CONTINUE_EXECUTION = 2;
}
