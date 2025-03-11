public class Bai2 {
    public static void main(String[] args) {

        String firstString = "Hello, Java World";
        System.out.println("Chuỗi ban đầu: " + firstString);

        StringBuilder strBuilder = new StringBuilder(firstString);

        strBuilder.delete(5, 10);
        String afterDelete = strBuilder.toString();
        System.out.println("Chuỗi sau khi xóa: " + afterDelete);


        strBuilder = new StringBuilder(firstString);


        int startPosition = firstString.indexOf("World");


        if (startPosition != -1) {
            strBuilder.replace(startPosition, startPosition + "World".length(), "Universe");
        }

        String afterReplacement = strBuilder.toString();
        System.out.println("Chuỗi sau khi thay thế: " + afterReplacement);
    }
}
