package primitives;

public class Coordinate {
	protected double cordinate;
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameter
	 * @param cordinate
	 */
	public Coordinate(double cordinate) {
		this.cordinate = cordinate;
	}
	/**
	 * Default constructor
	 */
	public Coordinate() {
		this.cordinate = 0;
	}
	/**
	 * Copy constructor
	 * @param other the object we want to copy
	 */
	public Coordinate(Coordinate other) {
		this.cordinate = other.getCordinate();
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * returns the coordinate
	 * @return coordinate
	 */
	public double getCordinate() {
		return cordinate;
	}
	/**
	 * set the coordinate
	 * @param cordinate
	 */
	public void setCordinate(double cordinate) {
		this.cordinate = cordinate;
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
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(cordinate) != Double.doubleToLongBits(other.cordinate))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "(" + cordinate + ")";
	}

	// ***************** Operations ******************** //
	/**
	 * adds one coordinate to another
	 * @param other the coordinate you want to add
	 */
	public void add(Coordinate other)
	{		
		 this.cordinate+=other.getCordinate();
	}
	/**
	 * subtracts one coordinate to another
	 * @param other the coordinate you want to subtract
	 */
	public void subtract(Coordinate other)
	{
		this.cordinate-=other.getCordinate();
	}

}
