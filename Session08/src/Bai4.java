public class Bai4 {
    public static void main(String[] args) {
        String initialString = "abcdefghij".repeat(100000);
        System.out.println("StringBuilder...");
        testStringBuilder(new StringBuilder(initialString));
        System.out.println("\nStringBuffer...");
        testStringBuffer(new StringBuffer(initialString));
        // các thao tác trên StringBuffer đều nhanh hơn StringBuilder ngoại trừ thời gian xóa
    }

        private static void testStringBuilder(StringBuilder sb) {
            long start, end;
            start = System.nanoTime();
            String reversed = new String(sb.toString().toCharArray());
            end = System.nanoTime();
            System.out.println("Reverse time: " + (end - start) + " ns");

            start = System.nanoTime();
            String inserted = sb.substring(0, 100000) + "INSERTED" + sb.substring(100000);
            end = System.nanoTime();
            System.out.println("Insert time: " + (end - start));

            start = System.nanoTime();
            String deleted = sb.substring(0, 100000) + sb.substring(100010);
            end = System.nanoTime();
            System.out.println("Delete time: " + (end - start));

            start = System.nanoTime();
            String replaced = sb.toString().replace("abcdefgh", "REPLACED");
            end = System.nanoTime();
            System.out.println("Replace time: " + (end - start));
        }

        private static void testStringBuffer(StringBuffer sb) {
            long start, end;
            start = System.nanoTime();
            String reversed = new String(sb.toString().toCharArray());
            end = System.nanoTime();
            System.out.println("Reverse time: " + (end - start));

            start = System.nanoTime();
            String inserted = sb.substring(0, 500000) + "INSERTED" + sb.substring(500000);
            end = System.nanoTime();
            System.out.println("Insert time: " + (end - start));

            start = System.nanoTime();
            String deleted = sb.substring(0, 500000) + sb.substring(500010);
            end = System.nanoTime();
            System.out.println("Delete time: " + (end - start));

            start = System.nanoTime();
            String replaced = sb.toString().replace("abcdefgh", "REPLACED");
            end = System.nanoTime();
            System.out.println("Replace time: " + (end - start));
        }
    }

