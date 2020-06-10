package primitives;

public class Point2D {
	protected Coordinate x;
	protected Coordinate y;
	
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param x
	 * @param y
	 */
	public Point2D(Coordinate x, Coordinate y) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
	}
	/**
	 *  Default constructor 
	 */
	public Point2D( ) {
		this.x = new Coordinate(0);
		this.y = new Coordinate(0);
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Point2D(Point2D other) {
		this.x = new Coordinate(other.getX());
		this.y = new Coordinate(other.getY());
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return x
	 */
	public Coordinate getX() {
	//	return new Coordinate(x);
		return x;
	}
	/**
	 * set value
	 * @param x
	 */
	public void setX(Coordinate x) {
		this.x = new Coordinate(x);
	}
	/**
	 * return value
	 * @return y
	 */
	public Coordinate getY() {
		//return new Coordinate (y);
		return y;
	}
	/**
	 * set value
	 * @param y
	 */
	public void setY(Coordinate y) {
		this.y = new Coordinate(y);
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
		Point2D other = (Point2D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Point2D (" + x + ", " + y + ")";
	}
	
	

}
