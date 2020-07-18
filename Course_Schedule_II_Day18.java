/*

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

   Hide Hint #1  
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
   Hide Hint #2  
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
   Hide Hint #3  
Topological sort could also be done via BFS.


*/


class Solution {
    
    int counter;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        counter = numCourses-1;
        int result[] = new int[numCourses];
        int visited[] = new int[numCourses];
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int course[]: prerequisites) {
            if(map.containsKey(course[1])) {
                map.get(course[1]).add(course[0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(course[0]);
                map.put(course[1],l);
            }
        }
        
        for(int i=0;i<numCourses;i++) {
            if(!tSort(i,map,visited,result)) {
                return new int[0];
            }
        }
        
        return result;
        
        
    }
    
    private boolean tSort(int vertex, Map<Integer,List<Integer>> map, int[] visited, int[] result) {
        
        if(visited[vertex]==-1) {
            return false;
        }
        
        if(visited[vertex]==1) {
            return true;
        }
        
        visited[vertex] = -1;
        
        if(map.containsKey(vertex)) {
            for(int course: map.get(vertex)) {
                if(!tSort(course,map,visited,result)) {
                    return false;
                }
            }
            
        }

        visited[vertex] = 1;
        result[counter--] = vertex;
        return true;
        
    }
}
