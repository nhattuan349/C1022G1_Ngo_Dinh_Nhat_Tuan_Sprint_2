package cau_hoi_java.day_3;

import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Nhập số hệ thập phân: ");
        int decimalNumber = scanner.nextInt();

        String octalNumber = Integer.toOctalString(decimalNumber);

        System.out.println("Số hệ bát phân: "+ octalNumber);

        scanner.close();
    }
}
