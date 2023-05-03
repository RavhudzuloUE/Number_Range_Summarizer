import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Ravhudzulo Unarine Ernest
 *
 */
public class Main {

	/**
	 * @param Ravhudzulo Unarine Ernest
	 */
	public static void main(String[] args) {
		
		try(Scanner scanInput = new Scanner(new File("Test_Cases.txt"))){
			
			NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImp();
			String strInput = "";
			int counter = 1;
			while(scanInput.hasNextLine()) {
				strInput = scanInput.nextLine();
				System.out.println("*****   Test Case " + counter + "   *******");
				System.out.println("Input: \"" + strInput);
				System.out.println("Results: \"" + numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(strInput)) + "\"");
				System.out.println("\n");
				counter++;
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}

}
