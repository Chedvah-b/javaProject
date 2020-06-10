package simpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightTest7 {
// Same as Part 6
	@Test
	public void SameTestAsPart6() {
		Scene scene = new Scene();
		
		scene.addGeometry(new Sphere(new Material(),Color.blue, 50, new Point3D(0.0, 0.0, -150)));
		
		Triangle triangle = new Triangle(new Material(),Color.red,new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(new Material(),Color.green,new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(new Material(),Color.orange,new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(new Material(),Color.pink,new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("shalav7", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();

		

	}
	
	@Test
	public void testAddingLightSources(){
		
		PointLight pl = new PointLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
							   0, 0.000001, 0.0000005));
		SpotLight sl = new SpotLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,  new Vector()));
		
		DirectionalLight dl = new DirectionalLight(new Color(255, 100, 100),new Vector());
		
	}

}
