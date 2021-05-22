import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer
{

	public static void main(String[] args) throws IOException
	{	
		// import the file
		File input = new File("Raven.txt");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		
		// Map to store each word and its count
		Map<String, Integer> textMap = new HashMap<>();
		String line;
		
		// Parse file one line at a time
		while((line = reader.readLine()) != null)
		{
			// Split each line into an array of words, remove anything that is not a letter, and make all letters lower case
			String[] words = line.toLowerCase().split("[^a-zA-Z]+");
			
			for (String word : words)
			{
				
				if (word.length() > 0) 
				{
					if (textMap.containsKey(word))
					{
						textMap.put(word, textMap.get(word) + 1);
					}
					else
					{
						textMap.put(word, 1);
					}
				}
			}
		}
		
		// Sort textMap by the most frequently used words
		ArrayList<Map.Entry<String, Integer>> sorted = new ArrayList<>(textMap.entrySet());
	    Collections.sort(sorted, new Comparator<Map.Entry<String, Integer>>()
	    {
	        public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second)
	        {
	            return first.getValue().compareTo(second.getValue());
	        }
	    });
	    
	    // Print top 20 most frequently used words
	    for(int i = 0; i < 20; i++)
	    {
	        System.out.println(sorted.get(sorted.size() - i - 1).getKey() 
	        		+ ": " + sorted.get(sorted.size() - i - 1).getValue());
	    }
		
		reader.close();
	}

}
