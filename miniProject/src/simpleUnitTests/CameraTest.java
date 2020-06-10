package simpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {
	
	
	@Test
	 public void testConstructRay1() {
	    
	    Vector vup = new Vector(0, 1, 0);
	    Vector vto = new Vector(0, 0, -1);
	    Point3D p0 = new Point3D();
	    Camera camera = new Camera(p0, vup, vto);
	    
	    Ray ray = camera.constructRayThroughPixel(3, 3, 3.0, 3.0, 100, 150, 150);
	    Point3D centerPoint = new Point3D(100,-100,-100);
	    Vector direction = new Vector(0.5773502691896258, -0.5773502691896258, -0.5773502691896258);
	    
	    Ray answer = new Ray(centerPoint, direction);
	    assertEquals(answer, ray);
	  }
	
	
}
	