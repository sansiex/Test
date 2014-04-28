package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	private HashMap<Integer,Node> map=new HashMap<Integer,Node>();
	private Node head=null;
	private Node tail=null;
	private int capacity;
	
	public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
    	int ret=-1;
    	Node n=map.get(key);
    	if(n!=null){
    		deleteNode(n);
    		addNode(n);
    		ret= n.val;
    	}
    	System.out.println(ret);
    	return ret;
    }
    
    public void set(int key, int value) {
        Node n=map.get(key);
        if(n!=null){
    		deleteNode(n);
    		n.val=value;
        }else{
        	if(map.size()>=capacity){
	        	map.remove(tail.key);
		        deleteNode(tail);
        	}
        	n=new Node(key,value); 
        	map.put(key, n);
        }
        addNode(n);
    }
    
    public Node deleteNode(Node n){
		if(n==null){
			return null;
		}
		if(tail==n){
			if(head==n){
				tail=null;
				head=null;
			}else{
				tail=tail.pre;
				tail.next=null;
			}			
		}else if(head==n){
			head=head.next;
			head.pre=null;
		}
		
		Node pre=n.pre;
		Node next=n.next;
		if(pre!=null){
			pre.next=next;
		}
		if(next!=null){
			next.pre=pre;
		}
		return n;
	}
    
    public void addNode(Node n){
    	if(head==null){
        	n.next=null;
        	n.pre=null;
    		head=n;
        	tail=n;
        	return;
    	}
    	
    	n.pre=null;
    	n.next=head;
    	head.pre=n;
    	head=n;
    }
    
    class Node{
    	Node pre;
    	Node next;
    	int key;
    	int val;
    	
    	public Node(int key,int val){
    		this.key=key;
    		this.val=val;
    		pre=null;
    		next=null;
    	}
    }
    
    public static void main(String[] args){
    	LRUCache cache=new LRUCache(3);
    	cache.set(1,1);
    	cache.set(2,2);
    	cache.set(3,3);
    	cache.set(4,4);
    	cache.get(4);
    	cache.get(3);
    	cache.get(2);
    	cache.get(1);
    	cache.set(5,5);
    	cache.get(1);
    	cache.get(2);
    	cache.get(3);
    	cache.get(4);
    	cache.get(5);
    }
}



