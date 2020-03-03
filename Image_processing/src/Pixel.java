import java.awt.image.BufferedImage;
public class Pixel extends MeasureTime{
    
    int p[][];
    int a[][],r[][],g[][],b[][];
    
    public Pixel(){
    }
    
    public Pixel(BufferedImage img){
    	
    	start();
    	
    	p = new int[img.getWidth()][img.getHeight()];
    	a = new int[img.getWidth()][img.getHeight()]; // transparenta fiecarui pixel
    	r = new int[img.getWidth()][img.getHeight()]; // valoare rosu
    	g = new int[img.getWidth()][img.getHeight()]; // valoare verde
    	b = new int[img.getWidth()][img.getHeight()]; //valoare albastru
    	
    	for(int i = 0; i < img.getWidth(); i++)
			 for(int j = 0; j < img.getHeight(); j++){
				 
				p[i][j] = img.getRGB(i,j);
				a[i][j] = ( p[i][j] >> 24 ) & 0xff;  //formule pt aflarea valorii transparentei/culorilor din fiecare pixel
				r[i][j] = ( p[i][j] >> 16 ) & 0xff;
				g[i][j] = ( p[i][j] >> 8 ) & 0xff;
				b[i][j] = p[i][j] & 0xff;
				
				p[i][j] = (a[i][j]<<24) | (r[i][j]<<16) | (g[i][j]<<8) | b[i][j];
			 }
    	
    	stop();
    }
          
    public void setImg(BufferedImage img){
    	
    	for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p[0].length; j++)
				img.setRGB(i, j, p[i][j]);	
    }
        
    public int[][] getA(){  //matrice transparenta
    	return a;	
    }
     
    public int[][] getR(){ // matrice rosu
    	return r; 	
    }
   
    public int[][] getG(int i,int j){ // matrice verde
    	return g; 	
    }
    
    public int[][] getB(int i,int j){ // matrice albastra
    	return b;	
    }
    
    public int getWidth(){ //nr coloane din matricea pixel
		return p.length;
	}
	
	public int getHeight(){//nr linii din matricea pixel
		return p[0].length;
	}
    
	public float getReadTime(){
		return 0;
	}
	
	public float getWriteTime(){
		return 0;
	}
	
	public float getFuncTime1(){
		return 0;
	}
	
	public float getFuncTime2(){
		return 0;
	}
    
}
