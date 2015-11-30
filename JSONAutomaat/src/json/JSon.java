package json;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URL;


public class JSon {


    public static void main(String[] args){
        JSon a = new JSon();
        a.getData();
        //System.out.println("Comments: " + a.getCommentsData());
    }
    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    protected int getData() {
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/comments");
            JSONParser parser = new JSONParser();

            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object comments = parser.parse(readAll(bufferedReader));
            JSONArray commentsArray = (JSONArray) comments;
            
            url = new URL("http://jsonplaceholder.typicode.com/todos");
            is = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object todos = parser.parse(readAll(bufferedReader));
            JSONArray todosArray = (JSONArray) todos;
            System.out.println(commentsArray.size() + " " + todosArray.size());
            return (commentsArray.size() - todosArray.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int getCommentsData(JSONArray commentsArray) {
    	try {
	    	URL url = new URL("http://jsonplaceholder.typicode.com/comments");
	        JSONParser parser = new JSONParser();
	        InputStream is = url.openStream();
	        InputStreamReader inputStream = new InputStreamReader(is);
	        BufferedReader bufferedReader = new BufferedReader(inputStream);
	        Object comments = parser.parse(readAll(bufferedReader));
	        commentsArray = (JSONArray) comments;
	        return commentsArray.size();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return 0;
    }
    
    public int getTodosData(JSONArray todosArray) {
    	try {
    		URL url = new URL("http://jsonplaceholder.typicode.com/todos");
    		JSONParser parser = new JSONParser();
            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object todos = parser.parse(readAll(bufferedReader));
            todosArray = (JSONArray) todos;
            return todosArray.size();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return 0;
    }
    
}
