Intuition
To maximize the product (nums[i]-1) * (nums[j]-1), we need to find the two maximum elements in the array. Subtracting 1 from each of these maximum elements will result in the maximum possible product.

Approach
Initialize two variables, max1 and max2, to store the two maximum elements. Set them to Integer.MIN_VALUE.
Iterate through the array, updating max1 and max2 accordingly.
Calculate and return the maximum product using the formula (max1 - 1) * (max2 - 1).
Complexity
Time Complexity: O(N), where N is the length of the array. We iterate through the array once.
Space Complexity: O(1), as we use a constant amount of extra space.

  
Code
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}


Two pointer
  class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = i+1;
        int maxi = Integer.MIN_VALUE;
    while(i<n-1)
    {
        int sum = ((nums[i]-1)*(nums[j]-1));
        maxi = Math.max(sum,maxi);
        if(j == n-1)
        {
            i++;
            j = i+1;
        }
        else{
        j++;
        }
    }

        return maxi;
    }
}
