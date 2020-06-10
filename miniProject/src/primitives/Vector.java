package primitives;

public class Vector {
	
	protected Point3D head;
	
	// ***************** Constructors ********************** // 

	/**
	 * Constructor with parameters
	 * @param head
	 */
	public Vector(Point3D head) 
	{
		this.head = new Point3D(head);
	}
	/**
	 * Constructor with parameters
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x,double y,double z)
	{
		this.head=new Point3D(x, y, z);
	}

	/**
	 *  Default constructor 
	 */
	public Vector() {
		this.head=new Point3D();
	}
	/**
	 * copy constructor 
	 * @param v the object we want to copy
	 */
	public Vector(Vector v)
	{
		this.head=new Point3D(v.getHead());
	
	}
	/**
	 * Constructor with parameters
	 * @param p1 first point
	 * @param p2 second point
	 */
	public Vector(Point3D p1,Point3D p2)
	{
		Point3D newP=new Point3D(p1);
        newP.subtract(new Vector(p2));
        this.head = new Point3D(newP);
	}
	

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return head
	 */
	public Point3D getHead() {
		return head;
	}

	/**
	 * set value
	 * @param head
	 */
	public void setHead(Point3D head) {
		this.head = new Point3D(head);
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
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Vector [" + head + "]";
	}

	// ***************** Operations ******************** //
	/**
	 * add vector to vector
	 * @param vector
	 */
	public void add(Vector vector)
	{
		this.head.add(vector);
	}
	/**
	 * sub vector from vector
	 * @param vector
	 */
	public void subtract(Vector vector){
		this.head.subtract(vector);
		
	}
	/**
	 * add vector to vector
	 * @param vector
	 * @return result of adding
	 */
	public Vector addVector(Vector vector)
	{
		double x=this.head.x.getCordinate()+(vector.head.x.getCordinate());
		double y=this.head.y.getCordinate()+(vector.head.y.getCordinate());
		double z=this.head.z.getCordinate()+(vector.head.z.getCordinate());
		Vector ans=new Vector(x,y,z);
		return ans;
	}
	/**
	 * sub vector from vector
	 * @param vector
	 * @return  result of the sub
	 */
	public Vector subVector(Vector vector)
	{
		
		double x=this.head.x.getCordinate()-(vector.head.x.getCordinate());
		double y=this.head.y.getCordinate()-(vector.head.y.getCordinate());
		double z=this.head.z.getCordinate()-(vector.head.z.getCordinate());
		Vector ans=new Vector(x,y,z);
		return ans;
	}
	/**
	 * scalar product - multiplication vector and scale
	 * @param scalingFactor a number
	 */
	public void scale(double scalingFactor)
	{
		
		double x=this.head.getX().getCordinate()*scalingFactor;
		double y=this.head.getY().getCordinate()*scalingFactor;
		double z=this.head.getZ().getCordinate()*scalingFactor;
		this.setHead(new Point3D(x, y, z));
	}
	/**
	 * dot product between 2 vectors
	 * @param vector
	 * @return a new vector that is vertical to the other two
	 */
	public Vector crossProduct(Vector vector)
	{
		double x=this.getHead().getY().getCordinate()*vector.getHead().getZ().getCordinate()
				-this.getHead().getZ().getCordinate()*vector.getHead().getY().getCordinate();
		double y=this.getHead().getZ().getCordinate()*vector.getHead().getX().getCordinate()
				-this.getHead().getX().getCordinate()*vector.getHead().getZ().getCordinate();
		double z=this.getHead().getX().getCordinate()*vector.getHead().getY().getCordinate()
				-this.getHead().getY().getCordinate()*vector.getHead().getX().getCordinate();
		Vector ans=new Vector(x,y,z);
		return ans;
	}
	/**
	 * calculates the length of the vector
	 * @return the length
	 */
	public double length()
	{
		return (Math.sqrt(Math.pow(this.getHead().getX().getCordinate(),2)
				+Math.pow(this.getHead().getY().getCordinate(), 2)
				+Math.pow(this.getHead().getZ().getCordinate(), 2)));
	}
	/**
	 * reduces the vector so the length is 1
	 */
	public void normalize()
	{

		if (this.length()==0)
			return;
		double x=1/this.length();
		this.scale(x);
	}
	/**
	 * dot product between 2 vectors
	 * @param vector
	 * @return a number
	 */
	public double dotProduct(Vector vector)
	{
		return (this.getHead().getX().getCordinate()*vector.getHead().getX().getCordinate()
				+this.getHead().getY().getCordinate()*vector.getHead().getY().getCordinate()
				+this.getHead().getZ().getCordinate()*vector.getHead().getZ().getCordinate());
	}

}
