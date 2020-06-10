package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry {
	protected Color color;
	protected Material material;

	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param color
	 * @param material
	 */
	public Geometry(Color color,Material material) {
		super();
		this.color = color;
		this.material=new Material(material);
	}
	/**
	 * Default constructor 
	 */
	public Geometry() {
		super();
		this.color = new Color(0,0,0);
		this.material=new Material();
	}
	/**
	 * copy constractor
	 * @param other the object we want to copy
	 */
	public Geometry(Geometry other) {
		super();
		this.color = other.color;
		this.material=new Material(other.material);
	}
	

	// ***************** Getters/Setters ********************** // 

	/**
	 * return value
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * set value
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * return value
	 * @return material
	 */
	public Material getMaterial() {
		return new Material(material);
	}

	/**
	 * set value
	 * @param material
	 */
	public void setMaterial(Material material) {
		this.material = new Material(material);
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
		Geometry other = (Geometry) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Geometry [color=" + color + ", material=" + material + "]";
	}
	

	// ***************** Operations ******************** //
	/**
	 * abstract function
	 * @param point
	 * @return the normal
	 */
	public abstract Vector getNormal(Point3D point);
	

	/**
	 * abstract function
	 * @param ray
	 * @return a list of all the intersection, where the ray touched the geometry
	 */
	public abstract ArrayList<Point3D> findIntersections(Ray ray);
	
	/**
	 * abstract function
	 * @return color of geometry
	 */
	public Color getEmmission() {
				return this.getColor();
	}
	

}
