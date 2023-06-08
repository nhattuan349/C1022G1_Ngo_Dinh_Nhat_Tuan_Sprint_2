package cau_hoi_java.presentation3;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số: ");
        int number = scanner.nextInt();

        int reversedNumber = 0;

        while (number > 0) {
            int remainder = number % 10;  // Lấy chữ số cuối cùng
            reversedNumber = (reversedNumber * 10) + remainder;  // Thêm chữ số cuối vào đằng sau số đã đảo

            number = number / 10;  // Xóa chữ số cuối đi
            ;
        }

        System.out.println("Số ngược lại là: " + reversedNumber);
    }
}

