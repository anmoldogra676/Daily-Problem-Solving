// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static int isCircle(int N, String A[])
    {
    
        // code here
        HashMap<Character, ArrayList<Character>>hs = new HashMap<>();
        HashMap<Character, ArrayList<Character>>rhs = new HashMap<>();
        // check for Strong connected component
        int[]indegre= new int[26];
        int[]outdegre = new int[26];
        for(int i=0;i<N ;i++){
        
            String aa = A[i];
            char fc = aa.charAt(0);
            char lc= aa.charAt(aa.length()-1);
            indegre[lc-'a']++;
            outdegre[fc-'a']++;
            if(hs.get(fc)==null){
                hs.put(fc, new ArrayList<>());
            }
            ArrayList<Character>an = hs.get(fc);
            an.add(lc);
            hs.put(fc,an );
            // reverse
            if(rhs.get(lc)==null){
                rhs.put(lc, new ArrayList<>());
            }
            ArrayList<Character>an1 = rhs.get(lc);
            an1.add(fc);
            hs.put(lc,an1 );
            
        }
        // a->c
        // b->d
        // c->f

   
        // check same component
        
        boolean []vis = new boolean[26];
        Stack<Character>st = new Stack<>();
        for(char ch:hs.keySet() ){
            if(!vis[ch-'a']){
                // dfs call
                dfs(hs, st, vis,ch);
            }
        }
        // transpose toh hai 
        // System.out.println(st);
        vis= new boolean[26];
        int c=1;
        while(st.size()>0){
            char ch= st.pop();
            if(vis[ch-'a']==false){
                dfs1(hs,vis,ch);
                c++;
            }
        }
        if(c>2)return 0;
        
             for(int i=0;i<26;i++){
            if(indegre[i]!=outdegre[i]){
                return 0;
            }
        }
        
        return 1;
    }
    public static void dfs(  HashMap<Character, ArrayList<Character>>hs , Stack<Character>st, boolean[]vis, char ch){
        vis[ch-'a']=true;
        for(char ch1: hs.get(ch)){
            if(vis[ch1-'a']==false){
                dfs(hs, st, vis, ch1);
            }
        }
        st.push(ch);
    }
    
    public static  void dfs1(  HashMap<Character, ArrayList<Character>>hs ,  boolean[]vis, char ch){
        vis[ch-'a']=true;
        for(char ch1: hs.get(ch)){
            if(vis[ch1-'a']==false){
                dfs1(hs, vis, ch1);
            }
        }
      
    }
   
}
