import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement implements Function {
    List<PhoneBook>phoneBooks=new ArrayList<>();
    Menus menus=new Menus();
    @Override
    public void add(PhoneBook phoneBook) {
        phoneBooks.add(phoneBook);
    }

    @Override
    public void update(String phoneNumber) {
        for (PhoneBook phoneBook1:phoneBooks) {
            if (!phoneNumber.equals(phoneBook1.getPhoneNumber()) ){
                System.out.println("ko có sdt trên");
        }else {
                PhoneBook1 phoneBook=menus.getPhoneBook();
                phoneBook1.setPhoneNumber(phoneBook.getPhoneNumber());
                phoneBook1.setGroup(phoneBook.getGroup());
                phoneBook1.setName(phoneBook.getName());
                phoneBook1.setGender(phoneBook.getGender());
                phoneBook1.setAddress(phoneBook.getAddress());
                phoneBook1.setDateOfBirth(phoneBook.getAddress());
                phoneBook1.setEmail(phoneBook.getAddress());
                phoneBook1.setFacebook(phoneBook.getFacebook());
               break;
            }
    }}

    @Override
    public void delete(String phoneNumber) {
        for (PhoneBook phoneBook1:phoneBooks) {
            if (!phoneNumber.equals(phoneBook1.getPhoneNumber())){
                System.out.println("ko tìm thấy số bạn cần xóa!!");
            }else {
                phoneBooks.remove(phoneBook1);
            }
        }
    }

    @Override
    public void search(String phoneNumber) {
        for (PhoneBook phoneBook:phoneBooks) {
            if (!phoneNumber.equals(phoneBook.getPhoneNumber())){
                System.out.println("ko có số điện thoại trên!");
            }else {
                System.out.println(phoneBook);
            }
        }
    }

    @Override
    public void showAll() {
        for (PhoneBook phoneBook:phoneBooks) {
            System.out.println(phoneBook);
        }
    }
        public List<PhoneBook> readDateFromFile(String path) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
                phoneBooks = (List<PhoneBook>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return phoneBooks;
        }
        public void writeToFile(String path) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
                oos.writeObject(phoneBooks);
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

