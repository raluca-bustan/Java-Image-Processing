import java.util.Scanner;

public class ContrastAndBWLevel extends MeasureTime{ 
	
	Scanner userInput;
	int choice,levelB,levelW;
	float levelC, t[] = new float[5];
	public ContrastAndBWLevel(){		
		choice = 0;
		levelC = 0;
		levelB = 0;
		levelW = 0;
		userInput = new Scanner(System.in);		
	}
	
	public int readChoice(){
		
		System.out.print("For contrast adjustment press 1\nFor black and white adjustment press 2\nFor both press 3\n");
		
		do{
			System.out.print("Your choice: ");
			start();
			if(userInput.hasNextInt())  
			choice = userInput.nextInt();	
			
		} while(choice != 1 && choice != 2 && choice != 3);
		
		stop();
		t[0] = getTime();  

		return choice;
	}
	
	public float readContrastLevel(){
		
		start();
		
		do{
		System.out.print("Choose a level of contrast between 1 and 2\nLevel: "); 
		levelC = userInput.nextFloat();
		}while(levelC > 2 || levelC < 1 );
		
		stop();
		t[1] = getTime();
		
		return levelC;
	}
	
	public int readBLevel(){
		start();
		
		do{
		System.out.print("Choose a level of black between 0 and 7\nLevel: ");
		levelB = (int)userInput.nextFloat(); 
		}while(levelB < 0 || levelB > 7 );
		
		stop();
		t[2] = getTime();
		
		return levelB;
	}
	
	public int readWLevel(){
		
		start();
		
		do{
		System.out.print("Choose a level of white between 0 and 7\nLevel: ");
		levelW = (int)userInput.nextFloat();
		}while(levelW > 7 || levelW < 0);
		
		stop();
		t[3] = getTime();
		
		return levelW;
	}
	
	public float getReadTime(){
		return t[0];
	}
	
	public float getWriteTime(){
		return t[1];
	}
	
	public float getFuncTime1(){
		return t[2];
	}
	
	public float getFuncTime2(){
		return t[3];
	}
	
}
