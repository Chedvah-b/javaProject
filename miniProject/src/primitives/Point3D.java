package primitives;

public class Point3D extends Point2D{
	protected Coordinate z;

	// ***************** Constructors ********************** // 
	/**
	 * constractor with parameters
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x,y);
		this.z = new Coordinate(z);
	}
	
	/**
	 * constructor with parameters
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x, double y,double z) 
	{
		super(new Coordinate(x),new Coordinate(y) );
		this.z=new Coordinate(z);
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Point3D(Point3D other) {
		super(other.x,other.y);
		this.setZ(other.getZ());
	}
	/**
	 *  Default constructor 
	 */
	public Point3D() {
		super();
		this.z = new Coordinate(0);
	}
	

	// ***************** Getters/Setters ********************** // 

	/**
	 * return value
	 * @return z
	 */
	public Coordinate getZ() {
		//return new Coordinate(z);
		return z;
	}

	/**
	 * set value
	 * @param z
	 */
	public void setZ(Coordinate z) {
		this.z = new Coordinate(z);
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
		Point3D other = (Point3D) obj;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Point3D (" + x + " " + y  +"" + z + ")";
	}

	// ***************** Operations ******************** //
	/**
	 * add vector to point3D
	 * @param vector
	 */
	public void add(Vector vector){
		this.getX().add(vector.getHead().getX());
		this.getY().add(vector.getHead().getY());
		this.getZ().add(vector.getHead().getZ());
	}
	/**
	 * add point3D to point3D
	 * @param point 3d
	 */
	public void add(Point3D point){
		this.getX().add(point.getX());
		this.getY().add(point.getY());
		this.getZ().add(point.getZ());
	}
	/**
	 * sub vector from point3D
	 * @param vector
	 */
	public void subtract(Vector vector){
		this.getX().subtract(vector.getHead().getX());
		this.getY().subtract(vector.getHead().getY());
		this.getZ().subtract(vector.getHead().getZ());
		
	}
	/**
	 * sub point3D from point3D
	 * @param point 3d
	 */
	public void subtract(Point3D point){
		this.getX().subtract(point.getX());
		this.getY().subtract(point.getY());
		this.getZ().subtract(point.getZ());
		
	}
	
	/**
	 * calculates the distance between 2 point
	 * @param point
	 * @return the distance between 2 point
	 */
	public double distance(Point3D point) {
		double distance=Math.sqrt(Math.pow(point.getX().getCordinate()-this.getX().getCordinate(),2)+
		        Math.pow(point.getY().getCordinate()-this.getY().getCordinate(),2)+
		        Math.pow(point.getZ().getCordinate()-this.getZ().getCordinate(),2));
		    return distance;
	}
	

}
     