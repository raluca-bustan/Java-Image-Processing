import java.awt.image.BufferedImage;
public class MainClass {

	public static void main(String[] args) {
		
		ReadWriteFile f = new ReadWriteFile(); 
		f.read();
		System.out.println();
		
		int choice,lB,lW;  // black/white level
		float lC; // contrast level
		
		BufferedImage image = f.getImg();  //read image
		Pixel x = new Pixel(image);

		ContrastAndBWLevel c = new ContrastAndBWLevel();
		choice = c.readChoice();
		
		System.out.println();
		
		ImageProcess ct = new ImageProcess();
		
		if(choice == 1) // contrast adjustment
		{
			lC = c.readContrastLevel();
			ct.setContrast(x,lC);
			System.out.println();
		}
		if(choice == 2) // black & white level adjustment
		{
			lB = c.readBLevel();
			lW = c.readWLevel();
			ct.setBW(x, lB, lW);
			System.out.println();
		}
		if(choice == 3) // both adjustments
		{
			lC = c.readContrastLevel();
			System.out.println();
			lB = c.readBLevel();
			lW = c.readWLevel();
			ct.setContrast(x,lC);
			ct.setBW(x, lB, lW);
			System.out.println();
		}
		
		x.setImg(image);//edit image 	
		f.write(image);//write image
		
		System.out.println("\n\nResults:");  // tasks execution time 
		System.out.println("File path reading time: " + f.getReadTime() + 's');
		System.out.println("Image reading time: " + f.getFuncTime1() + 's');
		System.out.println("Pixel matrix obtaining time: " + x.getTime() + 's');
		System.out.println("Choice reading time: " + c.getReadTime() + 's');
		
		if(choice == 1 || choice == 3){
			System.out.println("Contrast level reading time: " + c.getWriteTime() + 's');
			System.out.println("Contrast applying time: " + ct.getFuncTime1() + 's');}
		
		if(choice == 2 || choice == 3){
			System.out.println("Black level reading time: " + c.getFuncTime1() + 's');
			System.out.println("White level reading time: " + c.getFuncTime2() + 's');
			System.out.println("Black and white level applying time: " + ct.getFuncTime2() + 's');
		}
		
		System.out.println("Image writing time: " + f.getFuncTime2() + 's');
		System.out.println("File output path reading time: " + f.getWriteTime() + 's');
		
	  	
	}

}
