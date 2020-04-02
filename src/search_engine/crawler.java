package search_engine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


 


public class crawler {
	private static final int MAX_DEPTH = 3;
    private HashSet<String> links;
    private static int i = 0;
    public void WebCrawlerWithDepth() {
        links = new HashSet<>();
    }

    public void getPageLinks(String URL, int depth) {
    	links = new HashSet<>();
       if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
    	   
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
         try {
               links.add(URL);
              
               DownloadWebPage(URL);
                
					Document document = Jsoup.connect(URL).get();
				
                Elements links = (Elements) document.select("a[href]");

                depth++;
                for (Element page : links) {
                    getPageLinks(page.attr("abs:href"), depth);
               }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

    public static void DownloadWebPage(String webpage) 
    { 
        try { 
  
            // Create URL object 
            URL url = new URL(webpage); 
            BufferedReader readr =  
              new BufferedReader(new InputStreamReader(url.openStream())); 
            String str = "a" + i++ +".html";
            System.out.println(str);
            // Enter filename in which you want to download 
            BufferedWriter writer =  
              new BufferedWriter(new FileWriter(str)); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
  
            readr.close(); 
            writer.close(); 
            System.out.println("Successfully Downloaded."); 
        } 
  
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println("Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised"); 
        } 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crawler crawler1 = new crawler();
     	new crawler().getPageLinks("https://google.com/", 0);
	}
}
