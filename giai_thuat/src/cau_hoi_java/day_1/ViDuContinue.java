package cau_hoi_java.day_1;

public class ViDuContinue {

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            if (i == 3){
                    continue;
            }
            System.out.println("Giá trị của i là : " + i);
        }
    }

}
