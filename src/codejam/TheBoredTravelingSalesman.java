package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import utils.FileHelper;

//http://code.google.com/codejam/contest/2994486/dashboard#s=p2


public class TheBoredTravelingSalesman {
	
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
		long t=Long.parseLong(read(reader));
		
		String line = "";
		StringBuilder sb=new StringBuilder();
		
		for(int pitr=1;pitr<=t;pitr++){
			line = read(reader);			
			String[] sarr=line.split(" ");
			int n=Integer.parseInt(sarr[0]);
			int m=Integer.parseInt(sarr[1]);
			
			int[] codes=new int[n];
			HashMap<Integer,HashSet<Integer>> g=new HashMap<>();
			int mincode=999999;
			int mincity=0;
			for(int i=0;i<n;i++){
				line=read(reader);
				codes[i]=Integer.parseInt(line);
				if(codes[i]<mincode){
					mincode=codes[i];
					mincity=i+1;
				}
			}
			
			for(int i=0;i<n;i++){
				g.put(i+1, new HashSet<Integer>());
			}
			
			for(int i=0;i<m;i++){
				line=read(reader);
				sarr=line.split(" ");
				int f=Integer.parseInt(sarr[0]);
				int to=Integer.parseInt(sarr[1]);
				g.get(f).add(to);
				g.get(to).add(f);
			}
			
			StringBuilder cs=new StringBuilder(5*n);
			
			HashSet<Integer> exc=new HashSet<>();
			
			search(g,mincity,exc,cs,codes);
			
			
			String result=cs.toString();
			
			String append="Case #"+pitr+": "+result+System.lineSeparator();
			log(append);
			sb.append(append);
			
//			sb.append("Case #"+i+": "+result);
//			sb.append(System.lineSeparator());
		}
		
		FileHelper.writeFile(OUTPUT, sb.toString());
		log(sb.toString());
	}
	
	public static void search(HashMap<Integer,HashSet<Integer>> g, int f, HashSet<Integer> exc,StringBuilder cs, int[] codes){
		HashSet<Integer> nl=g.get(f);
		int minc=0;
		int minz=99999;
		for(int n:nl){
			if(codes[n-1]<minz){
				minz=codes[n-1];
				minc=n;
			}
		}
		cs.append(minz);
		g.get(f).remove(minc);
		g.get(minc).remove(f);
		exc.add(minc);
		
		HashSet<Integer> act=new HashSet<Integer>();
		for(int n:nl){
			if(n!=minc && !exc.contains(n)){
				act.add(n);
			}
		}
		f=minc;
		
		boolean r=reachable(g,f,minc,exc);
		if(!r){
			search(g,minc,exc,cs,codes);
		}else{
			HashSet<Integer> l=g.get(f);
			for(int n:l){
				if(!exc.contains(n)){
					act.add(n);
				}
			}
			
			minc=0;
			minz=99999;
			while(!act.isEmpty()){
				for(int c:act){
					if(codes[c-1]<minz){
						minz=codes[c-1];
						minc=c;
					}
				}
				
				cs.append(minz);
				g.get(f).remove(minc);
				g.get(minc).remove(f);
				exc.add(minc);
				
				if(!reachable(g,f,minc,exc)){
					search(g,minc,exc,cs,codes);
				}
				nl=g.get(minc);
				act.addAll(nl);
				
			}
		}
	}
	
	public static boolean reachable(HashMap<Integer,HashSet<Integer>> g, int f, int t, HashSet<Integer> exclude){
		HashSet<Integer> nl=g.get(f);
		exclude.add(f);
		for(Integer n:nl){
			if(n==t){
				return true;
			}
			if(exclude.contains(n)){
				continue;
			}
			boolean ret=reachable(g,n,t,exclude);
			if(ret){
				return true;
			}
		}
		exclude.remove(f);
		return false;
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

