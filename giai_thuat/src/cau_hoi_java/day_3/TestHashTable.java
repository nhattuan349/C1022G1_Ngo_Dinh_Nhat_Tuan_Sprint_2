package cau_hoi_java.day_3;

import java.util.Hashtable;

public class TestHashTable {
    public static void main(String[] args) {
        Hashtable<String, String> sinhVien= new Hashtable<>();

        String key = null;
        String value = null;

        try {
            sinhVien.put(key,"Value");
        }catch (NullPointerException e){
            System.out.println("Lỗi: NullPointerException khi thêm khóa null vào Hashtable");
        }

        try {
            sinhVien.put("key", value);
        }catch (NullPointerException e){
            System.out.println("Lỗi: NullPointerException khi thêm giá trị vào Hashtable");
        }

        try{
            String result = sinhVien.get(null);
            System.out.println("Giá trị dựa trên khóa null: " + result);
        }catch (NullPointerException e){
            System.out.println("Lỗi: NullPointerException khi truy cập vào giá trị dựa trên khóa null");
        }

    }
}
