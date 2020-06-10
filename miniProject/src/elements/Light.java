package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public abstract class Light {
	protected Color color;

	// ***************** Constructors ********************** // 
	/**
	 * constructor with parameter
	 * @param color
	 */
	public Light(Color color) {
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
		
	}
	
	/**
	 * default constructor
	 */
	public Light() {
		super();
		this.color = new Color(255,255,255);
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Light(Light other) {
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
		Light other = (Light) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}


	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Light [color=" + color + "]";
	}
	
	// ***************** Operations ******************** //
	/**
	 * abstract function calculates the color of light
	 * @param point where the light is
	 * @return intensity of light (тецод)
	 */
	public abstract Color getIntensity(Point3D point);
	
	/**
	 *  abstract function
	 * @param point 
	 * @return a vector from light to point
	 */
	public abstract Vector getL(Point3D point);
	

}
