// Intuition
// To implement the FoodRatings class, we can use a combination of data structures such as HashMaps and PriorityQueues. We need to efficiently handle changing ratings and finding the highest-rated food for a given cuisine.

// Approach
// Create a class Info to represent a combination of food, cuisine, and rating.
// Use two maps: foodMap to store food information, and cuisineMap to store cuisine-specific PriorityQueues of Info objects.
// In the constructor, populate these maps based on the input arrays.
// For changeRating method, update the rating in foodMap and remove the corresponding Info object from the cuisineMap PriorityQueue.
// For highestRated method, continuously remove Info objects with empty food names from the PriorityQueue until a valid food name is found.
// Complexity
// Constructor:
// Time Complexity: O(n*log(n)), where n is the number of foods. We need to iterate through each food and insert into PriorityQueues.
// Space Complexity: O(n).
// changeRating:
// Time Complexity: O(log(n)), where n is the number of foods. PriorityQueue operations take logarithmic time.
// Space Complexity: O(1).
// highestRated:
// Time Complexity: O(log(n)), where n is the number of foods. Removing from PriorityQueue takes logarithmic time.
// Space Complexity: O(1).
Code
class FoodRatings {
    public class Info{
        String food;
        String cuisine;
        int rating;
        public Info(String food,String cuisine,int rating){
            this.food=food;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }
    Map<String,PriorityQueue<Info>> cuisineMap;
    Map<String, Info> foodMap;
    

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap=new HashMap<>();
        foodMap=new HashMap<>();
         for(int i=0; i<foods.length; i++){
            Info combo=new Info(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],combo);
            if(cuisineMap.containsKey(cuisines[i])){
                cuisineMap.get(cuisines[i]).add(combo);
            }
            else{
                PriorityQueue<Info> pq=new PriorityQueue<Info>(new Comparator<Info>(){
                    @Override
                    public int compare(Info a,Info b){
                        int result=b.rating-a.rating;
                        if(result==0){
                            return (a.food).compareTo(b.food);
                        }
                        return result;
                    } 
                }); 
                pq.add(combo);
               cuisineMap.put(cuisines[i],pq);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        Info prev=foodMap.get(food);
        Info curr= new Info(food,prev.cuisine,newRating);
        foodMap.put(food,curr);
        prev.food="";
        cuisineMap.get(prev.cuisine).add(curr);
             

        
    }
    
    public String highestRated(String cuisine) {
        while( cuisineMap.get(cuisine).peek().food.equals("")){
            cuisineMap.get(cuisine).remove();
        }
        return cuisineMap.get(cuisine).peek().food;
        
    }
   
}
