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
import utils.JsonUtils;

//http://code.google.com/codejam/contest/2994486/dashboard
//small solved
//large solved


public class TheRepeater {
	
	public static final String TINPUT="E:\\test.in";
	public static final String SINPUT="E:\\small.in";
	public static final String LINPUT="E:\\large.in";	
	public static final String OUTPUT="E:\\output.txt";
	
	public static void main(String[] args){
		long s=System.currentTimeMillis();
		readFileByLines(LINPUT);
		long e=System.currentTimeMillis();
		log("Time spent: "+(e-s)+" ms");
	}
	
	public static void solve(BufferedReader reader) throws IOException{
		long t=Long.parseLong(read(reader));
		
		String line = "";
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<=t;i++){
			line = read(reader);			
			int n=Integer.parseInt(line);
			
			String[] sarr=new String[n];
			for(int j=0;j<n;j++){
				sarr[j]=read(reader);
			}
			
			ArrayList<Character> clist=new ArrayList<>();
			char lc=sarr[0].charAt(0);
			clist.add(lc);
			
			for(int j=1;j<sarr[0].length();j++){
				char c=sarr[0].charAt(j);
				if(c!=lc){
					clist.add(c);
					lc=c;
				}
			}
			
			int[][] cc=new int[n][clist.size()];
			int[] tc=new int[clist.size()];
			boolean suc=true;
			for(int j=0;j<n;j++){
				
				int ci=0;
				int ccc=0;
				String str=sarr[j];
				if(str.charAt(0)!=clist.get(0)){
					suc=false;
					break;
				}
				for(int k=0;k<str.length();k++){
					char c=str.charAt(k);
					
					if(c==clist.get(ci)){
						ccc++;
					}else{
						if(ci==clist.size()-1){
							suc=false;
							break;
						}
						
						char nc=clist.get(ci+1);
						if(c!=nc){
							suc=false;
							break;
						}
						
						cc[j][ci]=ccc;
						tc[ci]+=ccc;
						ccc=1;
						ci++;
					}
				}
				if(!suc || ci<clist.size()-1){
					suc=false;
					break;
				}
				cc[j][ci]=ccc;
				tc[ci]+=ccc;
			}
			
			int act=0;
			
			if(suc){
				for(int j=0;j<tc.length;j++){
					int min=Integer.MAX_VALUE;
					for(int l=1;l<101;l++){
						int cura=0;
						for(int k=0;k<n;k++){
							cura+=Math.abs(l-cc[k][j]);
						}
						min=Math.min(min, cura);
					}
					act+=min;
				}
			}
			
			String result="Fegla Won";
			if(suc){
				result=""+act;
			}
			
			String append="Case #"+i+": "+result+System.lineSeparator();
			log("UC:"+JsonUtils.toJson(clist));
			log(append);
			sb.append(append);
			
//			sb.append("Case #"+i+": "+result);
//			sb.append(System.lineSeparator());
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
	
	public static String read(BufferedReader reader) throws IOException{
		String line=reader.readLine();
		log(line);
		return line;
	}
}

