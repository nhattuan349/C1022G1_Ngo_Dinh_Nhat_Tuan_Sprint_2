package cau_hoi_java.day_1;

import java.util.Scanner;

public class ViDuSwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tháng (1-12): ");
        int thang = scanner.nextInt();

        String mua;
        switch (thang) {
            case 12:
            case 1:
            case 2:
                mua = "Mùa Đông";
                break;
            case 3:
            case 4:
            case 5:
                mua = "Mùa Xuân";
                break;
            case 6:
            case 7:
            case 8:
                mua = "Mùa Hè";
                break;
            case 9:
            case 10:
            case 11:
                mua = "Mùa Thu";
                break;
            default:
                mua = "Tháng không hợp lệ";
                break;
        }

        System.out.println("Tháng " + thang + " là " + mua);
    }
}
