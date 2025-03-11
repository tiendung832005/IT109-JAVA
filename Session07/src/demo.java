public class demo {
    public static void main(String[] args) {
        //1. Khai báo chuỗi Rikkei Academy là chuỗi String Builder
        StringBuilder raBuilder = new StringBuilder("Rikkei Academy");

        raBuilder.append(" - Học viện đào tạo CNTT");

        System.out.println("Kết quả nối chuỗi: " + raBuilder);
        raBuilder.insert(7, "Education");
        System.out.println("Kết quả thêm vào vị trí 7: " + raBuilder);
        raBuilder.replace(7, 17, "");
        System.out.println("Kết quả thay thế từ vị trí 7 đến 17: " + raBuilder);
        raBuilder.delete(7, 17);
        System.out.println("Kết quả xóa từ vị trí 7 đến 17: " + raBuilder);
        raBuilder.reverse();
        System.out.println("Kết quả đảo ngược: " + raBuilder);
    }
}
