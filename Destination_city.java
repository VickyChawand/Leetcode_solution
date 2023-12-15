// Intuition
// The problem involves finding the destination city, which is the city without any outgoing path. We can approach this problem by first identifying all cities with outgoing paths. Then, among the destination cities, we find the one that has no outgoing path.

// Approach
// Initialize a HashSet cities to store all cities with outgoing paths.
// Iterate through the paths and add the starting city of each path to the cities set.
// Iterate through the paths again and check the destination city of each path. If the destination city is not in the cities set, it means there is no outgoing path from that city, so return it as the destination city.
// Complexity
// Time complexity: The time complexity is O(n) because we iterate through the paths twice.
// Space complexity: The space complexity is O(n) for storing the set of cities.
// Code
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>(); 
        for (List<String> path : paths) {
            cities.add(path.get(0)); 
        }
        
        for (List<String> path : paths) {
            String dest = path.get(1); 
            if (!cities.contains(dest)) {
                return dest; 
            }
        }
        return "";
    }
}
