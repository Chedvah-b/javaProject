package elements;

import java.awt.Color;

import primitives.Point3D;

public class AmbientLight {
	protected Color color;
	protected double ka=0.1;
	
	// ***************** Constructors ********************** //
	/**
	 * Constructor with parameters
	 * @param color
	 * @param ka attenuation factor
	 */
	public AmbientLight(Color color, double ka) {
		super();
		int r; int g; int b;
		if (color.getRed()>255) 
			 r=255;
		else 
			r= color.getRed();
		
		if (color.getBlue()>255) 
			 b=255;
		else 
			b= color.getBlue();
		
		if (color.getGreen()>255) 
			 g=255;
		else 
			g= color.getGreen();
		this.color= new Color (r,g,b);
		
		if (ka>1) 
			this.ka=1;
		else if 
		(ka<0) this.ka=0;
		else
			this.ka = ka;
	}
	/**
	 * Default constructor 
	 */
	public AmbientLight() {
		super();
		this.color = new Color(0,0,0);
		this.ka = 0.1;
	}
	/**
	 * copy constructor 
	 * @param other the object we want to copy
	 */
	public AmbientLight(AmbientLight other) {
		super();
		int r; int g; int b;
		if (other.color.getRed()>255) 
			 r=255;
		else 
			r= other.color.getRed();
		
		if (other.color.getBlue()>255) 
			 b=255;
		else 
			b= other.color.getBlue();
		
		if (other.color.getGreen()>255) 
			 g=255;
		else 
			g= other.color.getGreen();
		this.color = new Color (r,g,b);
		
		if (other.ka>1) 
			this.ka=1;
		else if (other.ka<0) 
			this.ka=0;
		else
			this.ka = other.ka;
	}
	/**
	 * Constructor with parameters
	 * @param r red colour
	 * @param g green colour
	 * @param b blue colour
	 */
	public AmbientLight(int r,int g,int b) 
	{
		if (r>255) 
			 r=255;
		if (g>255) 
			 g=255;
		if (b>255) 
			 b=255;
		this.color=new Color(r,g,b);
		this.ka=0.1;
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
		//if (color== null)
		//	return new Color(0,0,0);
		int r; int g; int b;
		if (color.getRed()>255) 
			 r=255;
		else 
			r= color.getRed();
		
		if (color.getBlue()>255) 
			 b=255;
		else 
			b= color.getBlue();
		
		if (color.getGreen()>255) 
			 g=255;
		else 
			g= color.getGreen();
		this.color = new Color(r,g,b);
	}

	/**
	 * return value
	 * @return attenuation factor
	 */
	public double getKa() {
		return ka;
	}

	/**
	 * set value
	 * @param ka attenuation factor
	 */
	public void setKa(double ka) {
		if (ka>1) 
			this.ka=1;
		else if (ka<0) 
			this.ka=0;
		else
			this.ka = ka;
	
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
		AmbientLight other = (AmbientLight) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(ka) != Double.doubleToLongBits(other.ka))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "AmbientLight [color=" + color + ", ka=" + ka + "]";
	}
		
		
		// ***************** Operations ******************** //
	/**
	 * return the intensity, the real color of the object
	 * @param point not used
	 * @return the color multipled by the attenuation factor
	 */
	public Color getIntensity(Point3D point){
		double r=color.getRed()*ka;
		if (r>255){r=255;};
		double g=color.getGreen()*ka;
		if (g>255){g=255;};
		double b=color.getBlue()*ka;
		if (b>255){b=255;};
		
		return new Color((int)r,(int)g,(int)b);
	}
}
