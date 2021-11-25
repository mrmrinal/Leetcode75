import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int curr = 0; 
        int latestDuplicate = 0;

        HashMap<Character, Integer> contains = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(contains.containsKey(s.charAt(i))) {
                latestDuplicate = Math.max(contains.get(s.charAt(i)), latestDuplicate);
                curr = i - latestDuplicate;
                contains.put(s.charAt(i), i);

            } else {
                contains.put(s.charAt(i), i);
                curr = curr + 1;
            }
            longest = Math.max(curr, longest);

            //System.out.println("char: " + s.charAt(i) + " curr: " + curr + " longest : " + longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring test = new LongestSubstring();
        //System.out.println(test.maxSum(new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20}, 4, 4));
        //System.out.println(test.lengthOfLongestSubstring("pwwkew"));
        //System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(test.lengthOfLongestSubstring("bbbb"));
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }
    
    public int maxSum(int arr[], int n, int k){
        int biggestSum = 0;
        boolean carryOver = false;
        int carryOverSum = 0;
        int curr = 0;
        
        for(int i = 0; i < arr.length - k + 1; i++){
            if(!carryOver) {
                for(int j = 0; j < k; j++) {
                    curr += arr[i + j ];
                    if(curr > biggestSum) {
                        biggestSum = curr;
                    }
                    carryOver = true;
                }
                carryOverSum = curr - arr[i];
            } else {
                curr = carryOverSum + arr[i + k - 1];
                carryOverSum = curr - arr[i];
                if(curr > biggestSum) {
                    biggestSum = curr;
                }
            }
        }
        
        return biggestSum;
    }
    
}
