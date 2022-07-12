// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        pair[]arr = new pair[n];
        for(int i=0;i<n;i++){
            arr[i]= new pair(start[i], end[i], i);
        }
        Arrays.sort(arr, (a,b)->{
            if(a.end==b.end)return a.p-b.p;
           return a.end-b.end; 
        });
        int ans=1;
        int limit= arr[0].end;
        for(int i=1;i<arr.length;i++){
            if(limit < arr[i].st){
                ans++;
                limit=arr[i].end;
            }
        }
        return ans;
        
    }
    static class pair{
        int st;
        int end;
        int p;
        pair(int st , int end , int p){
            this.st=st;
            this.end=end;
            this.p=p;
        }
    }
}
