import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement implements Function {
    List<PhoneBook> phoneBooks = new ArrayList<>();
    Menus menus = new Menus();

    @Override
    public void add(PhoneBook phoneBook) {
        phoneBooks.add(phoneBook);
    }

    @Override
    public void update(String phoneNumber) {
        for (PhoneBook phoneBook1 : phoneBooks) {
            if (phoneNumber.equals(phoneBook1.getPhoneNumber())) {
                PhoneBook phoneBook = menus.getPhoneBook();
                phoneBook1.setPhoneNumber(phoneBook.getPhoneNumber());
                phoneBook1.setGroup(phoneBook.getGroup());
                phoneBook1.setName(phoneBook.getName());
                phoneBook1.setGender(phoneBook.getGender());
                phoneBook1.setAddress(phoneBook.getAddress());
                phoneBook1.setDateOfBirth(phoneBook.getAddress());
                phoneBook1.setEmail(phoneBook.getEmail());
                phoneBook1.setFacebook(phoneBook.getFacebook());
                break;
            }
        }
        System.out.println("không có số điện thoại trên!!");
    }

    @Override
    public void delete(String phoneNumber) {
        phoneBooks.removeIf(phoneBook1 -> phoneNumber.equals(phoneBook1.getPhoneNumber()));
    }


    @Override
    public void search(String phoneNumber) {
        for (PhoneBook phoneBook : phoneBooks) {
            if (phoneNumber.equals(phoneBook.getPhoneNumber())) {
                System.out.println(phoneBook);
            }

        }
    }

    @Override
    public void showAll() {
        for (PhoneBook phoneBook : phoneBooks) {
            System.out.println(phoneBook);
        }
    }

    public void save() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("FILE_NAME");
            fileWriter.append("Tên,Số điện thoại, Địa chỉ,Email,Facebook");
            fileWriter.write("\n");
            for (PhoneBook phoneBook : phoneBooks) {
                fileWriter.append(phoneBook.getName());
                fileWriter.append(",");
                fileWriter.append(phoneBook.getPhoneNumber());
                fileWriter.append(",");
                fileWriter.append(phoneBook.getAddress());
                fileWriter.append(",");
                fileWriter.append(phoneBook.getEmail());
                fileWriter.append(",");
                fileWriter.append(phoneBook.getFacebook());
                fileWriter.append(",");
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void read() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("FILE_NAME"));
            while ((line = br.readLine()) != null && line.isEmpty()) {
                String fields[] = line.split(",");
                for (int i = 0; i < phoneBooks.size(); i++) {
                    System.out.println("Tên : " + fields[0] + "Số điện thoại : " + fields[1] + " Địa chỉ: " + fields[2] + " Email: " +
                            fields[3] + " Facebook : " + fields[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

