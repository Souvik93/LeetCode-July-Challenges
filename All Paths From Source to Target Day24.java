/*

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

*/\


// Explanation - https://youtu.be/TABvtZB0Gto 

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> r = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(graph,path,r,0);
        
        
        return r;
        
        
    }
    
    private void dfs(int[][] graph,List<Integer> path,List<List<Integer>> r,int index) {
        
        if(index==graph.length-1) {
            
            r.add(new ArrayList<Integer>(path));

            return;
            
        }
        
        
        for(int n: graph[index]) {
            path.add(n);
            dfs(graph,path,r,n);
            path.remove(path.size()-1); // To back track to previous node.

        }
        
        
    }
}
