package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;

public class Scene {
	protected String sceneName;
	protected Color background;
	protected AmbientLight ambientLight;
	protected List<Geometry> geometries;
	protected List<Light> lights;
	protected Camera camera;
	protected double screenDistance;
	
	

		
	// ***************** Constructors ********************** //
	
	/**
	 * Constructor with parameters
	 * @param sceneName name of picture
	 * @param background background colour
	 * @param ambientLight ambient light
	 * @param geometries list of geometries in the scene
	 * @param lights list of lights in the scene
	 * @param camera camera
	 * @param screenDistance distance between camera and picture
	 */
	public Scene(String sceneName, Color background, AmbientLight ambientLight, List<Geometry> geometries,
			List<Light> lights, Camera camera, double screenDistance) {
		super();
		this.sceneName = sceneName;
		this.background = background;
		this.ambientLight = new AmbientLight(ambientLight);
		this.geometries = new ArrayList<Geometry>(geometries);
		this.lights = new ArrayList<Light>(lights);
		this.camera = new Camera(camera);
		this.screenDistance = screenDistance;
	}
	/**
	 * default constructor
	 */
	public Scene() {
		super();
		this.sceneName = new String();
		this.background = new Color(0,0,0);
		this.ambientLight = new AmbientLight();
		this.geometries = new ArrayList<Geometry>();
		this.lights = new ArrayList<Light>();
		this.camera = new Camera();
		this.screenDistance = 145;
	}
	
	
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public Scene(Scene other) {
		super();
		this.sceneName = other.sceneName;
		this.background = other.background;
		this.ambientLight = new AmbientLight(other.ambientLight);
		this.geometries = other.geometries;
		this.lights = new ArrayList<Light>(other.lights);
		this.camera = new Camera(other.camera);
		this.screenDistance = other.screenDistance;
	}

	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return name of picture
	 */
	public String getSceneName() {
		return new String(sceneName);
	}

	/**
	 * set value
	 * @param sceneName name of picture
	 */
	public void setSceneName(String sceneName) {
		 if (sceneName == null) 
	            sceneName = new String();
		 else
	           this.sceneName = new String(sceneName);
	}

	/**
	 * return value
	 * @return background colour
	 */
	public Color getBackground() {
		return new Color(background.getRGB());
	}

	/**
	 * set value
	 * @param background background colour
	 */
	public void setBackground(Color background) {
		if (background == null) 
            this.background = new Color(255,255,255);
		else 
            this.background =new Color(background.getRGB());
        
	}

	/**
	 * return value
	 * @return ambient light
	 */
	public AmbientLight getAmbientLight() {
		return new AmbientLight(ambientLight);
	}

	/**
	 * set value
	 * @param ambientLight ambient light
	 */
	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = new AmbientLight(ambientLight);
	}

	/**
	 * return value
	 * @return list of geometries in the scene
	 */
	public ArrayList<Geometry> getGeometries() {
		ArrayList<Geometry> list = new ArrayList<Geometry>();
        for (Iterator<Geometry> iterator = this.geometries.iterator(); iterator.hasNext();) 
        {
        	Geometry next = iterator.next();
            list.add(next);
        }
        return list;	
     
	}

	/**
	 * set value
	 * @param geometries list of geometries in the scene
	 */
	public void setGeometries(ArrayList<Geometry> geometries) {
		if(geometries == null) 
        {
            this.geometries = new ArrayList<Geometry>();
        }
        this.geometries = new ArrayList<Geometry>(geometries);	
    
	}

	/**
	 * return value
	 * @return camera
	 */
	public Camera getcamera() {
		return new Camera(camera);
	}

	/**
	 * set value
	 * @param camera camera
	 */
	public void setcamera(Camera camera) {
		this.camera = new Camera(camera);
	}

	/**
	 * return value
	 * @return distance between camera and picture
	 */
	public double getscreenDistance() {
		return screenDistance;
	}

	/**
	 * set value
	 * @param screenDistance distance between camera and picture
	 */
	public void setscreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}
	
	
	
	// ***************** Administration  ******************** // 
	/**
	 * print string with name and value  
	 */
	@Override
	  public String toString() {
	    return "Scene [sceneName=" + sceneName + ", background=" + background + ", geometries=" + geometries
	        + ", camera=" + camera + ", screenDistance=" + screenDistance + "]";
	  }


	/**
	 * heck if 2 variabels are equal
	 */
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Scene other = (Scene) obj;
	    if (background == null) {
	      if (other.background != null)
	        return false;
	    } else if (!background.equals(other.background))
	      return false;
	    if (camera == null) {
	      if (other.camera != null)
	        return false;
	    } else if (!camera.equals(other.camera))
	      return false;
	    if (geometries == null) {
	      if (other.geometries != null)
	        return false;
	    } else if (!geometries.equals(other.geometries))
	      return false;
	    if (sceneName == null) {
	      if (other.sceneName != null)
	        return false;
	    } else if (!sceneName.equals(other.sceneName))
	      return false;
	    if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
	      return false;
	    return true;
	  }
	  
	      // ***************** Operations ******************** //

	  /**
	   * adds a geometry to list of geometries in the scene
	   * @param g a new geometry in the scene
	   */
	  public void addGeometry(Geometry g)
	  {
	    geometries.add(g);
	  }
	  /**
	   * return an iterator to geometry
	   * @return an iterator
	   */
	  public Iterator<Geometry>getGeometryIterator()
		{
			return geometries.iterator();
		}
	  /**
	   * adds a light to list of lights in the scene
	   * @param light a new light in the scene
	   * @return updated list of all the lights in the scene
	   */
	  public List<Light> addLight(Light light)
	  {
		  lights.add(light);
		  return this.lights;
	  }
	  /**
	   * returns an iterator to light
	   * @return an iterator
	   */
	  public Iterator<Light> getLightIterator()
	  {
		  return lights.iterator();
	  }

	}
