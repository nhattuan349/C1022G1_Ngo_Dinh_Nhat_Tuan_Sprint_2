package cau_hoi_java.day_4;

public class ChuyenChuoi {
    public static void main(String[] args) {
        String chuoi = "Cho một mảng số nguyên và một số nguyên N bất kỳ, output : vị trí của 2 số bất kỳ trong mảng có tổng bằng N";
        String ketQua = chuyenChuoi(chuoi);
        System.out.println(ketQua);
    }

    public static String chuyenChuoi(String chuoi) {
        String ketQua = "";

        chuoi = chuoi.trim(); // Xóa các khoảng trắng thừa ở đầu và cuối chuỗi
        chuoi = chuoi.substring(0, 1).toUpperCase() + chuoi.substring(1).toLowerCase(); // Chuyển đổi chữ hoa chữ đầu, chữ thường chữ sau

        for (int i = 0; i < chuoi.length(); i++) {
            char kyTu = chuoi.charAt(i);

            switch (kyTu) {
                case ' ':
                case '-':
                case '/':
                case '\\':
                case '.':
                case ',':
                case '(':
                case ')':
                case '[':
                case ']':
                case '{':
                case '}':
                case '<':
                case '>':
                case '=':
                case '+':
                case '*':
                case '&':
                case '^':
                case '%':
                case '$':
                case '#':
                case '@':
                case '!':
                case '?':
                case '\'':
                case '"':
                    ketQua += "_";
                    break;
                case 'ă':
                case 'â':
                case 'á':
                case 'à':
                case 'ả':
                case 'ã':
                case 'ạ':
                    ketQua += "a";
                    break;
                case 'ắ':
                case 'ằ':
                case 'ẳ':
                case 'ẵ':
                case 'ặ':
                    ketQua += "a";
                    break;
                case 'ấ':
                case 'ầ':
                case 'ẩ':
                case 'ẫ':
                case 'ậ':
                    ketQua += "a";
                    break;
                case 'é':
                case 'è':
                case 'ẻ':
                case 'ẽ':
                case 'ẹ':
                    ketQua += "e";
                    break;
                case 'ế':
                case 'ê':
                case 'ề':
                case 'ể':
                case 'ễ':
                case 'ệ':
                    ketQua += "e";
                    break;
                case 'í':
                case 'ì':
                case 'ỉ':
                case 'ĩ':
                case 'ị':
                    ketQua += "i";
                    break;
//                case 'ó':
//                case 'ò':
//                case 'ỏ':
//                case 'õ':
//                case 'ọ':
//                case 'ơ':
//                case 'ờ':
//                case 'ớ':
//                case 'ở':
//                case 'ỡ':
//                case 'ợ':
//                case 'ô':
//                case 'ồ':
//                case 'ố':
//                case 'ổ':
//                case 'ỗ':
//                case 'ộ':
//                    ketQua += "o";
//                    break;
                case 'ô':
                case 'ố':
                case 'ồ':
                case 'ổ':
                case 'ỗ':
                case 'ộ':
                    ketQua += "o";
                    break;
                case 'ớ':
                case 'ờ':
                case 'ở':
                case 'ỡ':
                case 'ợ':
                    ketQua += "o";
                    break;
                case 'ú':
                case 'ù':
                case 'ủ':
                case 'ũ':
                case 'ụ':
                    ketQua += "u";
                    break;
                case 'ứ':
                case 'ừ':
                case 'ử':
                case 'ữ':
                case 'ự':
                    ketQua += "u";
                    break;
                case 'ý':
                case 'ỳ':
                case 'ỷ':
                case 'ỹ':
                case 'ỵ':
                    ketQua += "y";
                    break;
                case 'đ':
                    ketQua += "d";
                    break;
                default:
                    ketQua += kyTu;
                    break;
            }
        }

        return ketQua;
    }
}

