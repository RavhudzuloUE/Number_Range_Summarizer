import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
/**
 * @author Ravhudzulo Unarine Ernest
 * 
 * Implementation of NumberRangeSummarizer interface
 */
public class NumberRangeSummarizerImp implements NumberRangeSummarizer {

	@Override
	public Collection<Integer> collect(String input) {
		
		Collection<Integer> collection = new ArrayList<>();
		String[] values = input.split(",");
		
		for (String value : values) {
			try(Scanner scanString = new Scanner(value)){
				collection.add(scanString.nextInt());
			}
		}
		
		return collection;
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {
		
		String strResults = "";
		String[] collectionValues = input.toString().substring(1, input.toString().length()-1).split(", ");
		
		int currentValue = Integer.parseInt(collectionValues[0]); // Stores the current value
		int range = 0;    // range will determine the minimum value if there is sequential number
		
		for(int i = 0; i < input.size(); i++) {
			
			if((i + 1) < collectionValues.length) {   // Keeps track of whether there is a number in an (i + 1) index
				
				if ((Integer.parseInt(collectionValues[i+1]) - currentValue) != 1) { // Evaluate the difference between next and current number 
					
					if(range == 0) {
						strResults += currentValue + ", ";
					} else {
						strResults += (currentValue - range) + "-" + currentValue + ", "; // currentValue(also maximum) - range = minimum value
					}
					
					currentValue = Integer.parseInt(collectionValues[i+1]);   // Move to the next number
					range = 0;    // Reset the range to signal the end of the sequential numbers
					
				} else {
					
					range++;
					currentValue = Integer.parseInt(collectionValues[i+1]);
					
				}
				
			} else {  // What to do when it is the last number of the input
				
				if(range == 0) {
					strResults += currentValue;
				} else {
					strResults += (currentValue - range) + "-" + currentValue;
				}				
			}			
		}
		return strResults;   // Return the results of summarized collection
	}
}
