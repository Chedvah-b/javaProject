package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry{
	protected Point3D p1;
	protected Vector normal;

	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param material
	 * @param color
	 * @param p1 point on plane
	 * @param normal normal vector
	 */
	public Plane(Material material,Color color,Point3D p1, Vector normal) {
		super(color,material);
		this.p1 = new Point3D(p1);
		this.normal = new Vector(normal);
	}
	/**
	 * Constructor with parameters
	 * @param p1 point on plane
	 * @param normal normal vector
	 */
	public Plane(Point3D p1, Vector normal) {
		super();
		this.p1 = new Point3D(p1);
		this.normal = new Vector(normal);
	}
	/**
	 * Default constructor 
	 */
	public Plane() {
		super();
		this.p1 = new Point3D();
		this.normal = new Vector();
	}
	/**
	 * copy constractor
	 * @param other the object we want to copy
	 */
	public Plane(Plane other) {
		super();
		this.p1 = new Point3D(other.p1);
		this.normal = new Vector(other.normal);
	}


	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return p1 point on plane
	 */
	public Point3D getP1() {
		return p1;
	}
	/**
	 * set value
	 * @param p1 point on plane
	 */
	public void setP1(Point3D p1) {
		this.p1 = new Point3D(p1);
	}
	/**
	 * return value
	 * @return normal normal of plane
	 */
	public Vector getNormal() {
		return normal;
	}
	/**
	 * set value
	 * @param normal normal of plane
	 */
	public void setNormal(Vector normal) {
		this.normal = new Vector(normal);
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
		Plane other = (Plane) obj;
		if (normal == null) {
			if (other.normal != null)
				return false;
		} else if (!normal.equals(other.normal))
			return false;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Plane [p1=" + p1 + ", normal=" + normal + "]";
	}

	// ***************** Operations ******************** //
	/**
	   * return the normal of the geometry at the given point
	   * @param point - point on geometry to get the normal
	   * @return  vector - normal to plane
	   */
	public  Vector getNormal(Point3D point)
	{
		normal.normalize();
		return this.getNormal();
	}


	/**
	* return a list of intersection points between the plane and ray
	* @param ray - ray to get the intersection points
	* @return list of intersection point according to ray on plane
	 */
	public ArrayList<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
		Vector direction = new Vector(ray.getDirection());//
		double mechane = direction.dotProduct(normal);//V*N
		if (mechane != 0) 
		{
			Vector P0 = new Vector(ray.getPoo());//P0
			P0.subtract(new Vector(this.p1));//P0-Q0
			double t = -(normal.dotProduct(P0) / mechane);//-n*(p0-q0)\V*N
			direction.scale(t);
			Point3D newPoint = new Point3D(direction.getHead());
			Point3D p = new Point3D(ray.getPoo());
			p.add(newPoint);
			if(t<0)
				return intersectionPoints;
			
			intersectionPoints.add(p);

		}
		return intersectionPoints;		
	}

}
