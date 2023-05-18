package cau_hoi_java.day_3;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, String> sinhVien = new HashMap<>();

       sinhVien.put("SV001","Nguyễn Văn A");
       sinhVien.put("SV002","Nguyễn Văn B");
       sinhVien.put("SV003","Nguyễn Văn C");

       String maSv = "SV002";
       if (sinhVien.containsKey(maSv)){
           String tenSP = sinhVien.get(maSv);
           System.out.println("Mã SV:"+ maSv +"Tên SV:" +tenSP);
       }else {
           System.out.println("Không tìm thấy mã sinh viên này :" + maSv);
       }

       sinhVien.remove("SV001");

       for (String key: sinhVien.keySet()){
           String value = sinhVien.get(key);
           System.out.println("Mã :"+ key + "Tên Sv :" + value);
       }

    }
}
