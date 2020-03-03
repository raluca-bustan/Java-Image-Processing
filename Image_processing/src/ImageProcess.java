
public class ImageProcess extends Pixel {
	
	float t[] = new float[2]; //contrast/black and white time

	public void setContrast(Pixel p, float level){
		
		start();
		
		for (int i = 0; i < p.getWidth(); i++)
			for (int j = 0; j < p.getHeight(); j++){
			
			p.r[i][j] = (int)Math.round(p.r[i][j] * level); 
			if(p.r[i][j] > 255)
				p.r[i][j] = 255;
			
			p.g[i][j] = (int)Math.round(p.g[i][j] * level);
			if(p.g[i][j] > 255)
				p.g[i][j] = 255;
			
			p.b[i][j] = (int)Math.round(p.b[i][j] * level);
			if(p.b[i][j] > 255)
				p.b[i][j] = 255;
			
		    p.p[i][j] = (p.a[i][j]<<24) | (p.r[i][j]<<16) | (p.g[i][j]<<8) | p.b[i][j];    
			}
		
		stop();
		t[0] = getTime();
	}
	
	public void setBW(Pixel p, int levelB, int levelW){
		
		start();
		
		for (int i = 0; i < p.getWidth(); i++)
			for (int j = 0; j < p.getHeight(); j++){
				
			//white adjustment		
			p.r[i][j] = p.r[i][j] + levelW * 25;
	    	if (p.r[i][j] > 255)
	    		p.r[i][j] = 255;
	    	
	    	p.g[i][j] = p.g[i][j] + levelW * 25;
	    	if (p.g[i][j] > 255)
	    		p.g[i][j] = 255;
	    	
	    	p.b[i][j] = p.b[i][j] + levelW * 25;
	    	if (p.b[i][j] > 255)
	    		p.b[i][j] = 255;
	    	
	    	//black adjustment
	    	p.r[i][j] = p.r[i][j] - levelB * 25;
	    	if (p.r[i][j] < 0)
	    		p.r[i][j] = 0;
	    	
	    	p.g[i][j] = p.g[i][j] - levelB * 25;
	    	if (p.g[i][j] < 0)
	    		p.g[i][j] = 0;
	    	
	    	p.b[i][j] = p.b[i][j] - levelB * 25;
	    	if (p.b[i][j] < 0)
	    		p.b[i][j] = 0;
	  
	    	p.p[i][j] = (p.a[i][j]<<24) | (p.r[i][j]<<16) | (p.g[i][j]<<8) | p.b[i][j];
			}
			
    	stop();
    	t[1] = getTime();
	}
	
	public float getFuncTime1(){
		return t[0];
	}
	
	public float getFuncTime2(){
		return t[1];
	}
	
	
}
	

