package simpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test() {
		ImageWriter im=new ImageWriter("test",500,500,10,10);
		for(int i=1;i<500;i++)
		{
			for(int j=1;j<500;j++)
			{
				if(((i%50)==0)||((j%50)==0))
				{
					im.writePixel(i, j, Color.white);
				}
				else
				{
					im.writePixel(i, j, Color.BLACK);
				}
			}
		}im.writeToimage();
	}
	@Test
	public void test1() {
		ImageWriter im1=new ImageWriter("test1",500,500,10,10);
		for(int k=1;k<250;k++)
		{
			for(int l=1;l<250;l++)
			{
				im1.writePixel(k, l, 255, 0, 0);
			}
		}
		for(int k=251;k<500;k++)
		{
			for(int l=1;l<250;l++)
			{
				im1.writePixel(k, l, 0, 255, 0);
			}
		}
		for(int k=1;k<250;k++)
		{
			for(int l=251;l<500;l++)
			{
				im1.writePixel(k, l, 0, 0, 255);
			}
		}
		for(int k=251;k<500;k++)
		{
			for(int l=251;l<500;l++)
			{
				im1.writePixel(k, l, 100, 0, 100);
			}
		}
		im1.writeToimage();
	}
	
	@Test
	public void test2() {
		ImageWriter im=new ImageWriter("test2",500,500,10,10);
		for(int i=1;i<500;i++)
		{
			for(int j=1;j<500;j++)
			{
				if(((i%10)==0)||((j%10)==0))
				{
					im.writePixel(i, j, Color.white);
				}
				if(((i%20)==0)||((j%20)==0))
				{
					im.writePixel(i, j, Color.BLACK);
				}
				if(((i%30)==0)||((j%30)==0))
				{
					im.writePixel(i, j, Color.pink);
				}
				if(((i%40)==0)||((j%40)==0))
				{
					im.writePixel(i, j, Color.YELLOW);
				}
				if(((i%50)==0)||((j%50)==0))
				{
					im.writePixel(i, j, Color.cyan);
				}
				
			}
		}im.writeToimage();
	}
	
	@Test
	public void test3() {
		ImageWriter im=new ImageWriter("test3",500,500,10,10);
		for(int i=1;i<250;i++)
		{
			for(int j=1;j<i;j++)
			{
				im.writePixel(i, j, Color.white);
			}
		}
		for(int i=250;i<500;i++)
		{
			for(int j=1;j<500-i;j++)
			{
				im.writePixel(i, j, Color.magenta);
			}
		}
		for(int i=1;i<250;i++)
		{
			for(int j=i;j<250;j++)
			{
				im.writePixel(i, j, Color.lightGray);
			}
		}
		for(int i=1;i<250;i++)
		{
			for(int j=500-i;j<500;j++)
			{
				im.writePixel(i, j, Color.magenta);
			}
		}
		for(int i=250;i<500;i++)
		{
			for(int j=i;j<500;j++)
			{
				im.writePixel(i, j, Color.white);
			}
		}
		for(int i=250;i<500;i++)
		{
			for(int j=250;j<i;j++)
			{
				im.writePixel(i, j, Color.lightGray);
			}
		}
		for(int i=1;i<497;i++)
		{
			for(int j=i;j<i+3;j++)
			{
				im.writePixel(i, j, Color.cyan);
			}
		}
		for(int i=1;i<497;i++)
		{
			for(int j=500-i-2;j<500-i-2+3;j++)
			{
				im.writePixel(i, j, Color.cyan);
			}
		}
		im.writeToimage();

	}
}