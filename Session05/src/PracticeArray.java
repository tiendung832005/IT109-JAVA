import java.util.Scanner;

public class PracticeArray {
    public static void main(String[] args) {
        /*
        * 1. Nhập số phần tử của mảng và khai báo số nguyên 1 chieeuf gồm n phân tử, nhập giá trị các phần tử
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
            //B1: Khai báo mảng mơ có số phần tử = so phần tử mảng cũ + 1
             newArray = new int[oldArray.length + 1];
            //B2: Coppy các phần tử từ old --> new và chenf phần tử vào mảng
            for(int i = 0;i < newArray.length;i++){
                if(i<index){
                    newArray[i] = oldArray[i];
                } else if (i==index) {
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

            // Gán giá trị phần tử index vs giá trị value
            newArray[index] = value;
        }

        //3. In ra mảng sau khi chèn
        System.out.println("Mảng sau khi chèn: ");
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }

    }
}
