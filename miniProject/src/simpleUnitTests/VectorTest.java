package simpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Vector;

public class VectorTest {

	@Test
	public void testAdd() {
		Vector v1=new Vector(1.0,1.0,1.0);
		Vector v2=new Vector(2.0,2.0,2.0);
		v1.add(v2);
		Vector v3=new Vector(3.0,3.0,3.0);
		assertEquals(v3,v1);
		Vector v4=new Vector(3,4,5);
		Vector v5=new Vector(-1,-2,-3);
		v4.add(v5);
		Vector v6=new Vector(2,2,2);
		assertEquals(v6,v4);
		
		Vector v7=new Vector(3,5,8);
		Vector v8=new Vector(2,5,3);
		Vector v9=new Vector(v7.addVector(v8));
		Vector v10=new Vector(5,10,11);
		assertEquals(v10,v9);
	}
	
	@Test
	public void testAddVector() {
		Vector v1=new Vector(1.0,1.0,1.0);
		Vector v2=new Vector(2.0,2.0,2.0);
		Vector v3=new Vector(v1.addVector(v2));
		Vector v4=new Vector(3.0,3.0,3.0);
		assertEquals(v4,v3);
	}
	
	@Test
	public void testSubtract() {
		Vector v1=new Vector(5.0,5.0,5.0);
		Vector v2=new Vector(2.0,2.0,2.0);
		v1.subtract(v2);
		Vector v3=new Vector(3.0,3.0,3.0);
		assertEquals(v3,v1);
	}
	
	@Test
	public void testScaling() {
		Vector v1=new Vector(5.0,5.0,5.0);
		Vector v2=new Vector(10.0,10.0,10.0);
		v1.scale(2);
		assertEquals(v2,v1);
		Vector v3=new Vector(-10,-10,-10);
		v1.scale(-1);
		assertEquals(v3,v1);
	}
	
	@Test
	public void testDotProduct () {
		Vector v1=new Vector(5.0,5.0,5.0);
		Vector v2=new Vector(2.0,2.0,2.0);
		double ans=v1.dotProduct(v2);
		if(ans==30)
		{
			assertTrue(true);
		}
		else
		{
			fail("not working");
		}
	}
	////////////////////////////////////////
	@Test
	public void testLength () {
		Vector v1=new Vector(3.0,4.0,5.0);
		double ans=v1.length();
		if(ans==Math.sqrt(50))
		{
			assertTrue(true);
		}
		else
		{
			fail("not working");
		}
	}
	
	@Test
	public void testNormalize  () {
		Vector v1=new Vector(5.0,5.0,5.0);
		double ans=v1.length();
		v1.normalize();
		Vector v2=new Vector(5.0/ans,5.0/ans,5.0/ans);
		assertEquals(v2,v1);
	}
	
	@Test
	public void testCrossProduct () {
		Vector v1=new Vector(5.0,5.0,5.0);
		Vector v2=new Vector(2.0,2.0,2.0);
		Vector v3=new Vector(v1.crossProduct(v2));
		Vector v4=new Vector(0.0,0.0,0.0);
		assertEquals(v4,v3);
		
		Vector v5=new Vector(2,4,6);
		Vector v6=new Vector(5,2,8);
		Vector v7=new Vector(v5.crossProduct(v6));
		Vector v8=new Vector(v6.crossProduct(v5));
		v8.scale(-1);
		assertEquals(v7,v8);
	}
	
	
	

}
