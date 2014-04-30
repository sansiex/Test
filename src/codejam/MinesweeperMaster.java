package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.FileHelper;


//https://code.google.com/codejam/contest/2974486/dashboard#s=p2
//TODO

public class MinesweeperMaster {
	
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
	
	public static ArrayList<int[]> spread(char[][] b, int[] act, int cur_s, int s){
		int[][] nb={{-1,-1},{-1,0},{0,-1},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
		ArrayList<int[]> list=new ArrayList<>();
		ArrayList<int[]> trace=new ArrayList<>();
		for(int[] c:nb){
			int[] cur={c[0]+act[0],c[1]+act[1]};
			if(c[0]+act[0]<0 || c[1]+act[1]<0 || cur[0]>=b.length || cur[1]>=b[0].length || b[cur[0]][cur[1]]!=0){
				continue;
			}else{
				list.add(cur);
				b[cur[0]][cur[1]]='.';
			}
		}
		
		if(list.size()+cur_s>s){
			for(int[] c:list){
				b[c[0]][c[1]]=0;
			}
			return null;
		}else if(list.size()+cur_s<s){
			trace.addAll(list);
			for(int[] c:list){
				ArrayList<int[]> fill=spread(b,c,cur_s+trace.size(),s);
				if(fill==null){
					continue;
				}else{
					if(fill.size()+trace.size()+cur_s==s){
						trace.addAll(fill);
						return trace;
					}else{
						trace.addAll(fill);
					}
				}
			}
//			if(trace.size()==list.size()){
//				for(int[] c:list){
//					b[c[0]][c[1]]=0;
//				}
//			}
			return trace;
		}else{
			return trace;
		}
	}
	
	public static void solve(BufferedReader reader) throws IOException{
		long t=Long.parseLong(reader.readLine());
		log(t);
		String line = "";
		StringBuilder sb=new StringBuilder();
		
		for(int piter=1;piter<=t;piter++){
			line = reader.readLine();
			log(line);
			String[] strarr=line.split(" ");
			
			int r=Integer.parseInt(strarr[0]);
			int c=Integer.parseInt(strarr[1]);
			int m=Integer.parseInt(strarr[2]);

			char[][] b=new char[r][c];
			b[0][0]='c';
			if(r*c<=m){
				b=null;
			}else{
				int s=r*c-m;
				int curs=1;
				int[] start={0,0};
				ArrayList<int[]> ret=spread(b,start,curs,s);
				if(ret==null){
					b=null;
				}else{
					for(char[] row: b){
						for(int i=0;i<row.length;i++){
							if(row[i]==0){
								row[i]='*';
							}
						}
					}
				}
			}
			
			sb.append("Case "+piter+":");
			sb.append(System.lineSeparator());
			if(b==null){
				sb.append("Impossible");
				sb.append(System.lineSeparator());
			}else{
				for(char[] row:b){
					for(int i=0;i<row.length;i++){
						sb.append(row[i]);
					}
					sb.append(System.lineSeparator());
				}
			}
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
