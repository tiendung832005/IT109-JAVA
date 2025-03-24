package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        // Khởi tạo set từ Set Interface và lớp triển khai HashSet: luu trữ dữ liệu ngẫu nhiên
        Set<String> setHashSet = new HashSet<String>();
        setHashSet.add("Java");
        setHashSet.add("Python");
        setHashSet.add("JavaScript");
        setHashSet.add("HTML");

        System.out.println("Dữ liệu sắp xếp ngẫu nhiên của hashSet: " + setHashSet);

        //Khởi tạo set từ Set Interface và lớp triển khai LinkedHashSet: lưu trữ dữ liệu theo thứu tự thêm vào
        Set<String> setLinkedHashSet = new LinkedHashSet<>();
        setLinkedHashSet.add("Java");
        setLinkedHashSet.add("Python");
        setLinkedHashSet.add("JavaScript");
        setLinkedHashSet.add("HTML");

        System.out.println("Dữ liệu sắp xếp theo thứ tự thêm vào của linkedHashSet: " + setLinkedHashSet);

        //Khởi tạo set từ Set Interface và lớp triển khai TreeSet: Lưu trữ dữ liệu theo thứ tự tự nhiên
        Set<String> setTreeSet = new TreeSet<>();
        setTreeSet.add("Java");
        setTreeSet.add("Python");
        setTreeSet.add("JavaScript");
        setTreeSet.add("HTML");

        System.out.println("Dữ liệu sắp xếp theo thứ tự tự nhiên của treeSet: " + setTreeSet);
    }
}
