package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry{
	protected Point3D center;

	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param material
	 * @param color
	 * @param radius
	 * @param center
	 */
	public Sphere(Material material,Color color,double radius, Point3D center) {
		super(material,color,radius);
		this.center = new Point3D(center);
	}
	/**
	 * Constructor with parameters
	 * @param radius
	 * @param center
	 */
	public Sphere(double radius, Point3D center) {
		super(radius);
		this.center = new Point3D(center);
	}
	/**
	 * Default constructor
	 */
	public Sphere() {
		super();
		this.center = new Point3D();
	}
	/**
	 * copy constractor
	 * @param other the object we want to copy
	 */
	public Sphere(Sphere other) {
		super(other.material,other.color,other.radius);
		this.center = new Point3D(other.center);
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return center
	 */
	public Point3D getCenter() {
		return center;
	}
	/**
	 * set value
	 * @param center
	 */
	public void setCenter(Point3D center) {
		this.center = new Point3D(center);
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
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Sphere [center=" + center + "]";
	}

	// ***************** Operations ******************** //
	/**
	   * return the normal of the geometry at the given point
	   * @param point - point on geometry to get the normal
	   * @return  vector - normal to plane
	   */
	@Override
	public Vector getNormal (Point3D p)
	{

		 Point3D point = new Point3D(p);
	     point.subtract(this.getCenter());
	     Vector v = new Vector(point);
	     v.normalize();
	     return v;
	
	}
	/**
	* return a list of intersection points between the plane and ray
	* @param ray - ray to get the intersection points
	* @return list of intersection point according to ray on plane
	 */
	public ArrayList<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
	  	//Point3D p= null;
	  	Vector O = new Vector(center);//O
	  	Vector p0 = new Vector(ray.getPoo());//P0
	  	Vector L = new Vector(O.subVector(p0));//O-p0
	  	double tm = L.dotProduct(ray.getDirection());//tm=l*v
	    double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));//(|L|^2+tm^2)^0.5
	    if (d > this.getRadius()) //אם הנקודה מחוץ למעגל זה גדול מהרדיוס
	    {
	        return intersectionPoints;
	    }
	    else
	    {
		    double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));//(r^2-t^2)^0.5
		    double t1 = tm - th;
		    double t2 = tm + th;
		    if (t1 > 0) 
		    {
		        Vector direct = new Vector(ray.getDirection());
		        direct.normalize();
		        direct.scale(t1);
		        Point3D P1 = new Point3D(ray.getPoo());
		        P1.add(new Vector(direct));
		       
		        intersectionPoints.add(P1);
		     }
		    
		     if (t2 > 0) 
		     {
		        Vector dirc = new Vector(ray.getDirection());
		        dirc.normalize();
		        dirc.scale(t2);
		        Point3D P2 = new Point3D(ray.getPoo());
		        P2.add(new Vector(dirc));
		     
		        intersectionPoints.add(P2);
		     }
		   return intersectionPoints;
		 }

	}
	

}
