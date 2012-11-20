package com.fapiko.learning_opengl.jogl2;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

public class ThenderRead extends GLCanvas implements GLEventListener, Runnable {

	private double theta = 0;
	private double s = 0;
	private double c = 0;
	private boolean shouldStop;

	public ThenderRead(GLCapabilities caps) {
		super(caps);
	}

	@Override
	public String toString() {
		return "arnold";
	}

	@Override
	public void run() {
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		this.addGLEventListener(new ThenderRead(caps));

		while (!shouldStop) {

			System.out.println("Running!");

			render();

			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void init(GLAutoDrawable drawable) {
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		update();
		render();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int i, int i1, int i2, int i3) {
	}

	private void update() {
		theta += 0.01;
		s = Math.sin(theta);
		c = Math.cos(theta);
	}

	private void render() {

		GL2 gl = null;

		try {
			gl = this.getGL().getGL2();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		if (gl != null) {

			gl.glClear(GL.GL_COLOR_BUFFER_BIT);

			// draw a triangle filling the window
			gl.glBegin(GL.GL_TRIANGLES);
			gl.glColor3f(1, 0, 0);
			gl.glVertex2d(-c, -c);
			gl.glColor3f(0, 1, 0);
			gl.glVertex2d(0, c);
			gl.glColor3f(0, 0, 1);
			gl.glVertex2d(s, -s);
			gl.glEnd();

		}
	}
}
