// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] arr, int n, int K)
    {
        // Write your code here
        // Question basically --> kaun phle aata hai order of character
        // u->v ko edge 
        HashMap<Character , ArrayList<Character>>hs = new HashMap<>();
        for(int i=0 ;i<K;i++){
            char ch =(char)('a'+i);
            hs.put(ch, new ArrayList<>());
        }
        for(int i=0;i<arr.length-1 ;i++){
            String s1 = arr[i];
            String s2 = arr[i+1];
            for(int j=0;j<Math.min(s1.length(), s2.length() );j++){
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);
                if(ch1!=ch2){
                    ArrayList<Character>as = hs.get(ch1);
                    as.add(ch2);
                    hs.put(ch1 ,as);
                    break;
                }
            }
        }
        // graph bn gya hai simple dfs call
        boolean vis[] = new boolean[K];
        Stack<Character>st = new Stack<>();
        for(int i=0; i<K;i++){
            if(!vis[i]){
                char ch = (char)('a'+i);
                dfs(vis ,ch, hs, st);
            }
        }
        String s="";
        while(st.size()>0){
            s+=st.pop();
        }
        return s;

    }
    public void dfs( boolean[]vis , char ch, HashMap<Character, ArrayList<Character>>hs, Stack<Character>st)
    {
        vis[ch-'a']=true;
        for(Character ch1: hs.get(ch)){
            if(vis[ch1-'a']==false){
                dfs(vis, ch1, hs, st);
            }
        }
        st.push(ch);
    }
    
    
    
    
    
    
    
}