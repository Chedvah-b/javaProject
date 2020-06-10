package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light{
	protected Vector direction;

	// ***************** Constructors ********************** // 
	/**
	 *  Constructor with parameters
	 * @param color
	 * @param direction directionof light
	 */
	public DirectionalLight(Color color, Vector direction) {
		super(color);
		this.direction = new Vector(direction);
	}
	/**
	 * default constructor
	 */
	public DirectionalLight() {
		super();
		this.direction = new Vector(0,0,1);
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public DirectionalLight(DirectionalLight other) {
		super(other.color);
		this.direction = new Vector(other.direction);
	}
	
	// ***************** Getters/Setters ********************** // 
/**
 * get value
 * @return direction of light
 */
	public Vector getDirection() {
		return new Vector(direction);
	}
	/**
	 * set value
	 * @param direction direction of light
	 */
	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}
	
	// ***************** Administration  ******************** // 
		/**
		 * check if 2 variabels are equals
		 */
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "DirectionalLight [direction=" + direction + "]";
	}
	// ***************** Operations ******************** //

	/**
	 * returns intensity of light (тецод)
	 * @param point not used
	 * @return color the color of body
	 */
	public  Color getIntensity(Point3D point)
	{
		return this.color;
	}
	/**
	 * returns a vector from light to point
	 * @param point not used
	 * @return normalized direction
	 */
	public Vector getL(Point3D point)
	{
		Vector v= new Vector(this.direction);
		v.normalize();
		return new Vector(v);
	}	
	
}
