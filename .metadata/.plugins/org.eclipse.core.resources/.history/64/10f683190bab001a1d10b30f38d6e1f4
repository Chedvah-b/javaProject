package primitives;

public class Ray extends Vector {
	protected Point3D poo;
	protected Vector direction;
	
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param poo
	 * @param direction
	 */
	public Ray(Point3D poo, Vector direction) {
		super();
		this.poo = new Point3D(poo);
		this.direction = new Vector(direction);
		this.direction.normalize();
	}
	/**
	 * Default constructor 
	 */
	public Ray() {
		super();
		this.poo = new Point3D(0,0,0);
		this.direction = new Vector(0,0,0);
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Ray(Ray other) {
		super();
		this.poo = new Point3D(other.getPoo());
		this.direction = new Vector(other.getDirection());
		this.direction.normalize();
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return poo point of origin
	 */
	public Point3D getPoo() {
		return poo;
	}
	/**
	 * set value
	 * @param poo point of origin
	 */
	public void setPoo(Point3D poo) {
		this.poo = new Point3D(poo);
	}
	/**
	 * return value
	 * @return direction direction of ray
	 */
	public Vector getDirection() {
		return direction;
	}
	/**
	 * set value
	 * @param direction direction of ray
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
		Ray other = (Ray) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (poo == null) {
			if (other.poo != null)
				return false;
		} else if (!poo.equals(other.poo))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Ray [poo=" + poo + ", direction=" + direction + "]";
	}
}
