public class Bai3 {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        boolean isEqual = (x == y);
        boolean isNotEqual = (x != y);
        boolean isGreaterThan = (x > y);
        boolean isLessThan = (x < y);
        boolean isGreaterThanOrEqualTo = (x >= y);
        boolean isLessThanOrEqualTo = (x <= y);

        System.out.println(isGreaterThan ? "x lớn hơn y" :
                isEqual ? "x bằng y" :
                        isNotEqual ? "x khác y" : "Không có điều kiện nào đúng");

        double a = 7.7;
        double b = 7.7;

        if (a == b) {
            System.out.println("a bằng b");
        }else {
            System.out.println("a khác b");
        }

        String str1 = "Hello Java";
        String str2 = "Hello Java";

        System.out.println(str1.equals(str2) ? "str1 bằng str2" : "str1 khác str2");
    }
}
