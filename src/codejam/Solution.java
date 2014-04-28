package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import utils.FileHelper;

public class Solution {
	
	public static final String TINPUT="E:\\test.in";
	public static final String SINPUT="E:\\small.in";
	public static final String LINPUT="E:\\large.in";	
	public static final String OUTPUT="E:\\output.txt";
	
	public static void main(String[] args){
		long s=System.currentTimeMillis();
		readFileByLines(TINPUT);
		long e=System.currentTimeMillis();
		log("Time spent: "+(e-s)+" ms");
	}
	
	public static void solve(BufferedReader reader) throws IOException{
		long t=Long.parseLong(reader.readLine());
		
		String line = "";
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<=t;i++){
			line = reader.readLine();
			String[] strarr=line.split(" ");
			
			int n=Integer.parseInt(strarr[0]);
			int l=Integer.parseInt(strarr[1]);
			
			line = reader.readLine();
			String[] flow_str=line.split(" ");
			line = reader.readLine();
			String[] dev_str=line.split(" ");
			
			sb.append("Case "+i+": "+line);
			sb.append(System.lineSeparator());
		}
		
		FileHelper.writeFile(OUTPUT, sb.toString());
		log(sb.toString());
	}
	
	public static List<String> readFileByLines(String filePath){
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
             return null;
        }
        
        List<String> content = new ArrayList<String>();
        try {
             FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
             BufferedReader reader = new BufferedReader(inputStreamReader);
             solve(reader);             
             fileInputStream.close();
             inputStreamReader.close();
             reader.close();
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        }
        
        return content;
   }
	
	public static void log(Object content){
		System.out.println(content);
	}
}
