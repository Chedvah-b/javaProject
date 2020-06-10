package renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

	protected int imageWidth;
	protected int imageHeight;
	
	protected int Ny, Nx;
	
	final String PROJECT_PATH = System.getProperty("user.dir");
	
	protected BufferedImage image;
	
	protected String imageName;
	
	// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param imageName name of jpg file
	 * @param width image width in pixels
	 * @param height image height in pixels
	 * @param Ny number of squires per column
	 * @param Nx number of squires per row
	 */
	public ImageWriter(String imageName, int width, int height, int Ny, int Nx){
		
		this.Nx = Nx;
		this.Ny = Ny;
		
		this.imageWidth = width;
		this.imageHeight = height;
		
		this.imageName = imageName;
		
		this.image = new BufferedImage(
				imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */
	public ImageWriter (ImageWriter other){
		this.Nx = other.Nx;
		this.Ny = other.Ny;
		
		this.imageWidth = other.getWidth();
		this.imageHeight = other.getHeight();
		
		this.imageName = other.imageName;
		
		this.image = new BufferedImage(
				imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	
	// ***************** Getters/Setters ********************** //
	/**
	 * return value
	 * @return image width
	 */
	public int getWidth()  { return imageWidth;  }
	/**
	 * return value
	 * @return image height
	 */
	public int getHeight() { return imageHeight; }

	/**
	 * return value
	 * @return number of squires per column
	 */
	public int getNy() { return Ny; }
	/**
	 * return value
	 * @return number of squires per row
	 */
	public int getNx() { return Nx; }

	/**
	 * set value
	 * @param Ny number of squires per column
	 */
	public void setNy(int Ny) { this.Ny = Ny; }
	/**
	 * set value
	 * @param Nx number of squires per row
	 */
	public void setNx(int Nx) { this.Nx = Nx; }
		
	// ***************** Operations ******************** // 
	/**
	 * makes the picture that was built by writePixel
	 * the file is store in project path
	 */
	public void writeToimage(){
		
		File ouFile = new File(PROJECT_PATH + "/" + imageName + ".jpg");

		try {
			ImageIO.write(image, "jpg", ouFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * colours a pixel in the given colour
	 * @param xIndex number of column
	 * @param yIndex number of row
	 * @param r red colour
	 * @param g green colour
	 * @param b blue colour
	 */
	public void writePixel(int xIndex, int yIndex, int r, int g, int b){
		
		int rgb = new Color(r, g, b).getRGB();
		this.image.setRGB(xIndex, yIndex, rgb);
		
	}
	/**
	 * colours a pixel in the given colour
	* @param xIndex number of column
	 * @param yIndex number of row
	 * @param rgbArray array with the three colours
	 */
	public void writePixel(int xIndex, int yIndex, int[] rgbArray){
		
		int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
		this.image.setRGB(xIndex, yIndex, rgb);
		
	}
	/**
	 * colours a pixel in the given colour
	 * @param xIndex number of column
	 * @param yIndex number of row
	 * @param color the desired colour
	 */
	public void writePixel(int xIndex, int yIndex, Color color){
		
		this.image.setRGB(xIndex, yIndex, color.getRGB());
		
	}
	
}
