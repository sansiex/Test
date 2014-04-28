package leetcode;

import java.util.Stack;

import utils.JsonUtils;

public class EvaluateReversePolishNotation {
	public static void main(String[] args){
		EvaluateReversePolishNotation sln=new EvaluateReversePolishNotation();
		String[] input={"22","12","2","/","-"};
		Object output=sln.evalRPN(input);
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int evalRPN(String[] tokens) {
		if(tokens.length==0){
			return 0;
		}
		
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	String token=tokens[i];
        	if(token.equals("+")){
        		if(stack.size()<2){
        			return 0;
        		}
        		int num1=stack.pop();
        		int num2=stack.pop();
        		stack.push(num2+num1);
        	}else if(token.equals("-")){
        		if(stack.size()<2){
        			return 0;
        		}
        		int num1=stack.pop();
        		int num2=stack.pop();
        		stack.push(num2-num1);
        	}else if(token.equals("*")){
        		if(stack.size()<2){
        			return 0;
        		}
        		int num1=stack.pop();
        		int num2=stack.pop();
        		stack.push(num2*num1);
        	}else if(token.equals("/")){
        		if(stack.size()<2){
        			return 0;
        		}
        		int num1=stack.pop();
        		int num2=stack.pop();
        		stack.push(num2/num1);
        	}else{
        		int num=Integer.parseInt(token);
        		stack.push(num);
        	}
        }
        return stack.pop();
    }
}
