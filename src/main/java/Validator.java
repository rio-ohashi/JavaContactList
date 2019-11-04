import java.util.ArrayList;

public class Validator {
    public static boolean isNotNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(NumberFormatException e){
            System.out.println("Enter number");
            return true;
        }
    }

    public static boolean isEmptyString(String str) {
        if (str.isEmpty()) {
            System.out.println("You must enter this filed");
            return true;
        }
        return false;
    }

    public static boolean isMenuOptionNumber(int num) {
        if (Menu.isIn(num)) {
            return true;
        }
        System.out.println("Invalid Input. Enter number between 1 and 5!!");
        return false;
    }

    public static boolean isDuplicateContactData(ArrayList<Contact> existContacts, String newName, int newMobile) {
        for (Contact existContact : existContacts) {
            if (existContact.getName().equals(newName) &&
            existContact.getMobile() == newMobile) {
                System.out.println("This user is exist");
                return true;
            }
        }
        return false;
    }

    public static boolean isExistContactData(ArrayList<Contact> contacts) {
        if (!contacts.isEmpty()) {
            return true;
        }
        System.out.println("No any contacts");
        return false;
    }

    public static boolean isExistContactById(ArrayList<Contact> contacts, int id) {
        if (contacts.stream().filter(c -> c.getId() == id).count() > 0) {
            int max = 0;
            int min = 0;
            for (Contact c : contacts) {
                max = c.getId();
                min = c.getId();
                if (c.getId() > max) {
                    max = c.getId();
                }
                if (c.getId() < min) {
                    min = c.getId();
                }
            }
            System.out.println("Enter correct Id");
            System.out.println(String.format("Invalid Input. Enter number between %d and %d!!",
                    min , max));
            return true;
        }
        return false;
    }
}
