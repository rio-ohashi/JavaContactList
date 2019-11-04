import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContactList {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ArrayList<Integer> ids = new ArrayList<>();

    public void addContact(String name, int mobile) {
        int id = this.contacts.size() == 0 ? 0 : Collections.max(ids)+1;
        Contact contact = new Contact(id, name, mobile);
        this.contacts.add(contact);
        this.ids.add(id);
        System.out.println("Successfully added a new contact");
    }

    public Contact getContactById(int id) {
        return this.contacts.stream().filter(c->c.getId() == id).findFirst().get();
    }

    public void removeContact(Contact contact) {
        System.out.println(String.format("%d: <%s> (mobile=%s)",contact.getId(), contact.getName(), contact.getMobile()));

        String name = contact.getName();
        int index = this.contacts.indexOf(contact);
        this.contacts.remove(index);
        this.ids.remove(index);
        System.out.println(String.format("Successfully removed %s", name));
    }

    public void updateContact(Contact contact) {
        String name = contact.getName();
        int index = this.contacts.indexOf(contact);
        this.contacts.set(index, contact);
        System.out.println(String.format("Successfully updated %s", name));
    }

    public void displayContactsList() {
        for (Contact contact : this.contacts) {
            System.out.println(String.format("%d: <%s> <%s>",contact.getId(), contact.getName(), contact.getMobile()));
        }
    }

    public boolean isEmpty() {
        if (this.contacts.isEmpty()) {
            System.out.println("No any contacts");
            return true;
        }
        return false;
    }
    public boolean isExistContactById(int id) {
        if (this.contacts.stream().filter(c -> c.getId() == id).count() > 0) {
            int max = 0;
            int min = 0;
            for (Contact c : this.contacts) {
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
