package cau_hoi_java.day_4;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 7, 7, 2};
        int target = 9;

        int[] result = findTwoSum(nums, target);
        if (result != null) {
            System.out.println("Vị trí của hai số có tổng " + target + " là: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Không tìm thấy hai số có tổng " + target + " trong mảng.");
        }
    }

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                int complementIndex = map.get(complement);
                return new int[] {complementIndex, i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}

