import java.sql.SQLOutput;

public class demo {
    public static void main(String[] args) {
        /*
        * 1. String Imutable - Khôn thể thay đổi dc giá trị (String Literal)
        * 2. 2 cách khai báo String
        *   - Cách 1: Literal -- primitive
        *       String variableName -- "value";
        *   - Cách 2: Constructor của lớp String --> object --> reference --> mutable
        *       String objName = new String("value")
        * */

        //1. Literal
        String str1 = "Rikkei Education";
        String str3 = "ptit";
        String str4 = "Rikkei Education";
        String str6 = "Rikkei Education";
        //2. Object
        String str2 = new String("Rikkei Education");
//        str2 = "RE";
        String str5 = new String("Rikkei Education");


        //3. Gán str1 bă rikkei
        str1 = "Rikkei Academy";

        /*
        * - So sánh chuỗi == hoặc equals
        * - So sánh == so sánh tuyệt đối
        * -  So sánh equals so sánh tương đối(giá trị)
        **/
        // 4. So sánh giá trị vs ==
        System.out.println("So sánh str4 và str6: "+ (str4==str6));//true
        System.out.println("So sánh str4 và str2: "+ (str4==str2));//false
        System.out.println("So sánh str2 và str5: "+ (str2==str5));//false

        // 5. So sánh giá trị vs equals
        System.out.println("So sánh str4 và str6: "+ str4.equals(str6));//true
        System.out.println("So sánh str4 và str2: "+ str4.equals(str2));//true
        System.out.println("So sánh str2 và str5: "+ str2.equals(str5));//true

        // 6. trim(): bỏ khoảng trắng hai đầu
        String str7 = "             RIKKEI EDUCATION            ";
        System.out.println("str7 sau khi trim: " + str7.trim());

        // 7. repalce(old, new):
        String str8 = str1.replace("Academy", "Học viện");
        System.out.println("str1 sau khi replace: " + str1);

        //8. String str = str1.subString(begin,end);
        String str9 = str1.substring(0, 6);
        System.out.println("str1 từ 0 đến 5: " + str9);
    }
}
