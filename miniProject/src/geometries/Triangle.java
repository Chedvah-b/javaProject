package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Geometry implements FlatGeometry{
	protected Point3D p1;
	protected Point3D p2;
	protected Point3D p3;

	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param p1 first vertex of triangle
	 * @param p2 second vertex of triangle
	 * @param p3 third vertex of triangle
	 */
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		super();
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);

	}

	/**
	 * Constructor with parameters
	 * @param material
	 * @param color
	 * @param p1 first vertex of triangle
	 * @param p2 second vertex of triangle
	 * @param p3 third vertex of triangle
	 */
	public Triangle(Material material,Color color,Point3D p1, Point3D p2, Point3D p3) {
		super(color,material);
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);

	}

	/**
	 * Default constructor
	 */
	public Triangle() {
		super();
		this.p1 = new Point3D();
		this.p2 = new Point3D();
		this.p3 = new Point3D();
	}

	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Triangle(Triangle other) {
		super(other.color,other.material);
		this.p1 = new Point3D(other.getP1());
		this.p2 = new Point3D(other.getP2());
		this.p3 = new Point3D(other.getP3());
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return first vertex of triangle
	 */
	public Point3D getP1() {
		return p1;
	}
	/**
	 * set value
	 * @param p1 a 3d point
	 */
	public void setP1(Point3D p1) {
		this.p1 = new Point3D(p1);
	}
	/**
	 * return value
	 * @return second vertex of triangle
	 */
	public Point3D getP2() {
		return p2;
	}
	/**
	 * set value
	 * @param p2 a 3d point
	 */
	public void setP2(Point3D p2) {
		this.p2 = new Point3D(p2);
	}
	/**
	 * return value
	 * @return third vertex of triangle
	 */
	public Point3D getP3() {
		return p3;
	}
	/**
	 * set value
	 * @param p3 a 3d point
	 */
	public void setP3(Point3D p3) {
		this.p3 = new Point3D(p3);
	}

	// ***************** Administration  ******************** // 
	/**
	 * check if 2 variabels are equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}


	// ***************** Operations ******************** //
	
	/**
	 * return the triangles normal
	 * @param point not used
	 * @return the normal
	 */
	@Override
	public  Vector getNormal(Point3D point)
	{
		Vector v1 = new Vector(p1, p2);
		Vector v2 = new Vector(p1, p3);
		Vector v = v2.crossProduct(v1);
		v.normalize();
			
		return v;
	}


	/**
	 * returns a list of all the intersection between the ray and the triangle
	 * @param ray
	 * @return a list of all the intersection, where the ray touched the triangle
	 */
	@Override
	public ArrayList<Point3D> findIntersections (Ray ray)
	{	

		Vector v = this.getNormal(new Point3D(0, 0, 0));
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
		Plane p = new Plane(this.getMaterial(),this.getColor(),this.p1,v);
		intersectionPoints = p.findIntersections(ray);

		if (intersectionPoints.isEmpty())
		{
			return intersectionPoints; 
		}         
		Triangle tr1 = new Triangle(this.getMaterial(), this.getColor(), ray.getPoo(), p1, p2);
		Vector N1 = new Vector(tr1.getNormal(new Point3D()));
		Triangle tr2 = new Triangle(this.getMaterial(),this.getColor(),ray.getPoo(), p2, p3);
		Vector N2 = new Vector(tr2.getNormal(new Point3D()));
		Triangle tr3 = new Triangle(this.getMaterial(),this.getColor(), ray.getPoo(), p3, p1);
		Vector N3 = new Vector(tr3.getNormal(new Point3D()));

		Vector v1 = new Vector(intersectionPoints.get(0));
		Vector v2=new Vector(ray.getPoo());
		Vector sign=new Vector(v1.subVector(v2));
		if (((sign.dotProduct(N1) >= 0) && (sign.dotProduct(N2) >= 0) 
				&& (sign.dotProduct(N3) >= 0)) || ((sign.dotProduct(N1) < 0) && 
						(sign.dotProduct(N2) < 0) && (sign.dotProduct(N3) < 0))) 
		{
			return intersectionPoints;
		}

		intersectionPoints.clear();
		return intersectionPoints;  
	}
	
}
