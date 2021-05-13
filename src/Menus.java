import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menus {
    Scanner scanner = new Scanner(System.in);

    public void menus() {
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
    }

    public PhoneBook getPhoneBook() {
        String phoneNumber= phoneNumber();
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        String email =   email();
        System.out.println("nhập facebook");
        String facebook = scanner.nextLine();
        return new PhoneBook(phoneNumber, group, name, gender, address, dateOfBirth, email, facebook);
    }

    private String email() {
        while (true) {
            System.out.println("Nhập email : ");
            System.out.println("Email không có kí tự đặc biệt, không viết hoa");
            String email = scanner.nextLine();

            String regex = "^\\w+[a-z0-9]*@[a-z]+(\\.\\w+)$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(email);


            if (matcher.find()) {
                return email;
            } else {
                System.out.println("Email không có kí tự đặc biệt, không viết hoa");
                // Khong viet duoc ki kieu @ :(((
            }
        }
    }

    private String phoneNumber() {
        while (true) {
            System.out.println("Nhập số điện thoại : ");
            System.out.println("Số điện thoại không được chứa kí tự đặc biệt, chỉ có 10-11 chữ số !!!");
            String phoneNumber = scanner.nextLine();

            String regex = "\\d{10,11}";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(phoneNumber);


            if (matcher.find()) {
                return phoneNumber;
            } else {
                System.out.println("Số điện thoại không được chứa kí tự đặc biệt, chỉ có 10-11 chữ số !!! ");
            }

        }
    }
}
