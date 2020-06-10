package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends RadialGeometry{
	protected Point3D axisPoint;
	protected Vector axisDirection;
	
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param radius
	 * @param axisPoint axis point
	 * @param axisDirection axis direction
	 */
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
		super(radius);
		this.axisPoint = new Point3D(axisPoint);
		this.axisDirection = new Vector(axisDirection);
	}
	

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return axisPoint
	 */
	public Point3D getAxisPoint() {
		return axisPoint;
	}
	/**
	 * set value
	 * @param axisPoint
	 */
	public void setAxisPoint(Point3D axisPoint) {
		this.axisPoint = new Point3D(axisPoint);
	}
	/**
	 * return value
	 * @return axisDirection
	 */
	public Vector getAxisDirection() {
		return axisDirection;
	}
	/**
	 * set value
	 * @param axisDirection
	 */
	public void setAxisDirection(Vector axisDirection) {
		this.axisDirection = new Vector(axisDirection);
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
		Cylinder other = (Cylinder) obj;
		if (axisDirection == null) {
			if (other.axisDirection != null)
				return false;
		} else if (!axisDirection.equals(other.axisDirection))
			return false;
		if (axisPoint == null) {
			if (other.axisPoint != null)
				return false;
		} else if (!axisPoint.equals(other.axisPoint))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Cylinder [axisPoint=" + axisPoint + ", axisDirection=" + axisDirection + "]";
	}

	// ***************** Operations ******************** //
	/**
	 * get normal 
	 */
	public  Vector getNormal(Point3D point)
	{
		return null;
	}
	
}
