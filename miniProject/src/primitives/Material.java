package primitives;

public class Material {
	protected double kd;
	protected double ks;
	protected double kr;
	protected double kt;
	protected double nShininess;

	// ***************** Constructors ********************** // 
	/**
	 * 
	 * Constructor with parameters
	 * @param kd Diffusion attenuation coefficient – פיזור האור 
	 * @param ks Specular attenuation coefficient – החזרת האור
	 * @param kr reflection factor -מקדם השתקפות
	 * @param kt transparency factor -מקדם שקיפות
	 * @param nShininess Refraction index – מידת מבהיקות של החומר
	 */
	public Material(double kd, double ks, double kr, double kt, double nShininess) {
		super();

		if (kd<0)
			kd=0;
		else if (kd>1) 
			kd=1;
		else 
			this.kd = kd;;


		if (ks<0)
			ks=0;
		else if (ks>1)
			ks=1;
		else
			this.kr = kr;;

		if (kr<0)
			kr=0;
		else if (kr>1)
			kr=1;
		else
			this.kt = kt;;

		if (kt<0)
			kt=0;
		else if (kt>1)
			kt=1;
		else
			this.ks = ks;;
			
		if (nShininess<0) 
			nShininess=0;
		else if (nShininess>1)
			nShininess=1;
		else
			this.nShininess = nShininess;;

	}

	/**
	 * default constructor
	 */
	public Material() {
		super();
		this.kd = 1;
		this.ks = 1;
		this.kr = 0;
		this.kt = 0;
		this.nShininess = 19;
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Material(Material other) {
		super();
		this.kd = other.kd;
		this.ks = other.ks;
		this.kr = other.kr;
		this.kt = other.kt;
		this.nShininess = other.nShininess;
	}
	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return kd Diffusion attenuation coefficient
	 */
	public double getKd() {
		return kd;
	}
	/**
	 * set value
	 * @param kd Diffusion attenuation coefficient
	 */
	public void setKd(double kd) {
		this.kd = kd;
	}
	/**
	 * return value
	 * @return ks Specular attenuation coefficient
	 */
	public double getKs() {
		return ks;
	}
	/**
	 * set value
	 * @param ks Specular attenuation coefficient
	 */
	public void setKs(double ks) {
		this.ks = ks;
	}


	/**
	 * return value
	 * @return kr reflection factor
	 */
	public double getKr() {
		return kr;
	}
	/**
	 * set value
	 * @param kr reflection factor
	 */
	public void setKr(double kr) {
		this.kr = kr;
	}



	/**
	 * return value
	 * @return kt transparency factor
	 */
	public double getKt() {
		return kt;
	}
	/**
	 * set value
	 * @param kt transparency factor
	 */
	public void setKt(double kt) {
		this.kt = kt;
	}




	/**
	 * return value
	 * @return shininess Refraction index
	 */
	public double getnShininess() {
		return nShininess;
	}
	/**
	 * set value
	 * @param nShininess Refraction index
	 */
	public void setnShininess(double nShininess) {
		this.nShininess = nShininess;
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
		Material other = (Material) obj;
		if (Double.doubleToLongBits(kd) != Double.doubleToLongBits(other.kd))
			return false;
		if (Double.doubleToLongBits(kr) != Double.doubleToLongBits(other.kr))
			return false;
		if (Double.doubleToLongBits(ks) != Double.doubleToLongBits(other.ks))
			return false;
		if (Double.doubleToLongBits(kt) != Double.doubleToLongBits(other.kt))
			return false;
		if (Double.doubleToLongBits(nShininess) != Double.doubleToLongBits(other.nShininess))
			return false;
		return true;
	}



	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Material [kd=" + kd + ", ks=" + ks + ", kr=" + kr + ", kt=" + kt + ", nShininess=" + nShininess + "]";
	}


	// ***************** Operations ******************** //




}
