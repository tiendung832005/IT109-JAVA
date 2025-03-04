import java.util.Scanner;

public class demoDoWhile {
    public static void main(String[] args) {
        /*
        * In ra menu của căng tin sinh viên trường PTIT và thực hiện các chức năng menu
            Sau đó tính tổng tiền
        * * ************************MENU**************************
        * 1. Phở bò 35k
        * 2. Phở gà 35k
        * 3. Bún chả 30k
        * 4 Mỳ tôm 2 trứng 15k
        * 5. Bánh mỳ trứng 10k
        * 6. Cafe 25k
        * 7. Nước ngọt 10k
        * Sự lua chọn của bạn
        */
        //B1 Khởi tạo biến tổng
        float totalnumber = 0;
        //B2 In menu và thực hiện chức năng
        Scanner scanner = new Scanner (System.in);
        do{
            System.out.println("*********************MENU**************************");
            System.out.println("1. Phở bò 35k");
            System.out.println("2. Phở gà 35k");
            System.out.println("3. Bún chả 30k");
            System.out.println("4. Mỳ tôm 2 trứng 15k");
            System.out.println("5. Bánh mỳ trứng 10k");
            System.out.println("6. Cafe 25k");
            System.out.println("7. Nước ngọt 10k");
            System.out.println("0. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Bạn vừa chọn phở bò");
                    totalnumber += 35000;
                    break;
                case 2:
                    System.out.println("Bạn vừa chọn phở gà");
                    totalnumber += 35000;
                    break;
                case 3:
                    System.out.println("Bạn vừa chọn bún chả");
                    totalnumber += 30000;
                    break;
                case 4:
                    System.out.println("Bạn vừa chọn mỳ tôm 2 trứng");
                    totalnumber += 15000;
                    break;
                case 5:
                    System.out.println("Bạn vừa chọn bánh mỳ trứng");
                    totalnumber += 10000;
                    break;
                case 6:
                    System.out.println("Bạn vừa chọn cafe");
                    totalnumber += 25000;
                    break;
                case 7:
                    System.out.println("Bạn vừa chọn nươ ngọt");
                    totalnumber += 10000;
                    break;
                case 0:
                    System.out.println("Bạn đã thoát!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại sự lựa chọn.");
            }
        }while(true);
    }
}
