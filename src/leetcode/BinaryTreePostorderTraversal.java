package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class BinaryTreePostorderTraversal {
	public static void main(String[] args){
		BinaryTreePostorderTraversal sln=new BinaryTreePostorderTraversal();
		TreeNode input=InitUtils.getTree("0_0,1_1,2_2,3_3,4_4,6_5,13_6");
		//InitUtils.printSinglyList(input);
		Object output=sln.postorderTraversal(input);
		System.out.println(JsonUtils.toJson(output));
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {		
        ArrayList<Integer> ret=new ArrayList<Integer>();
        if(root==null){
			return ret;
		}
        
        HashSet<TreeNode> trace=new HashSet<TreeNode>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode r=stack.pop();
        	if(trace.contains(r)){
        		ret.add(r.val);
        	}else{
        		trace.add(r);
        		stack.push(r);
        		
        		if(r.right!=null){
            		stack.push(r.right);
            	}
            	if(r.left!=null){
            		stack.push(r.left);
            	}
        	}       	
        	
        }
        return ret;
    }
}

