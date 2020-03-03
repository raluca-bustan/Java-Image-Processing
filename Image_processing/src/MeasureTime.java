
public abstract class MeasureTime implements PrintTime{
	
	long start;
	long stop;
	
	public MeasureTime(){
		start=0;
		stop=0;
	}
	
	public void start(){
	    start=System.nanoTime();
	}
	
	public void stop(){
		 stop=System.nanoTime();
	}
	
	public float getTime(){
		return ((float)(stop-start)/1000000000); 
	}
}
