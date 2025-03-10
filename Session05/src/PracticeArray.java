import java.util.Scanner;

public class PracticeArray {
    public static void main(String[] args) {
        /*
         * 1. Nhập số phần tử của mảng và khai báo số nguyên 1 chiều gồm n phần tử, nhập giá trị các phần tử
         * 2. Nhập giá trị và chỉ số phần tử chèn vào mảng
         * */
        // 1. Nhập số phần tử, khai báo mảng, nhập giá trị phần tử

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào phần tử của mảng: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] oldArray = new int[size];

        for(int i = 0; i < size; i++){
            System.out.printf("oldArray[%d]: = ", i);
            oldArray[i] = Integer.parseInt(scanner.nextLine());
        }
        // 2. Nhập giá trị và chỉ số phần tử chèn vào mảng
        System.out.print("Nhập vào giá trị phần tử chèn: ");
        int value = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào chỉ số phần tử chèn: ");
        int index = Integer.parseInt(scanner.nextLine());

        //3. Thực hiện chèn phần tử vào mảng
        int [] newArray;
        if(index < 0){
            System.out.println("Chỉ số phần tử chèn không hợp lệ!");
            newArray = new int[oldArray.length];
            for(int i = 0; i < oldArray.length; i++){
                newArray[i] = oldArray[i];
            }
        }else if(index < oldArray.length){
            //B1: Khai báo mảng mới có số phần tử = số phần tử mảng cũ + 1
            newArray = new int[oldArray.length + 1];
            //B2: Copy các phần tử từ old --> new và chèn phần tử vào mảng
            for(int i = 0;i < newArray.length;i++){
                if(i < index){
                    newArray[i] = oldArray[i];
                } else if (i == index) {
                    newArray[i] = value;
                } else {
                    newArray[i] = oldArray[i - 1];
                }
            }
        }else{
            newArray = new int[index + 1];
            for(int i = 0; i < oldArray.length; i++){
                newArray[i] = oldArray[i];
            }

            // Gán giá trị phần tử index với giá trị value
            newArray[index] = value;
        }

        //3. In ra mảng sau khi chèn
        System.out.println("Mảng sau khi chèn: ");
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
        System.out.println();

        //CẬP NHẬT PHẦN TỬ
        System.out.print("Nhập chỉ số phần tử muốn cập nhật: ");
        int updateIndex = Integer.parseInt(scanner.nextLine());
        if(updateIndex >= 0 && updateIndex < newArray.length){
            System.out.print("Nhập giá trị mới: ");
            int updateValue = Integer.parseInt(scanner.nextLine());
            newArray[updateIndex] = updateValue;
            System.out.println("Mảng sau khi cập nhật: ");
            for(int i = 0; i < newArray.length; i++){
                System.out.print(newArray[i] + " ");
            }
            System.out.println();
        }else{
            System.out.println("Chỉ số không hợp lệ, không thể cập nhật!");
        }

        //XÓA PHẦN TỬ
        System.out.print("Nhập chỉ số phần tử muốn xóa: ");
        int deleteIndex = Integer.parseInt(scanner.nextLine());
        int[] finalArray;
        if(deleteIndex >= 0 && deleteIndex < newArray.length){
            finalArray = new int[newArray.length - 1];
            for(int i = 0, j = 0; i < newArray.length; i++){
                if(i != deleteIndex){
                    finalArray[j] = newArray[i];
                    j++;
                }
            }
            System.out.println("Mảng sau khi xóa: ");
            for(int i = 0; i < finalArray.length; i++){
                System.out.print(finalArray[i] + " ");
            }
            System.out.println();
        }else{
            System.out.println("Chỉ số không hợp lệ, không thể xóa!");
        }
    }
}
