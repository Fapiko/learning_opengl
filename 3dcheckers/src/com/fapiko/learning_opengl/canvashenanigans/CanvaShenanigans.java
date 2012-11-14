package com.fapiko.learning_opengl.canvashenanigans;

import java.awt.*;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

public class CanvaShenanigans {

	public CanvaShenanigans() {

		SimpleUniverse universe = new SimpleUniverse();
		BranchGroup group = new BranchGroup();
//		group.addChild(new ColorCube(0.1));

		BranchGroup group2 = new BranchGroup();
		Sphere sphere = new Sphere(0.5f);
		group2.addChild(sphere);

		Color3f light1Color = new Color3f(1.8f, 0.1f, 0.1f);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		group2.addChild(light1);

		ColorCube cube = new ColorCube(0.1);
		TransformGroup tg = new TransformGroup();
		Transform3D transform = new Transform3D();
		Vector3f vector = new Vector3f(0.5f, 0f, 0f);
		transform.setTranslation(vector);
		tg.setTransform(transform);
		tg.addChild(cube);
		group.addChild(tg);

		Sphere sphere2 = new Sphere(0.1f);
		Appearance appearance = new Appearance();
		Color3f color = new Color3f(0.0f, 0.0f, 1.0f);
		ColoringAttributes ca = new ColoringAttributes(color, ColoringAttributes.NICEST);
		appearance.setColoringAttributes(ca);
//		sphere.setAppearance(appearance);
		TransformGroup tg2 = new TransformGroup();
		Transform3D transform2 = new Transform3D();
		Vector3f vector2 = new Vector3f(.5f, .5f, 0f);
		transform2.setTranslation(vector2);
		tg2.setTransform(transform2);
//		tg2.addChild(sphere2);
//		group.addChild(tg2);

		BranchGroup group3 = new BranchGroup();
		group2.addChild(sphere2);
//		group2.addChild(group);

		universe.getViewingPlatform().setNominalViewingTransform();
//		universe.addBranchGraph(group2);
		universe.addBranchGraph(group);
		universe.addBranchGraph(group3);

	}

}
