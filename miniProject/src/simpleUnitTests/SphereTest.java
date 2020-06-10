package simpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

public class SphereTest {

	@Test
	public void testGetNormal() {
		Sphere s=new Sphere(1,new Point3D(3,4,5));
		Point3D p=new Point3D(2,4,6);
		Vector v=new Vector();
		v=s.getNormal(p);
		Vector ans=new Vector((-1)/Math.sqrt(2),0,1/Math.sqrt(2));
		assertEquals(ans,v);

	}

}
