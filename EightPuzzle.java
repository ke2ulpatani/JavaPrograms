import java.util.*;
import java.io.*;

class EightPuzzle{
    
    Queue<String> q = new LinkedList<String>();   
    Map<String,Integer> map = new HashMap<String, Integer>();
    
    static void splitPrint(String str)
    {
    	System.out.println();
    	int count =0;
    	int i=0;
    	while(i<=8)
    	{
    		if (count <=2)
    		{
    			System.out.print(str.charAt(i)+"  ");
    			i++;
    			count++;
    		}
    		
    		if(count > 2)
    		{
    			System.out.println();
    			count =0;
    		}
    	}
    	System.out.println();
    	
    }
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the initial configuration as a String:\t");
        String str= br.readLine(); //"087465132";                 
        EightPuzzle e = new EightPuzzle();    
        System.out.println();
        e.add(str,0);                           
        
        while(e.q.peek()!=null){
            
            e.up(e.q.peek());                   
            e.down(e.q.peek());                 
            e.left(e.q.peek());                 
            e.right(e.q.remove());              
        }
        System.out.println("Solution doesn't exist");
    }
    
    
    void add(String str,int n){
        if(!map.containsKey(str)){
            map.put(str,n);
            q.add(str);
        }
    }
    
    
    void up(String str){
        int a = str.indexOf("0");
        if(a>2){
            String s = str.substring(0,a-3)+"0"+str.substring(a-2,a)+str.charAt(a-3)+str.substring(a+1);
            add(s,map.get(str)+1);
            if(s.equals("012345678")) {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            	System.exit(0);
            }
            else
            {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            }
        }
    }
    void down(String str){
        int a = str.indexOf("0");
        if(a<6){
            String s = str.substring(0,a)+str.substring(a+3,a+4)+str.substring(a+1,a+3)+"0"+str.substring(a+4);
            add(s,map.get(str)+1);
            if(s.equals("012345678")) {
            	System.out.println("Current State:\n");
            	splitPrint(s);
                System.exit(0);
            }
            else
            {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            }
        }
    }
    void left(String str){
        int a = str.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String s = str.substring(0,a-1)+"0"+str.charAt(a-1)+str.substring(a+1);
            add(s,map.get(str)+1);
            if(s.equals("012345678")) {
            	System.out.println("Current State:\n");
            	splitPrint(s);
                System.exit(0);
            }
            else
            {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            }
        }
    }
    void right(String str){
        int a = str.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String s = str.substring(0,a)+str.charAt(a+1)+"0"+str.substring(a+2);
            add(s,map.get(str)+1);
            if(s.equals("012345678")) {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            	
                System.exit(0);
            }
            else
            {
            	System.out.println("Current State:\n");
            	splitPrint(s);
            }
        }
    }
}



