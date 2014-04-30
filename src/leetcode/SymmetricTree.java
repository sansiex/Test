package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import utils.JsonUtils;

public class SymmetricTree {
	public static void main(String[] args){
		SymmetricTree sln=new SymmetricTree();
		TreeNode input=InitUtils.getTree("0_1,1_2,2_2");
		long s=System.currentTimeMillis();
		Object output=sln.isSymmetric(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public boolean isMirror(TreeNode l,TreeNode r){
		if(l==null && r==null){
			return true;
		}else if(l==null || r==null){
			return false;
		}
		
		if(l.val!=r.val){
			return false;
		}
		
		return isMirror(l.left,r.right) && isMirror(l.right,r.left);
	}
	
	public boolean isSymmetric(TreeNode root) {
        if(root==null){
        	return true;
        }
        
        return isMirror(root.left,root.right);
    }
}

