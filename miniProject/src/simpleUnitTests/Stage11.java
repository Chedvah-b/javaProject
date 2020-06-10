package simpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import org.junit.Test;

public class Stage11 {

	@Test
	  public void myTest(){
		  Scene scene = new Scene();
		    scene.setscreenDistance(200);
		    scene.setBackground(Color.pink);

		    Sphere sphere = new Sphere(new Material (),Color.red, 500, new Point3D(0.0, 0.0, -1000));
		    Material material = new Material();
		    material.setnShininess(40);
		    material.setKt(0.9);
		    sphere.setMaterial(new Material(material));  
		    scene.addGeometry(sphere);

		    Sphere sphere2 = new Sphere(new Material (),Color.blue, 375, new Point3D(0.0, 0.0, -1000));
		    material.setKt(0.75);
		    sphere2.setMaterial(new Material(material));
		    scene.addGeometry(sphere2);

		    Sphere sphere3 = new Sphere(new Material (),Color.black, 175, new Point3D(0.0, 0.0, -1000));
		    material.setKt(1);
		    sphere2.setMaterial(new Material(material));
		    scene.addGeometry(sphere3);

		    Triangle triangle = new Triangle(/*new Material(), Color.orange,*/new Point3D(  3500,  3500, -2000),
		        new Point3D( -3500, -3500, -1000),
		        new Point3D(  3500, -3500, -2000));

		    Triangle triangle2 = new Triangle(/*new Material(), Color.orange,*/new Point3D(  3500,  3500, -2000),
		        new Point3D( -3500,  3500, -1000),
		        new Point3D( -3500, -3500, -1000));

		    scene.addGeometry(triangle);
		    scene.addGeometry(triangle2);

		    
		    scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
		            0, 0.000001, 0.0000005,  new Vector(-2, -2, -3)));


		        
		    ImageWriter imageWriter = new ImageWriter("my test", 500, 500, 500, 500);

		    Render render = new Render(scene, imageWriter);

		    render.renderImage2();
		    //render.printGrid(50);
		    imageWriter.writeToimage();
		  }

}
