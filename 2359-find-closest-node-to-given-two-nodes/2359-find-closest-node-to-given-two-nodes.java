class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int []a1 = new int[edges.length];
        int []a2 = new int[edges.length];
        Arrays.fill(a1, -1);
        Arrays.fill(a2,-1);
        bfs(edges, a1, node1);
        bfs(edges, a2, node2);
        int ans=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<a1.length;i++){
            // System.out.println(a1[i]+ " "+ a2[i]);
            if(a1[i]==-1 || a2[i]==-1)continue;
            int val =Math.max(a1[i], a2[i]);
            if(val<ans){
                ans=val;
                res=i;
            }
        }
        return res;
    }
    public void bfs(int[]e, int []a1, int n1){
        LinkedList<Integer>ls = new LinkedList<>();
        ls.add(n1);
        a1[n1]=0;
        while(ls.size()>0){
            int t= ls.removeFirst();
            if(e[t]!=-1 && a1[e[t]]==-1){
                ls.add(e[t]);
                a1[e[t]]= a1[t]+1;
            }
        }
    }
}