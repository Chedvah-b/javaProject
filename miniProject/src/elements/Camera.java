package elements;

import java.util.ArrayList;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
	protected Point3D p0;
	protected Vector vUp;
	protected Vector vRight;
	protected Vector vTo;
	// ***************** Constructors ********************** //
	/**
	 * Constructor with parameters
	 * @param p0 point of origin
	 * @param vUp vector facing upwards
	 * @param vTo vector facing forwards
	 */
	public Camera(Point3D p0, Vector vUp,  Vector vTo) {
		super();
		this.p0 = new Point3D(p0);
		this.vUp = new Vector(vUp);
		this.vTo = new Vector(vTo);
		this.vRight = new Vector(vTo.crossProduct(vUp));//this.getvTo().crossProduct(this.getvUp());

	}
	/**
	 * Default constructor
	 */
	public Camera() {
		super();
		this.p0 = new Point3D(0,0,0);
		this.vUp = new Vector(0,1,0);
		//this.vRight = new Vector(0,1,0);
		this.vTo = new Vector(0,0,-1);
		this.vRight=new Vector(vTo.crossProduct(vUp));
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Camera(Camera other) {
		super();
		this.p0 = new Point3D(other.getP0());
		this.vUp = new Vector(other.getvUp());
		this.vRight = new Vector(other.getvRight());
		this.vTo = new Vector(other.getvTo());
	}


	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return point of origin
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * set value
	 * @param p0 point of origin
	 */
	public void setP0(Point3D p0) {
		this.p0 = new Point3D(p0);
	}

	/**
	 * return value
	 * @return vector facing upwards
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
	 * set value
	 * @param vUp vector facing upwards
	 */
	public void setvUp(Vector vUp) {
		this.vUp = new Vector(vUp);
	}

	/**
	 * return value
	 * @return vector facing right
	 */
	public Vector getvRight() {
		return vRight;
	}

	/**
	 * set value
	 * @param vRight vector facing right
	 */
	public void setvRight(Vector vRight) {
		this.vRight = new Vector(vRight);
	}

	/**
	 * return value
	 * @return vector facing forwards
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * set value
	 * @param vTo vector facing forwards
	 */
	public void setvTo(Vector vTo) {
		this.vTo = new Vector(vTo);
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
		Camera other = (Camera) obj;
		if (p0 == null) {
			if (other.p0 != null)
				return false;
		} else if (!p0.equals(other.p0))
			return false;
		if (vRight == null) {
			if (other.vRight != null)
				return false;
		} else if (!vRight.equals(other.vRight))
			return false;
		if (vTo == null) {
			if (other.vTo != null)
				return false;
		} else if (!vTo.equals(other.vTo))
			return false;
		if (vUp == null) {
			if (other.vUp != null)
				return false;
		} else if (!vUp.equals(other.vUp))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Camera [p0=" + p0 + ", vUp=" + vUp + ", vRight=" + vRight + ", vTo=" + vTo + "]";
	}


	// ***************** Operations ******************** //



	/**
	 * buildes a ray that starts at the center of camera and goes through the given pixel
	 * result=Pc+(((x-#pixel(x)/2+Nx/2)*Vright-((y-#pixels(y)/2)*Ny)+Ny/2)*Vup)
	 * @param Nx number of pixels on the width
	 * @param Ny number of pixels on the height
	 * @param x the column of the pixel we're sending the ray
	 * @param y the row of the pixel we're sending the ray
	 * @param screenDist distance form camera
	 * @param screenWidth screen width
	 * @param screenHeight screen height
	 * @return a ray that starts at the center of camera and goes through the given pixel
	 */
	public Ray constructRayThroughPixel(double Nx, double Ny, double x, double y,
			double screenDist, double screenWidth, double screenHeight)
	{
		Vector vRtemp = new Vector(vRight);
		Vector vTo = new Vector(this.vTo);
		Vector vUp = new Vector(this.vUp);
		Point3D P0= new Point3D(this.p0);
		vTo.scale(screenDist);
		P0.add(vTo);
		Vector pc= new Vector(P0);
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		double tempX= (x- (Nx/2.0))*Rx+(Rx/2.0);
		double tempy= (y- (Ny/2.0))*Ry+(Ry/2.0);
		vRtemp.scale(tempX);
		vUp.scale(tempy);
		vRtemp.subtract(vUp);
		pc.add(vRtemp);
		Point3D tempPoint = new Point3D(pc.getHead());
		pc.normalize();
		return new Ray(new Point3D(tempPoint), pc);

	}
	/**
	 * builds 5 rays to get a better colour of the object
	 * @param Nx number of pixels on the width
	 * @param Ny number of pixels on the height
	 * @param x the column of the pixel we're sending the ray
	 * @param y the row of the pixel we're sending the ray
	 * @param screenDist distance form camera
	 * @param screenWidth screen width
	 * @param screenHeight screen height
	 * @return a list of rays
	 */
	public ArrayList<Ray> constructRayThroughPixel2(double Nx, double Ny, double x, double y,
			double screenDist, double screenWidth, double screenHeight)
	{
		ArrayList<Ray>rays=new ArrayList<Ray>();
		//middle
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		Point3D myP0 = new Point3D(p0);
		Vector myVr = new Vector(vRight);
		Vector myVup = new Vector(vUp);
		Vector myVto = new Vector(vTo);
		myVto.scale(screenDist);
		myP0.add(myVto);

		double tempX= (x- (Nx/2.0))*Rx+(Rx/2.0);
		double tempY= (y- (Ny/2.0))*Ry+(Ry/2.0);

		myVr.scale(tempX);
		myVup.scale(tempY);
		myVr.subtract(myVup);
		myP0.add(myVr);

		Vector temp = new Vector(p0);
		myP0.subtract(temp);
		Vector myDirection = new Vector(myP0);
		myDirection.normalize();
		rays.add(new Ray(new Point3D(p0), myDirection));




		//top left
		myP0 = new Point3D(p0);
		myVr = new Vector(vRight);
		myVup = new Vector(vUp);
		myVto = new Vector(vTo);
		myVto.scale(screenDist);
		myP0.add(myVto);

		tempX= (x- (Nx/2.0))*Rx;
		tempY= (y- (Ny/2.0))*Ry;

		myVr.scale(tempX);
		myVup.scale(tempY);
		myVr.subtract(myVup);
		myP0.add(myVr);

		temp = new Vector(p0);
		myP0.subtract(temp);
		myDirection = new Vector(myP0);
		myDirection.normalize();
		rays.add(new Ray(new Point3D(p0), myDirection));

		//top right
		myP0 = new Point3D(p0);
		myVr = new Vector(vRight);
		myVup = new Vector(vUp);
		myVto = new Vector(vTo);
		myVto.scale(screenDist);
		myP0.add(myVto);

		tempX= (x- (Nx/2.0))*Rx+Rx;
		tempY= (y- (Ny/2.0))*Ry;

		myVr.scale(tempX);
		myVup.scale(tempY);
		myVr.subtract(myVup);
		myP0.add(myVr);

		temp = new Vector(p0);
		myP0.subtract(temp);
		myDirection = new Vector(myP0);
		myDirection.normalize();
		rays.add(new Ray(new Point3D(p0), myDirection));

		//bottom left
		myP0 = new Point3D(p0);
		myVr = new Vector(vRight);
		myVup = new Vector(vUp);
		myVto = new Vector(vTo);
		myVto.scale(screenDist);
		myP0.add(myVto);

		tempX= (x- (Nx/2.0))*Rx;
		tempY= (y- (Ny/2.0))*Ry+Ry;

		myVr.scale(tempX);
		myVup.scale(tempY);
		myVr.subtract(myVup);
		myP0.add(myVr);

		temp = new Vector(p0);
		myP0.subtract(temp);
		myDirection = new Vector(myP0);
		myDirection.normalize();
		rays.add(new Ray(new Point3D(p0), myDirection));

		//bottom right
		myP0 = new Point3D(p0);
		myVr = new Vector(vRight);
		myVup = new Vector(vUp);
		myVto = new Vector(vTo);
		myVto.scale(screenDist);
		myP0.add(myVto);

		tempX= (x- (Nx/2.0))*Rx+Rx;
		tempY= (y- (Ny/2.0))*Ry+Ry;

		myVr.scale(tempX);
		myVup.scale(tempY);
		myVr.subtract(myVup);
		myP0.add(myVr);

		temp = new Vector(p0);
		myP0.subtract(temp);
		myDirection = new Vector(myP0);
		myDirection.normalize();
		rays.add(new Ray(new Point3D(p0), myDirection));
		return rays;

	}

}
