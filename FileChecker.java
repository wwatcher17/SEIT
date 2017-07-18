import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class FileChecker {

	/**
	 * This function is used to check if a given file path exists or not.
	 * @param filePath : String 
	 * @return boolean
	 */
	private static boolean doesFileExist(String filePath) {
		
		// Create a new File instance by converting
		// the given pathname string into an abstract pathname
		File f = new File(filePath);
		
		// Check if a the given file exists and it is a not a folder
		if(f.exists() && !f.isDirectory()) { 
			return true;
		} else {
			return false;
		}
	}
	
	private static Map<String, List<String>> readFile(String filePath) {
		
		// Create a new Map object
		Map<String, List<String>> dict = new TreeMap<String, List<String>>();

		try {
			// Create a new File object
			File f = new File(filePath);
			
			// Create a new FileReader object using the file
			FileReader fr = new FileReader(f);
			
			// Create a BufferedReader object using the FileReader object
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			// Read all the lines
			while((line = br.readLine()) != null) {
				
				// Break the given line using '-' as delimiter
				String[] parts = line.split("–");
				
				String key = parts[0];
				
				// Now get all the definition in a list
				String[] definitions = parts[1].split(",");
				
				// Create a list from the given array
				List<String> value = Arrays.asList(definitions);
				
				// Put Key-Value pair in the map
				dict.put(key, value);
			}

			// Close the BufferedReader and the FileReader
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist at the given path.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Exception occured while reading the file.");
			System.exit(1);
		}
		
		return dict;
	}
	
	/**
	 * Main driver function.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Create a BufferedReader object to read the user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the file path: ");
		String filePath = br.readLine();		// Read the file path
		
		if(doesFileExist(filePath) == true) {
			System.out.println("Yes, the file exists. We can read the information now.");
			
			// Get the dictionary
			Map<String, List<String>> dictionary = readFile(filePath);
			
			// Print the dictionary
			for(String key : dictionary.keySet()) {
				System.out.println("Word: " + key);
				
				List<String> value = dictionary.get(key);
				
				for(String definition : value) {
					System.out.println("Meaning: " + definition);
				}
			}
			
		} else {
			System.out.println("No, the file does not exist.");
		}
	}
}
