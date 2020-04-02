package search_engine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import search_engine.*;

import search_engine.*;
public class searchMain {

	public static String[] readfile(String s) {

		File dir = new File(s);
		File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
		String[] str=new String[files.length];
		for(int j=0;j<files.length;j++)
		{
			str[j]=files[j].getName();
		}
		
		return str;
		
	}
	public static String fileread(String sw) {
		File file = new File(sw);
		String s = "";
		try {
			BufferedReader br;

			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null)
				s = s + st;

			br.close();
			return s.split(" ")[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "";

	}
	public static String fileread1(String sw) {
		File file = new File(sw);
		String s = "";
		try {
			BufferedReader br;

			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null)
				s = s + st;

			br.close();
			return s;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "";

	}
	public static void main(String[] args) throws IOException {
		String phrase="asdasd";
		int er=1;
		String[] s1=readfile("C:\\Users\\Heli\\eclipse-workspace\\search_engine");
		int we=0;
		while(!phrase.equals("exit"))
		{
		 System.out.println("Enter Search keyword:(to exit type exit)");
		 Scanner in = new Scanner(System.in); 
	        phrase = in.nextLine();
		
	        
		//String[] s=inverted_index.names(phrase);
		int[][] topa=new int[s1.length-1][2];
		for(int qw=1;qw<s1.length;qw++)
		{
			//System.out.println(s1[qw]);
			
		
			topa[qw-1][1]=task1.freqin(s1[qw], phrase);
			topa[qw-1][0]=Integer.parseInt(s1[qw].split(".txt")[0]);
	
		}
		System.out.println("RefNo. 	Count 		Website" );
		 System.out.println("---------------------------------------------------------"); 
	     
		sort.sortbyColumn(topa, 1);
		for (int i = 0; i < topa.length; i++) { 
            for (int j = 0; j < 2; j++) 
            {
            	if(j==0)
            	{
                System.out.print(topa[i][j] + " 	"); 
                
                
            	}
            	else
            	{
            		
            		System.out.print(topa[i][j]+" 		");
            		System.out.print(fileread(topa[i][0]+".txt")+" ");
            	}
            }
            System.out.println("---------------------------------------------------------"); 
        } 
		System.out.println("---------------------------------------------------------");
		
		while(!(we==-1))
		{System.out.println("\nType the RefNo. of the webpage that you want to read to go back type code -1 ");
		we=in.nextInt();
		if(we==-1) {
			
		}
		else {
			String zx=fileread1(we+".txt");
			System.out.println(zx);
			System.out.println("---------------------------------------------------------");
			
			
			while(er==1|| er==2||er==3|| er==4)
			{
				System.out.println("You can perform following opperations on the page:\n1) To search a string\n2) To display all email addreses\n3) To display all URL\n4) Perform Spell-Check \n5) To exit  ");
				er=in.nextInt();
				if(er==1)
				{
					System.out.println("Enter the string that you wish to search:");
					
					String text=in.next();
					text="("+text+")[A-Za-z0-9-_.]*";
					//System.out.println(text);
					textSearch.patternfinder(zx, text);
				}
				else if(er==2)
				{
					textSearch.patternfinder(zx,"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
				}
				else if(er==3)
				{
					textSearch.patternfinder(zx,"^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
				}
				
				else if(er == 4) {
					EditDistance sc = new EditDistance();
			        sc.run();
				}
				System.out.println("---------------------------------------------------------");
				
			}er=1;
			
		}
		System.out.println("---------------------------------------------------------");
		}}


	}

	
	
	
	
	
}
