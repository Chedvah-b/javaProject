package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light{
	protected Point3D position;
	protected double kc;
	protected double kl;
	protected double kq;
	
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameter
	 * @param color
	 * @param position where light is placed
	 * @param kc attenuation factor
	 * @param kl attenuation factor
	 * @param kq attenuation factor
	 */
	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
		super(color);
		this.position = new Point3D(position);
		if (kc>1) 
			this.kc=1;
		else if (kc<0)
			this.kc=0;
		else
			this.kc = kc;
		
		if (kl>1) 
			this.kl=1;
		else if (kl<0) 
			this.kl=0;
		else
			this.kl = kl;

		if (kq>1) 
			this.kq=1;
		else if (kq<0) 
			this.kq=0;
		else
			this.kq = kq;
		
	}
	/**
	 * default constructor
	 */
	public PointLight() {
		super();
		this.position = new Point3D();
		this.kc = 0;
		this.kl = 0.5;
		this.kq = 0.1;
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public PointLight(PointLight other) {
		super(other.color);
		this.position = new Point3D(other.position);
		if (other.kc>1) 
			this.kc=1;
		else if (other.kc<0) 
			this.kc=0;
		else
			this.kc = other.kc;
		
		if (other.kl>1) 
			this.kl=1;
		else if (other.kl<0) 
			this.kl=0;
		else
			this.kl = other.kl;
		
		if (other.kq>1) 
			this.kq=1;
		else if (other.kq<0) 
			this.kq=0;
		else
			this.kq = other.kq;	

	}
	
	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return position where light is situated
	 */
	public Point3D getPosition() {
		return new Point3D(position);
	}
	/**
	 * set value
	 * @param position where light is situated
	 */
	public void setPosition(Point3D position) {
		this.position = position;
	}
	/**
	 * return value
	 * @return kc attenuation factor
	 */
	public double getKc() {
		return kc;
	}
	/**
	 * set value
	 * @param kc attenuation factor
	 */
	public void setKc(double kc) {
		if (kc>1) 
			this.kc=1;
		else if (kc<0) 
			this.kc=0;
		else
			this.kc = kc;
	}
	/**
	 * return value
	 * @return kl attenuation factor
	 */
	public double getKl() {
		return kl;
	}
	/**
	 * set value
	 * @param kl attenuation factor
	 */
	public void setKl(double kl) {
		if (kl>1) 
			this.kl=1;
		else if (kl<0) 
			this.kl=0;
		else
			this.kl = kl;
	
	}
	/**
	 * return value
	 * @return kq attenuation factor
	 */
	public double getKq() {
		return kq;
	}
	/**
	 * set value
	 * @param kq attenuation factor
	 */
	public void setKq(double kq) {
		if (kq>1) 
			this.kq=1;
		else if (kq<0) 
			this.kq=0;
		else
			this.kq = kq;
	
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
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "PointLight [position=" + position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq + "]";
	}
	
	// ***************** Operations ******************** //


	/**
	 * returns intensity of light (עוצמה)
	 * IL=I0/(Kc+Kjd+Kqd^2)
	 * @param point
	 * @return color
	 */
	
	public Color getIntensity(Point3D point)//מודל פונג
	{
		double d = position.distance(point);
		Color I0 = this.color;
		double mechane = kc +(kl*d)+(kq*d*d);
		double ILred = I0.getRed()/Math.max(mechane, 1);
		if(ILred>255) ILred= 255;
		if(ILred<0) ILred = 0;
		double ILgreen = I0.getGreen()/Math.max(mechane, 1);
		if(ILgreen>255) ILgreen= 255;
		if(ILgreen<0) ILgreen = 0;
		double ILblue = I0.getBlue()/Math.max(mechane, 1);
		if(ILblue>255) ILblue= 255;
		if(ILblue<0) ILblue = 0;
		Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
		return IL;
	}

	/**
	 * returns a vector from light to point
	 * @param point
	 * @return normalized direction
	 */
	public Vector getL(Point3D point)
	{
		Vector v= new Vector(this.position,point);
		v.normalize();
		return v;
	}
	
}
