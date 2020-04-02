//https://github.com/RomanHotsiy/LearningJava/blob/master/Data%20Structures/InvertedIndex.javathe
package search_engine;
import java.util.*;  // Provides TreeMap, Iterator, Scanner  
import java.io.*; 

class Index {
    Map<Integer,String> sources;
    HashMap<String, HashSet<Integer>> index;

    Index(){
        sources = new HashMap<Integer,String>();
        index = new HashMap<String, HashSet<Integer>>();
    }

    public void buildIndex(String[] files){
        int i = 0;
        for(String fileName:files){

            
            try(BufferedReader file = new BufferedReader(new FileReader(fileName)))
            {
                sources.put(i,fileName);
                String ln;
                while( (ln = file.readLine()) !=null) {
                    String[] words = ln.split("\\W+");
                    for(String word:words){
                        word = word.toLowerCase();
                        if (!index.containsKey(word))
                            index.put(word, new HashSet<Integer>());
                        index.get(word).add(i);
                    }
                }
            } catch (IOException e){
                System.out.println("File "+fileName+" not found. Skip it");
            }
            i++;
        }
        
    }

    public String find(String phrase){
        String[] words = phrase.split("\\W+");
        String s="";
        HashSet<Integer> res = new HashSet<Integer>(index.get(words[0].toLowerCase()));
        for(String word: words){
            res.retainAll(index.get(word));
        }

        if(res.size()==0) {
            System.out.println("Not found");
            return "";
        }
       // System.out.println("Found in: ");
        for(int num : res){
            s=s+" "+sources.get(num);
        }
        return s;
    }
}

public class inverted_index {
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
	public static String[] names(String as) throws IOException{
		String[] s=readfile("C:\\Users\\Heli\\eclipse-workspace\\search_engine");
		
		 Index index = new Index();
        index.buildIndex(s);//new String[]{"1.txt","10.txt","2.txt"});

       
        String ss="";
       ss=index.find(as);
        return ss.split(" ");
	}
}
