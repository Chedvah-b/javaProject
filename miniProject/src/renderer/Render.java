package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Map.Entry;

import elements.Light;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render {
	protected Scene scene;
	protected ImageWriter imageWriter;
	//static int count = 0;
	int RECURSION_LEVEL=3;

	// ***************** Constructors ********************** //
	/**
	 * Constructor with parameters
	 * @param scene the picture
	 * @param imageWriter builds the picture so we can see it
	 */
	public Render(Scene scene, ImageWriter imageWriter) {
		super();
		this.scene = scene; 
		this.imageWriter = imageWriter;
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return scene the picture
	 */
	public Scene getScene() {
		return new Scene(scene);
	}


	/**
	 * set value
	 * @param scene the picture
	 */
	public void setScene(Scene scene) {
		this.scene = new Scene(scene);
	}


	/**
	 * return value
	 * @return image writer
	 */
	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	/**
	 * set value
	 * @param imageWriter
	 */
	public void setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
	}
	// ***************** Administration  ******************** //

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Render [_scene=" + scene + ", _imageWriter=" + imageWriter + "]";
	}


	/**
	 * check if 2 variabels are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (imageWriter == null) {
			if (other.imageWriter != null)
				return false;
		} else if (!imageWriter.equals(other.imageWriter))
			return false;
		if (scene == null) {
			if (other.scene != null)
				return false;
		} else if (!scene.equals(other.scene))
			return false;
		return true;
	}

	// ***************** Operations ******************** //

	/**
	 * prints a grid, black background and white lines
	 * @param interval the size of the squire
	 */
	public void printGrid(int interval)
	{

		for(int i=0; i < this.imageWriter.getHeight(); i++)
		{
			for(int j=0; j<this.imageWriter.getWidth(); j++)
			{
				if((i % interval == 0)||(j % interval==0))
					imageWriter.writePixel(i,j,Color.WHITE);
			}
		}
	}


	/**
	 * calculates the diffuse of the light at the given point
	 * @param kd diffuse factor
	 * @param n the vector that is vertical to the light source
	 * @param l the vector of the light direction
	 * @param intensity the colour of the geometry
	 * @return the colour after taking into account the diffuse
	 */
	private Color calcDiffusiveComp(double kd, Vector n, Vector l, Color intensity)
	{
		Vector N = new Vector(n);
		Vector L = new Vector(l);
		N.normalize();
		L.normalize();
		double help = kd*Math.abs(N.dotProduct(L));
		if(help>1) help=1;
		int red= (int)(help * intensity.getRed());
		if(red>255) red=255;
		int green = (int)(help * intensity.getGreen());
		if(green>255) green=255;
		int blue = (int)(help * intensity.getBlue());
		if(blue>255) blue = 255;
		return new Color (red, green, blue);
	}


	/**
	 * calculates the reflection of the light at the given point
	 * @param ks specular factor
	 * @param vector the direction of the light
	 * @param n vector vertical to light source
	 * @param l vector form camera to geometry
	 * @param shininess Refraction index
	 * @param intensity colour
	 * @return the colour after taking into account the specular
	 */
	private Color calcSpecularComp(double ks, Vector vector, Vector n, Vector l, double shininess, Color intensity)
	{
		Vector V = new Vector(vector);
		Vector N = new Vector(n);
		Vector L = new Vector(l);
		V.normalize();
		N.normalize();
		L.normalize();
		double d = (L.dotProduct(N))*(-2);//חישוב R
		N.scale(d);
		L.add(N);
		Vector R = new Vector(L);
		double VR = V.dotProduct(R);//V*R
		if(VR < 0) VR = 0;
		VR = Math.pow(VR, shininess);
		VR= VR*ks;
		if(VR>1) VR = 1;
		if(VR<0) VR = 0;
		int red= (int)(VR * intensity.getRed());
		if(red>255) red=255;
		int green = (int)(VR * intensity.getGreen());
		if(green>255) green=255;
		int blue = (int)(VR * intensity.getBlue());
		if(blue>255) blue = 255;
		return new Color (red, green, blue);
	}



	/**
	 * return a map, the key is the type of geometry and the value is a list of intersections
	 * @param ray the ray that is shot form the camera
	 * @return a map of geometry type and list of intersections
	 */
	private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray)
	{

		Iterator<Geometry> geometries = this.scene.getGeometryIterator();
		Map<Geometry, ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry, ArrayList<Point3D>>(); 
		while (geometries.hasNext())
		{
			Geometry geometry = geometries.next();
			ArrayList<Point3D> geometryIntersectionPoints =geometry.findIntersections(ray);
			if (!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}



	/**
	 * returns a map, the key is the geometry type and the value is the closest point the ray hit
	 * @param intersectionPoints a map with geometrys and lists of intersection points
	 * @return the point that is closest to the camera where the ray hit the geometry
	 */
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints)
	{
		double distance = Double.MAX_VALUE;
		Point3D P0 = scene.getcamera().getP0();
		Map<Geometry, Point3D> minDistancePoint  = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())  
		{
			for (Point3D point: entry.getValue())  
			{
				if (P0.distance(point) < distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
			}
		}
		return minDistancePoint;
	}



	/**
	 * calculates the colour of the geometry, call another function
	 * @param geometry the geometry we want the colour of
	 * @param point point on geometry
	 * @param inRay ray from camera to geometry
	 * @return the colour
	 */
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay) 
	{
		return calcColor( geometry, point,inRay, 0);
	}


	/**
	 * calculates the colour of the geometry
	 * @param geometry the geometry we want the colour of
	 * @param point point on geometry
	 * @param inRay ray from camera to geometry
	 * @param level we take into account different aspects like shade but up to a certain degree, here its 3 times
	 * @return the colour
	 */
	private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {
		if( level==RECURSION_LEVEL)return new Color(0,0,0); 
		Color ambientLight = scene.getAmbientLight().getIntensity(point);
		Color emissionLight = geometry.getEmmission();

		Iterator<Light> lights = scene.getLightIterator();
		Color ColorDiffuseLight= new Color(0,0,0);
		Color SpecularLight = new Color(0,0,0);
		Color reflectedLight = new Color(0,0,0);
		Color refractedLight = new Color(0,0,0);
		while (lights.hasNext())
		{

			Light light = lights.next();	
			if (!occluded(light, point, geometry))
			{ 
				ColorDiffuseLight = addColor(ColorDiffuseLight, calcDiffusiveComp(geometry.getMaterial().getKd(),
						geometry.getNormal(point),  light.getL(point),  light.getIntensity(point)));

				SpecularLight = addColor(SpecularLight, calcSpecularComp(geometry.getMaterial().getKs(),
						new Vector(point, scene.getcamera().getP0()),
						geometry.getNormal(point),  light.getL(point), geometry.getMaterial().getnShininess(),
						light.getIntensity(point)));
			}

		}
		Ray reflectedRay = new Ray(constructReflectedRay(geometry.getNormal(point), point, inRay));
		Map<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
		if (!reflectedEntry.isEmpty()) 
		{
			Color reflectedColor = calcColor(reflectedEntry.entrySet().iterator().next().getKey(),
					reflectedEntry.entrySet().iterator().next().getValue(), reflectedRay, level + 1);	
			double kr = geometry.getMaterial().getKr();
			int reflectR = (int) (kr * reflectedColor.getRed());
			int reflectG = (int) (kr * reflectedColor.getGreen());
			int reflectB = (int) (kr * reflectedColor.getBlue());
			if (reflectR>255) reflectR=255;
			if(reflectR<0) reflectR=0;
			if (reflectG>255) reflectG=255;
			if(reflectG<0) reflectG=0;
			if (reflectB>255) reflectB=255;
			if(reflectB<0) reflectB=0;
			reflectedLight = new Color(reflectR, reflectG, reflectB);
		}
		Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
		Map<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
		if (!refractedEntry.isEmpty())
		{
			Color refractedColor = calcColor(refractedEntry.entrySet().iterator().next().getKey(), 
					refractedEntry.entrySet().iterator().next().getValue(), refractedRay, level + 1);
			double kt = geometry.getMaterial().getKt();
			int refractR = (int) (kt * refractedColor.getRed());
			int refractG = (int) (kt * refractedColor.getGreen());
			int refractB = (int) (kt * refractedColor.getBlue());
			refractedLight = new Color(refractR, refractG, refractB);				
		}


		double totalRed = ambientLight.getRed() + emissionLight.getRed() + ColorDiffuseLight.getRed() + SpecularLight.getRed() + reflectedLight.getRed() + refractedLight.getRed();
		double totalBlue = ambientLight.getBlue() + emissionLight.getBlue() + ColorDiffuseLight.getBlue() + SpecularLight.getBlue() + reflectedLight.getBlue() + refractedLight.getBlue();
		double totalGreen = ambientLight.getGreen() + emissionLight.getGreen() + ColorDiffuseLight.getGreen() + SpecularLight.getGreen()+reflectedLight.getGreen() + refractedLight.getGreen();
		if(totalRed>255) totalRed = 255;
		if(totalBlue>255) totalBlue = 255;
		if(totalGreen>255) totalGreen = 255;
		return new Color((int)totalRed, (int)totalGreen, (int)totalBlue);
	}



	/**
	 * renders the picture
	 */
	public void renderImage() 
	{
		for(int i=0; i < this.imageWriter.getHeight(); i++)
		{
			for(int j=0;j<this.imageWriter.getWidth();j++)
			{
				Ray ray = scene.getcamera().constructRayThroughPixel
						(imageWriter.getNx(), imageWriter.getNy(),
								i, j, scene.getscreenDistance(), imageWriter.getWidth(),
								imageWriter.getHeight());

				Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty()){
					imageWriter.writePixel(i, j, scene.getBackground());
				}

				else
				{
					Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					imageWriter.writePixel(i, j, calcColor(closestPoint.entrySet().iterator().next().getKey() 
							,closestPoint.entrySet().iterator().next().getValue(), ray));
				}
			}

		}
	}
	/**improvement
	 * renders the picture
	 */
	public void renderImage2() 
	{
		int avgR=0;
		int avgG=0;
		int avgB=0;
		int [][]mapPic=new int[this.imageWriter.getHeight()][this.imageWriter.getWidth()];
		for(int i=0; i < this.imageWriter.getHeight(); i++)
		{
			for(int j=0;j<this.imageWriter.getWidth();j++)
			{
				Ray ray = scene.getcamera().constructRayThroughPixel
						(imageWriter.getNx(), imageWriter.getNy(),
								i, j, scene.getscreenDistance(), imageWriter.getWidth(),
								imageWriter.getHeight());

				Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty()){
					mapPic[i][j]=0;
				}
				else{
					mapPic[i][j]=1;
				}

			}
		}
		for(int i=0; i < this.imageWriter.getHeight(); i++)
		{
			for(int j=0;j<this.imageWriter.getWidth();j++)
			{
				avgR=0;
				avgG=0;
				avgB=0;
				if(mapPic[i][j]==1){
					ArrayList<Ray> myRay = scene.getcamera().constructRayThroughPixel2
							(imageWriter.getNx(), imageWriter.getNy(),
									i, j, scene.getscreenDistance(), imageWriter.getWidth(),
									imageWriter.getHeight());
					Iterator<Ray>iterator=myRay.iterator();
					while(iterator.hasNext()){
						Ray r=new Ray(iterator.next());
						Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(r);
						//r.getDirection().normalize();

						Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
						avgR+=calcColor(closestPoint.entrySet().iterator().next().getKey() 
								,closestPoint.entrySet().iterator().next().getValue(), r).getRed();
						avgG+=calcColor(closestPoint.entrySet().iterator().next().getKey() 
								,closestPoint.entrySet().iterator().next().getValue(), r).getGreen();
						avgB+=calcColor(closestPoint.entrySet().iterator().next().getKey() 
								,closestPoint.entrySet().iterator().next().getValue(), r).getBlue();


					}
					avgR/=5;
					avgG/=5;
					avgB/=5;
					avgR=avgR>255?255:avgR;
					avgG=avgG>255?255:avgG;
					avgB=avgB>255?255:avgB;
					imageWriter.writePixel(i, j,new Color(avgR,avgG,avgB));
				}
				else
					imageWriter.writePixel(i, j, scene.getBackground());
			}
		}
	}

	/**
	 * for each point on each geometry checks if its hidden
	 * @param light light source
	 * @param point the point we want to check
	 * @param geometry the geometry the point is on
	 * @return true if the point is hidden otherwise false 
	 */
	private boolean occluded(Light light,Point3D point,Geometry geometry)
	{
		Vector lightDirection=new Vector(light.getL(point));
		//lightDirection.scale(-1);
		Point3D geometryPoint=new Point3D(point);
		Vector epsVector=new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		geometryPoint.add(epsVector);
		Ray lightRay=new Ray(geometryPoint,lightDirection);

		Map<Geometry,ArrayList<Point3D>> intersectionPoints=
				getSceneRayIntersections(lightRay);

		if(true/*geometry instanceof FlatGeometry*/){
			intersectionPoints.remove(geometry);
		}
		for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
			if (entry.getKey().getMaterial().getKt() == 0)
				return true;
		return false;

	}

	/**
	 * builds the ray the reflects from the given point
	 * @param N normal of point
	 * @param point point we want to check
	 * @param ray ray from camera to geometry
	 * @return the new reflected ray
	 */
	Ray constructReflectedRay(Vector N, Point3D point, Ray ray)
	{
		N.normalize();
		Vector D = new Vector(ray.getDirection());
		D.normalize();

		double A=D.dotProduct(N);
		N.scale(A*(-2));
		Vector B= new Vector(N);
		D.add(B);
		Point3D point1 = new Point3D(point);
		point1.add(D);

		return new Ray(point1 ,D);
	}
	/**
	 * builds the ray the transparencies from the given point
	 * @param D vector
	 * @param point point on geometry where the ray hits
	 * @param ray ray form camera to geometry
	 * @return the new refracted ray
	 */
	private Ray constructRefractedRay(Vector D,Point3D point, Ray ray)
	{

		ray.getDirection().normalize();
		Vector temp = new Vector(ray.getDirection());

		Point3D point1 = new Point3D(point);
		point1.add(temp);
		return new Ray(point1, ray.getDirection());


	}
	/**
	 * return a map with geometry type and the closest intersection
	 * @param ray ray form camera to geometry
	 * @return a map with geometry type and the closest intersection
	 */
	private Map<Geometry, Point3D>findClosesntIntersection(Ray ray)
	{
		Map<Geometry, ArrayList<Point3D>> help = getSceneRayIntersections(ray);
		return getClosestPoint(help);
	}


	/**
	 * mixes two colours together to get a new colour
	 * @param c1 first colour
	 * @param c2 second colour
	 * @return new mixed colour
	 */
	public Color addColor(Color c1, Color c2)
	{
		int red=c1.getRed()+c2.getRed();
		if(red>255) red=255;
		int green=c1.getGreen()+c2.getGreen();
		if(green>255) green=255;
		int blue=c1.getBlue()+c2.getBlue();
		if(blue>255) blue=255;
		return new Color(red, green, blue);
	}


}
