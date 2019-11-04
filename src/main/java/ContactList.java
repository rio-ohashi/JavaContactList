import java.util.ArrayList;
import java.util.Collections;

public class ContactList {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ArrayList<Integer> ids = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(String name, int mobile) {
        int id = this.contacts.size() == 0 ? 0 : Collections.max(ids)+1;
        Contact contact = new Contact(id, name, mobile);
        try{
            this.contacts.add(contact);
            this.ids.add(id);
        } catch (Exception e) {
            System.out.println(String.format(e.toString()));
        }
        System.out.println("Successfully added a new contact");
    }

    public Contact getContactById(int id) {
        return this.contacts.stream().filter(c->c.getId() == id).findFirst().get();
    }

    public void removeContact(Contact contact) {
        System.out.println(String.format("%d: <%s> (mobile=%s)",contact.getId(), contact.getName(), contact.getMobile()));

        String name = contact.getName();
        try {
            this.contacts.remove(contact);
            this.ids.remove(Integer.valueOf(contact.getId()));
        } catch (Exception e) {
            System.out.println(String.format(e.toString()));
        }
        System.out.println(String.format("Successfully removed %s", name));
    }

    public void updateContact(int id, String name, int mobile) {
        Contact contact = getContactById(id);
        int updateIndex = this.contacts.indexOf(contact);
        contact.setName(name);
        contact.setMobile(mobile);
        try {
            this.contacts.set(updateIndex, contact);
        } catch (Exception e) {
            System.out.println(String.format(e.toString()));
        }
        System.out.println(String.format("Successfully updated %s", name));
    }

    public void displayContactsList() {
        for (Contact contact : this.contacts) {
            System.out.println(String.format("%d: <%s> (mobile=%s)",contact.getId(), contact.getName(), contact.getMobile()));
        }
    }
}
