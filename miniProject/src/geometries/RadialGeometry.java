package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class RadialGeometry extends Geometry{
	protected double radius;

	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param material
	 * @param color
	 * @param radius
	 */
	public RadialGeometry(Material material,Color color,double radius) {
		super(color,material);
		this.radius = radius;
	}
	/**
	 * Constructor with parameter
	 * @param radius
	 */
	public RadialGeometry(double radius) {
		super();
		this.radius = radius;
	}
	/**
	 * Default constructor
	 */
	public RadialGeometry() {
		super();
		this.radius = 0.0;
	}
	/**
	 * copy constractor
	 * @param other
	 */
	public RadialGeometry(RadialGeometry other) {
		super();
		this.radius = other.radius;
	}

	// ***************** Getters/Setters ********************** // 

	/**
	 * return value
	 * @return
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * set value
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
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
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "RadialGeometry [radius=" + radius + "]";
	}

	// ***************** Operations ******************** //
	/**
	 * 
	 */
	public Vector getNormal(Point3D p) {
		return null;
	}
	public ArrayList<Point3D> findIntersections(Ray ray) {
		return null;}
	
}
