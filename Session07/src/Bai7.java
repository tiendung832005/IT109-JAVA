import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi PascalCase hoặc camelCase: ");
        String chuoiNhap = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        if (chuoiNhap.length() > 0) {

            char firstStr = chuoiNhap.charAt(0);

            if (firstStr >= 'A' && firstStr <= 'Z') {
                firstStr = (char) (firstStr + 32);
            }
            result.append(firstStr);

            for (int i = 1; i < chuoiNhap.length(); i++) {
                char character = chuoiNhap.charAt(i);

                if (character >= 'A' && character <= 'Z') {

                    result.append('_');


                    char characterLow = (char) (character + 32);
                    result.append(characterLow);
                } else {

                    result.append(character);
                }
            }
        }
        System.out.println("Kết quả (snake_case): " + result.toString());
        scanner.close();
    }
}
