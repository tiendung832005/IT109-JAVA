import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        // So sánh 2 chuỗi biểu thức chính quy(regex) và chuô đầu vào(input)
        String regex = "(09|03|05)\\d{8}";
        String input1 = "0355914029";
        System.out.println("Kết quả so khớp của regex v input1: "+ Pattern.matches(regex,input1));
        String input2 = "03559140290";
        System.out.println("Kết quả so khớp của regex v input2: "+ Pattern.matches(regex,input2));
        String input3 = "0855914029";
        System.out.println("Kết quả so khớp của regex v input3: "+ Pattern.matches(regex,input3));

        System.out.println("'.' đại diện cho 1 ký tự bất kỳ: " + Pattern.matches("KS2.B", "KS23B"));

    }
}
