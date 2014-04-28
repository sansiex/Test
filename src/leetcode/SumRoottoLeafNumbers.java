package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class SumRoottoLeafNumbers {
	public static void main(String[] args){
		SumRoottoLeafNumbers sln=new SumRoottoLeafNumbers();
		TreeNode input=InitUtils.getTree("0_1,1_2,2_3,3_0,5_0,6_5");
		long s=System.currentTimeMillis();
		Object output=sln.sumNumbers(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
//        if(root==null){
//        	return 0;
//        }
//		Stack<TreeNode> trace=new Stack<TreeNode>();
//		HashSet<TreeNode> set=new HashSet<TreeNode>();
//		trace.push(root);
//		int cur=0;
//		int sum=0;
//		
//		while(!trace.isEmpty()){
//			TreeNode n=trace.peek();
//			if(set.contains(n)){
//				cur=(cur-n.val)/10;
//				trace.pop();
//				set.remove(n);
//				continue;
//			}
//			
//			cur=cur*10+n.val;
//			if(n.right==null & n.left==null){
//				sum+=cur;
//				cur=(cur-n.val)/10;
//				trace.pop();
//			}else{
//				set.add(n);
//				if(n.right!=null){
//					trace.push(n.right);
//				}
//				if(n.left!=null){
//					trace.push(n.left);
//				}
//			}
//		}
//		
//		return sum;
    }
	
	public int sumNumbers(TreeNode root, int preSum) {
		if(root==null){
			return 0;
		}
		
		int num=preSum*10+root.val;
		if(root.left==null && root.right==null){
			return num;
		}
		int res=0;	
		res+=sumNumbers(root.left,num);
		res+=sumNumbers(root.right,num);
		return res;
	}
}

