package search_engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class textSearch {

	public static void patternfinder(String s, String pattern) {
		try {
			//String pattern = "(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}";
			Pattern r = Pattern.compile(pattern);

				
				Matcher m = r.matcher(s);
				while (m.find()) {
					System.out.println("Found value: " + m.group(0) + " at " + m.start(0) );
				}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
