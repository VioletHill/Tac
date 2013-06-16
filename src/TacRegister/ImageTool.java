package TacRegister;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageTool 
{
	public static int getImgWidth(File file) 
	{
		InputStream is = null;
		BufferedImage src = null;
		int ret = -1;
		try 
		{
			is = new FileInputStream(file);
		    src = javax.imageio.ImageIO.read(is);
		    ret = src.getWidth(null); // �õ�Դͼ��
		    is.close();
		} 
		catch (Exception e) 
		{
		     e.printStackTrace();
		}
		return ret;
	}
	public static int getImgHeight(File file) 
	{
		InputStream is = null;
		BufferedImage src = null;
		int ret = -1;
		try 
		{
			is = new FileInputStream(file);
		    src = javax.imageio.ImageIO.read(is);
		    ret = src.getHeight(null); // �õ�Դͼ��
		    is.close();
		} 
		catch (Exception e) 
		{
		     e.printStackTrace();
		}
		return ret;
	}
}
