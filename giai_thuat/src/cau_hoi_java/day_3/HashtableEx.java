package cau_hoi_java.day_3;

import java.util.Hashtable;

public class HashtableEx {
    public static void main(String[] args) {
        Hashtable<String,String> sinhVien = new Hashtable<>();

        sinhVien.put("SV001", "Nguyễn Văn A");
        sinhVien.put("SV002", "Nguyễn Văn B");
        sinhVien.put("SV003", "Nguyễn Văn C");

        String maSv = "SV002";
        if (sinhVien.containsKey(maSv)){
            String tenSV = sinhVien.get(maSv);
            System.out.println("MaSV: "+ maSv + "tenSV:" + tenSV);
        }
        else {
            System.out.println("không tìm thấy sinh viên với mã:"+ maSv);
        }

        sinhVien.remove("SV001");

        for(String key : sinhVien.keySet()) {
            String value = sinhVien.get(key);
            System.out.println("Ma SV:" + key + "Tên SV: " +value);
        }
    }
}
