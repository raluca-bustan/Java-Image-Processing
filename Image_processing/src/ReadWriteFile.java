import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ReadWriteFile extends MeasureTime {
	
	BufferedImage img;
	File f,g;
	float t[] = new float[4]; //reading/writing time
	Scanner userInput;
	
	public ReadWriteFile(){
		img = null;
		f = null;
		g = null;
		userInput = new Scanner(System.in);
	}
	
	public void read(){
		
		start();
		String path = null;
	
		do{		
			
		System.out.println("Enter full file path:"); //check path 
		path = userInput.nextLine();
		f = new File(path);
		
		}while(!f.exists() ||  path.endsWith(".bmp") == false);
		
		stop();
		t[0] = getTime();
		
		start();
		try{
			img = ImageIO.read(f);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		stop();	
		t[1] = getTime();
	
	}
	

	public void write(BufferedImage image){
		
		start();
		String path = null; 		
	
	    do{
	    	System.out.println("Enter the destination folder:");
		    path = userInput.nextLine();		   	    
	    	 g=new File(path);
	    }while (!g.exists());
	    path=path+"\\out.bmp";
	    
    	 try {            	
        	 ImageIO.write(image, "bmp",new File(path)); 
         } 
    	 catch (IOException e) {
               System.out.println("Exception occured" + e.getMessage());}
	  
  	    stop();
		t[2] = getTime();
		
		start();	  
		userInput.close();
		
		stop();
		t[3] = getTime();
	}
	
	public BufferedImage getImg(){
		return img;
	}
	
	public float getReadTime(){
		return t[0];
	}
	
	public float getFuncTime1(){
		return t[1];
	}
	
	
	public float getWriteTime(){
		return t[2];
	}

	public float getFuncTime2(){
		return t[3];
	}
	
}
