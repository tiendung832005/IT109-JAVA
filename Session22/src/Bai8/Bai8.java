package Bai8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bai8 {
    public static void main(String[] args) {
        String fileName = "products.dat";

        try {
            List<Product> productList = createSampleProducts();

            writeProductsToFile(productList, fileName);

            List<Product> loadedProducts = readProductsFromFile(fileName);

            displayProducts(loadedProducts);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop Dell XPS 13", 25000000));
        products.add(new Product(2, "iPhone 14 Pro Max", 28900000));
        products.add(new Product(3, "Samsung Galaxy S23", 19500000));
        products.add(new Product(4, "Tai nghe AirPods Pro", 4900000));
        products.add(new Product(5, "Máy ảnh Sony A7IV", 55000000));

        return products;
    }

    // Phương thức ghi danh sách sản phẩm vào file nhị phân
    private static void writeProductsToFile(List<Product> products, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(products);
            System.out.println("Đã ghi " + products.size() + " sản phẩm vào file " + fileName);
        }
    }

    // Phương thức đọc danh sách sản phẩm từ file nhị phân
    @SuppressWarnings("unchecked")
    private static List<Product> readProductsFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Product> products = (List<Product>) ois.readObject();
            System.out.println("Đã đọc " + products.size() + " sản phẩm từ file " + fileName);
            return products;
        }
    }

    private static void displayProducts(List<Product> products) {
        System.out.println("\n=== DANH SÁCH SẢN PHẨM ===");
        System.out.println("===================================================================================================");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("===================================================================================================");
        System.out.println("Tổng số sản phẩm: " + products.size());
    }
}
