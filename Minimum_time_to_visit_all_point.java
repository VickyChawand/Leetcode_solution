Approach
Step-by-step approach:

    Initialize variables:
      ans: Represents the total time to visit all points, initially set to 0.
      n: Represents the number of points in the input array.
  
    Loop through points:
      Iterate through the array of points starting from the second point (index 1) because the calculation involves the previous point.
  
    Calculate differences:
      Calculate the absolute differences in x and y coordinates between the current point and the previous point using Math.abs().
  
    Update total time:
      Update the total time (ans) by adding the maximum of the x and y differences for each pair of consecutive points.
  
    Return the result:
      After processing all points, return the total time (ans) as the minimum time required to visit all points.

  
Complexity
  
    Time complexity: O(n), where n is the number of points. This is because the code iterates through the points array once.
    Space complexity: O(1) because the algorithm uses a constant amount of extra space regardless of the size of the input array.

Code
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length-1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int a = points[i+1][0];
            int b = points[i+1][1];
            
            time += Math.max(Math.abs(a - x), Math.abs(b - y));
        }
        return time;
    }
}
