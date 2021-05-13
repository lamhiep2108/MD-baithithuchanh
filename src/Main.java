import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBookManagement phoneBookManagement=new PhoneBookManagement();
        Menus menus=new Menus();
        Scanner scanner=new Scanner(System.in);
        do {
            menus.menus();
            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    phoneBookManagement.showAll();
                    break;
                case "2":
                    add(phoneBookManagement, menus);
                    break;
                case "3":
                    update(phoneBookManagement, scanner);
                    break;
                case "4":
                    delete(phoneBookManagement, scanner);
                    break;
                case "5":
                    search(phoneBookManagement, scanner);
                    break;
                case "6":
                    System.out.println(phoneBookManagement.readDateFromFile("phoneBook.txt"));
                    break;
                case "7":
                    phoneBookManagement.writeToFile("phoneBook.txt");
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.err.println("không có lựa chọn trên!!!");
                    System.err.println("Mời bạn nhập lại!!");
                    break;
            }
        }while (true);
    }

    private static void add(PhoneBookManagement phoneBookManagement, Menus menus) {
        PhoneBook phoneBook= menus.getPhoneBook();
        phoneBookManagement.add(phoneBook);
    }

    private static void search(PhoneBookManagement phoneBookManagement, Scanner scanner) {
        System.out.println("Nhập số điện thoại bạn muốn tìm: ");
        String phoneBook3= scanner.nextLine();
        phoneBookManagement.search(phoneBook3);
    }

    private static void delete(PhoneBookManagement phoneBookManagement, Scanner scanner) {
        System.out.println("Nhập số điện thoại bạn muốn xóa: ");
        String phoneNumber= scanner.nextLine();
        phoneBookManagement.delete(phoneNumber);
    }

    private static void update(PhoneBookManagement phoneBookManagement, Scanner scanner) {
        System.out.println("Nhập số điện thoại bạn muốn sửa: ");
        String phoneBook1= scanner.nextLine();
        phoneBookManagement.update(phoneBook1);
    }
}
