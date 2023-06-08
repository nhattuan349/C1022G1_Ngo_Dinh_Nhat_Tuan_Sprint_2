package cau_hoi_java.presentation2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = 9;
        findSum(arr, num);
    }

    public static void findSum(int[] arr, int total) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        Optional<Integer> index = list.stream().filter(num -> list.contains(total - num)).findFirst();
        if (index.isPresent()) {
            int index1 = list.indexOf(index.get());
            int index2 = list.lastIndexOf(total - index.get());

            System.out.println("Vị trí của hai số có tổng bằng " + total + " là: " + index1 + " và " + index2);
        } else {
            System.out.println("Không tìm thấy cặp số có tổng bằng " + total + " trong mảng.");
        }
    }


    public static void check(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == num) {
                    System.out.println("Tổng 2 số bất kì bằng " + num + " là " + arr[i] + " và " + arr[j]);
                    System.out.println("Vị trí của số " + arr[i] + " là " + i);
                    System.out.println("Vị trí của số " + arr[j] + " là " + j);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {2, 8, 9, 5, 7, 4, 5, 6};
//        int num = 12;
//        check(arr, num);
//    }

}

