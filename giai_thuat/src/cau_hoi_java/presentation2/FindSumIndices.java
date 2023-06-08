package cau_hoi_java.presentation2;

import java.util.HashMap;
import java.util.Map;

public class FindSumIndices {

    public static int[] findSumIndices(int[] arr, int N) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = N - arr[i];
            if (numIndices.containsKey(complement)) {
                return new int[] { numIndices.get(complement), i };
            }
            numIndices.put(arr[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 7, 9 };
        int N = 13;

        int[] result = findSumIndices(arr, N);

        if (result != null) {
            System.out.println("Vị trí của hai số có tổng " + N + " là: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("Không tìm thấy cặp số có tổng " + N + " trong mảng.");
        }
    }



}
