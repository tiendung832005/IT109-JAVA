public class Bai4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        String result = (a && b) ? "Cả hai đều đúng" :
                (a || b) ? "Ít nhất một đúng" :
                        (!a && b) ? "Không đúng" : "";

        System.out.println(result);
        System.out.println("Kết quả của c là: " + c);
        c = !c;
        System.out.println("Kết quả sau đó c là: " + c);

        System.out.println(((a || b) && c) ? "(a || b) && c thỏa mãn" : "(a || b) && c không thỏa mãn");
    }
}
