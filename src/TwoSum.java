import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!bucket.containsKey(target - nums[i])){
                bucket.put(nums[i], i);
            } else {
                return new int[]{bucket.get((target - nums[i])), i};
            }
        }
        return new int[]{};
    }
}
