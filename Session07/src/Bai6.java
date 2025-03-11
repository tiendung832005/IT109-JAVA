public class Bai6 {
    public static void main(String[] args) {
        int count = 1000000;


        long start = System.currentTimeMillis();

        String String1 = "Hello";
        for (int i = 0; i < count; i++) {
            String1 += " World";
        }

        long end = System.currentTimeMillis();
        long thoiGianString = end - start;

        start = System.currentTimeMillis();

        StringBuilder strBuilder = new StringBuilder("Hello");
        for (int i = 0; i < count; i++) {
            strBuilder.append(" World");
        }

        end = System.currentTimeMillis();
        long timeStringBuilder = end - start;

        start = System.currentTimeMillis();

        StringBuffer strBuffer = new StringBuffer("Hello");
        for (int i = 0; i < count; i++) {
            strBuffer.append(" World");
        }

        end = System.currentTimeMillis();
        long timeStringBuffer = end - start;

        System.out.println("Kết quả đo hiệu suất nối chuỗi 1 triệu lần:");
        System.out.println("String: " + thoiGianString + " ms");
        System.out.println("StringBuilder: " + timeStringBuilder + " ms");
        System.out.println("StringBuffer: " + timeStringBuffer + " ms");
        /*
        * Nhận xét về hiệu suất:
        * 1. String: Chậm nhất vì mỗi lần nối chuỗi đều tạo một đối tượng mới
        * - Phù hợp khi: Chuỗi ít thay đổi hoặc số lần nối chuỗi ít
        * 2. StringBuilder: Nhanh nhất trong hầu hết trường hợp
        * - Phù hợp khi: Cần nối chuỗi nhiều lần trong môi trường đơn luồng
        * 3. StringBuffer: Nhanh hơn String nhưng chậm hơn StringBuilder
        * - Phù hợp khi: Cần đồng bộ hóa trong môi trường đa luồng
        * */
    }
}
