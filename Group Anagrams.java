Approach
Initialize Data Structures:
Initialize an empty list ans to store the final result.
Initialize a HashMap mp where the keys will be sorted strings (representing anagrams) and the values will be lists of strings (original strings that are anagrams of each other).
Group Anagrams:
Iterate through each string str in the input array strs.
Convert the string str into a character array chars.
Sort the character array chars to obtain a canonical representation of the string's characters.
Convert the sorted character array back to a string sortedStr.
Check if the sortedStr exists as a key in the mp HashMap. If not, create a new entry in mp with sortedStr as the key and an empty list as the value.
Add the original string str to the list corresponding to the key sortedStr in the mp HashMap.
Retrieve Anagram Groups:
Iterate through the values of the mp HashMap. Each value represents a list of strings that are anagrams of each other.
Add each list of anagrams to the final result list ans.
Return Result:
Return the final result list ans containing all the grouped anagrams.

Complexity
Time complexity: O(n * (k * log(k)))
Space complexity: O(n * k)
Code
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!mp.containsKey(sortedStr)) {
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(strs[i]);
        }

        for (List<String> group : mp.values()) {
            ans.add(group);
        }

        return ans;
    }
}
