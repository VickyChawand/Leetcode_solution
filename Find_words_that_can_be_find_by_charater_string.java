Problem Explaination:
We are given an array of strings words and a string chars. Our task is to find the sum of lengths of all words in words that can be formed using the characters in chars. We can use each character in chars only once.

🔍 Methods To Solve This Problem:
I'll be covering four different methods to solve this problem:

Brute Force
Hash Map
Counting Characters
Optimized Hash Map
1. Brute Force:
Iterate through each word in words.
For each word, check if it can be formed using the characters in chars.
If yes, add the length of the word to the result.
Complexity
⏱️ Time Complexity: O(N * M * K), where N is the number of words, M is the average length of a word, and K is the length of chars.
🚀 Space Complexity: O(1)

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for (String word : words) {
            if (canFormWord(word, chars)) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canFormWord(String word, String chars) {
        int[] charCount = new int[26];

        for (char ch : chars.toCharArray()) {
            charCount[ch - 'a']++;
        }
        for (char ch : word.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }
        return true;
    }
}


2. Hash Map:
Create a frequency map for the characters in chars.
Iterate through each word in words.
For each word, create a frequency map.
Check if the word's frequency map is a subset of the chars frequency map.
If yes, add the length of the word to the result.
Complexity
⏱️ Time Complexity: O(N * (M + K)), where N is the number of words, M is the average length of a word, and K is the length of chars.
🚀 Space Complexity: O(K)
Code

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        for (String word : words) {
            if (canFormWord(word, charFreqMap)) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canFormWord(String word, Map<Character, Integer> charFreqMap) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (!charFreqMap.containsKey(ch) || charFreqMap.get(ch) < count) {
                return false;
            }
        }
        return true;
    }
}


3. Counting Characters:
Create an array to count the occurrences of each character in chars.
Iterate through each word in words.
For each word, create a temporary array to count the occurrences of each character.
Check if the temporary array is less than or equal to the array created in step 1.
If yes, add the length of the word to the result.
Complexity
⏱️ Time Complexity: O(N * (M + K)), where N is the number of words, M is the average length of a word, and K is the length of chars.
🚀 Space Complexity: O(1)
Code

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] charCount = new int[26];
        for (char ch : chars.toCharArray()) {
            charCount[ch - 'a']++;
        }
        for (String word : words) {
            if (canFormWord(word, charCount.clone())) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canFormWord(String word, int[] charCount) {
        for (char ch : word.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }
        return true;
    }
}

4. Optimized Hash Map:
Create a frequency map for the characters in chars.
Iterate through each word in words.
For each word, decrement the frequency of characters in the map.
Check if any character's frequency becomes negative during this process.
If no negative frequencies are encountered, add the length of the word to the result.
Complexity
⏱️ Time Complexity: O(N * M), where N is the number of words and M is the average length of a word.
🚀 Space Complexity: O(K)
Code


  import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        for (String word : words) {
            if (canFormWord(word, new HashMap<>(charFreqMap))) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canFormWord(String word, Map<Character, Integer> charFreqMap) {
        for (char ch : word.toCharArray()) {
            if (!charFreqMap.containsKey(ch) || charFreqMap.get(ch) == 0) {
                return false;
            }
            charFreqMap.put(ch, charFreqMap.get(ch) - 1);
        }
        return true;
    }
}
