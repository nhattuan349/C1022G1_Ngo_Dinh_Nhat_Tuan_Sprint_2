package cau_hoi_java.presentation2;

public class FindSumIndices2 {

    public static int[] findSumIndices(int[] arr, int N) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == N) {
                return new int[] { left, right };
            } else if (sum < N) {
                left++;
            } else {
                right--;
            }
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

