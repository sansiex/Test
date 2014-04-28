package leetcode;

import java.util.HashMap;

import utils.JsonUtils;

public class MaxPointsonaLine {
	public static void main(String[] args){
		MaxPointsonaLine sln=new MaxPointsonaLine();
		Point[] input={new Point(0,0),new Point(1,1),new Point(0,0)};
		Object output=sln.maxPoints(input);
		System.out.println(JsonUtils.toJson(output));
	}
	
	double dif=1e-9;
	
	public int maxPoints(Point[] points) {
        if(points.length<=2){
        	return points.length;
        }
        
        int max=2;
		for(Point p1:points){	
			HashMap<Double,Integer> map=new HashMap<Double,Integer>();
			
			int start=1;
			for(Point p2:points){
				if(p1==p2) continue;
	        	
	        	if(p1.x==p2.x && p1.y==p2.y){
	        		start++;
	        		for(java.util.Map.Entry<Double, Integer> ent:map.entrySet()){
	        			ent.setValue(ent.getValue()+1);
	        		}
	        	}else{ 
	        		double l=0;
	        		if(eq(p1.x-p2.x,0)){
		        		l=Double.MAX_VALUE;
		        	}else{
		        		if(eq(p1.y,p2.y)){
		        			l=0;
		        		}else{
			        		l=((double)(p1.y-p2.y))/((double)(p1.x-p2.x));
		        		}
		        	}
		        	Integer c=map.get(l);
		        	if(c!=null){
		        		map.put(l, c+1);
		        	}else{
		        		map.put(l, start+1);
		        	}
	        	}	        	
			}  
			if(start>max){
				max=start;
			}
			for(Integer c:map.values()){
				if(c>max){
					max=c;
				}
			}
        }
		return max;
    }
	
	public boolean inTheLine(Point p, Point[] line){
		Point p1=line[0];
		Point p2=line[1];
		double d1=((double)(p.y-p1.y))/((double)(p.x-p1.x));
		double d2=((double)(p.y-p2.y))/((double)(p.x-p2.x));
		return eq(d1,d2);
	}
	
	public boolean eq(double d1,double d2){
		return Math.abs(d1-d2)<dif;
	}
}


