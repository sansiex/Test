package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import utils.JsonUtils;

public class RecoverBinarySearchTree {
	public static void main(String[] args){
		RecoverBinarySearchTree sln=new RecoverBinarySearchTree();
		TreeNode input=InitUtils.getTree("0_2,1_3,2_1");
		long s=System.currentTimeMillis();
		//Object output=sln.recoverTree(input);
		sln.recoverTree(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		//System.out.println(JsonUtils.toJson(output));
		System.out.println(JsonUtils.toJson(input));
	}
	
	public TreeNode inorder(TreeNode root,TreeNode min,TreeNode max, ArrayList<TreeNode> ret){
		if(root==null){
			return null;
		}
		
		TreeNode ln=inorder(root.left,min,root,ret);
		if(ln==null){
			if(min!=null && root.val<min.val){
				ret.add(root);
				ret.add(min);
			}
		}else if(root.val<ln.val){
			ret.add(root);
			ret.add(ln);
		}
		TreeNode mrn=inorder(root.right,root,max,ret);
		
		
		return mrn==null?root:mrn;
	}
	
	public void recoverTree(TreeNode root) {
        if(root==null){
        	return;
        }
        
        ArrayList<TreeNode> ret=new ArrayList<>();
        inorder(root,null,null,ret);
        
        if(ret.size()==2){
        	int temp=ret.get(0).val;
        	ret.get(0).val=ret.get(1).val;
        	ret.get(1).val=temp;
        }else if(ret.size()==4){
        	int temp=ret.get(1).val;
        	ret.get(1).val=ret.get(2).val;
        	ret.get(2).val=temp;
        }
//        for(TreeNode n:ret){
//        	System.out.println(n.val);
//        }
        	
    }
}

