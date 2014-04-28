package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
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
	
	public static void solve(BufferedReader reader) throws IOException{
		long t=Long.parseLong(reader.readLine());
		
		String line = "";
		StringBuilder sb=new StringBuilder();
		
		for(int piter=1;piter<=t;piter++){
			line = reader.readLine();
			String[] strarr=line.split(" ");
			
			int r=Integer.parseInt(strarr[0]);
			int c=Integer.parseInt(strarr[1]);
			int m=Integer.parseInt(strarr[2]);

			char[][] b=new char[r][c];
			
			if(r*c<=m){
				b=null;
			}else{
				int s=r*c-m;
				int curs=1;
				int[] start={0,0};
				Stack<int[]> trace=new Stack<>();
				trace.add(start);
				Queue<int[]> act=new LinkedList<>();
				act.add(start);
				HashSet<int[]> set=new HashSet<>();
				set.add(start);
				
				b[0][0]='c';
				
				while(trace.size()>0){
					if(act.size()==0){
						
					}
					
					int[] cur=act.poll();
					final int[][] nb={{-1,1},{0,1},{1,1},{1,0},{1,-1}};
					ArrayList<int[]> temp=new ArrayList<>();
					
					for(int i=0;i<nb.length;i++){
						int[] sch={cur[0]+nb[i][0],cur[1]+nb[i][1]};
						
						if(set.contains(sch) || sch[0]<0 || sch[0]>=r || sch[1]<0 || sch[1]>=c){
							continue;
						}
						
						temp.add(sch);
					}
					
					if(temp.size()+curs>s || temp.size()==0){
						continue;
					}else if(temp.size()+curs<s){
						curs+=temp.size();
						trace.addAll(temp);
						act.addAll(temp);
						set.addAll(temp);
						for(int[] cell:temp){
							b[cell[0]][cell[1]]='.';
						}
					}else{
						//win
						for(int[] cell:temp){
							b[cell[0]][cell[1]]='.';
						}
						
						for(char[] row:b){
							for(int i=0;i<row.length;i++){
								if(row[i]!='c' && row[i]!='.'){
									row[i]='*';
								}
							}
						}
					}
				}
			}
			
			sb.append("Case "+piter+":");
			sb.append(System.lineSeparator());
			if(b==null){
				sb.append("Impossible");
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
