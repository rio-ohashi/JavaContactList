public class Controller {
    private ContactList contacts;

    public void start() {
        contacts = new ContactList();
        int usernameInput = Menu.INIT.getIndex();

        while (usernameInput != Menu.QUIT.getIndex()) {
            displayDefault();
            usernameInput = InputCollector.getUserInputNumber("Enter your option");

            if (!Validator.isMenuOptionNumber(usernameInput)) continue;

            switch (Menu.getMenu(usernameInput)) {
                case LIST:
                    list();
                    break;
                case NEW:
                    createContact();
                    break;
                case REMOVE:
                    removeContact();
                    break;
                case UPDATE:
                    updateContact();
                    break;
                case QUIT:
                    quitContact();
                    break;
            }
        }
    }

    private void list() {
        if (!Validator.isExistContactData(contacts.getContacts())) return;

        contacts.displayContactsList();
    }

    private void createContact() {
        String name = InputCollector.getUserInput("Enter your full name");
        int mobile = InputCollector.getUserInputNumber("Enter your mobile number");

        if (Validator.isDuplicateContactData(contacts.getContacts(), name, mobile)) return;
        contacts.addContact(name, mobile);
    }

    private void removeContact() {
        if (!Validator.isExistContactData(contacts.getContacts())) return;

        contacts.displayContactsList();

        int id = InputCollector.getUserInputNumber("Enter id that you want to remove contact");

        if (!Validator.isExistContactById(contacts.getContacts(), id)) return;

        Contact targetContact = contacts.getContactById(id);
        contacts.removeContact(targetContact);
    }

    private void updateContact() {
        if (!Validator.isExistContactData(contacts.getContacts())) return;

        contacts.displayContactsList();

        int id = InputCollector.getUserInputNumber("Enter id that you want to remove contact");

        if (!Validator.isExistContactById(contacts.getContacts(), id)) return;

        String name = InputCollector.getUserInput("Enter your full name");
        int mobile = InputCollector.getUserInputNumber("Enter your mobile number");

        if (Validator.isDuplicateContactData(contacts.getContacts(), name, mobile)) return;

        contacts.updateContact(id, name, mobile);
    }

    private void quitContact() {
        System.out.println("Bye!");
    }

    public void displayDefault(){
        final String menu =
                "+======Contact App=====+\n" +
                        "| 1. List all Contacts | \n" +
                        "| 2. Add new Contact   | \n" +
                        "| 3. Remove Contact    | \n" +
                        "| 4. Update Contact    | \n" +
                        "| 5. Quit              | \n" +
                        "+======================+";

        System.out.println(menu);
    }
}
