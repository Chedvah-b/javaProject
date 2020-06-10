package simpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

public class Point3DTest {

	@Test
	public void testAdd() {
		Point3D p1=new Point3D(1,1,1);
		Vector p2=new Vector(1,1,1);
		p1.add(p2);
		Point3D p3=new Point3D(2,2,2);
		assertEquals(p3,p1);
	}
	@Test
	public void testSubtract1() {
		Point3D p1=new Point3D(3,3,3);
		Vector p2=new Vector(1,1,1);
		p1.subtract(p2);
		Point3D p3=new Point3D(2,2,2);
		assertEquals(p3,p1);
	}
	
	@Test
	public void testSubtract2() {
		Point3D p1=new Point3D(3,3,3);
		Point3D p2=new Point3D(1,1,1);
		p1.subtract(p2);
		Point3D p3=new Point3D(2,2,2);
		assertEquals(p3,p1);
	}
}
