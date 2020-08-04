package com.leetcode.top75;

import java.util.*;

public class CourseSchedule {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer,ArrayList<Integer>> dep = new HashMap<>();
            int[] indeg = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();

            //get the dependency list
            for( int[] arr:prerequisites){
                ArrayList<Integer> list = dep.getOrDefault(arr[0],new ArrayList<>());
                list.add(arr[1]);
                dep.put(arr[0],list);
                indeg[arr[1]]++;
            }
            //add courses which have 0 dependents to the queue
            for(int i=0;i<numCourses;i++){
                if(indeg[i]==0)
                    queue.add(i);
            }
            int count =0;

            //loop the queue until its empty
            while(!queue.isEmpty()){
                int course = queue.poll();
                count++;
                ArrayList<Integer> neighbours = dep.getOrDefault(course,new ArrayList<Integer>());
                for(int c: neighbours){
                    indeg[c]--;
                    if(indeg[c]==0)
                        queue.add(c);
                }
            }
            return count==numCourses;
        }
    }
}
