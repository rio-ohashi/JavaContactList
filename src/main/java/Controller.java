public class Controller {
    private ContactList contacts;

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

    public void start() {
        contacts = new ContactList();
        String usernameInput = Menu.INIT.toString();

        while (!usernameInput.equals(String.valueOf(Menu.QUIT.getIndex()))) {
            displayDefault();
            usernameInput = InputCollector.getUserInput("Enter your option");

            if (!Menu.isIn(Integer.parseInt(usernameInput))) {
                System.out.println("Invalid Input. Enter number between 1 and 5!!");
                continue;
            }

            switch (Menu.getMenu(Integer.valueOf(usernameInput))) {
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
        if (contacts.isEmpty()) return;

        contacts.displayContactsList();
    }

    private void createContact() {
        String name = InputCollector.getUserInput("Enter your full name");
        int mobile = Integer.parseInt(InputCollector.getUserInput("Enter your mobile number"));
        contacts.addContact(name, mobile);
    }

    private void removeContact() {
        if (contacts.isEmpty()) return;

        contacts.displayContactsList();

        int id = Integer.parseInt(InputCollector.getUserInput("Enter id that you want to remove contact"));

        if (!contacts.isExistContactById(id)) return;

        Contact targetContact = contacts.getContactById(id);
        contacts.removeContact(targetContact);
    }

    private void updateContact() {
        if (contacts.isEmpty()) return;

        contacts.displayContactsList();

        int id = Integer.parseInt(InputCollector.getUserInput("Enter id that you want to change contact"));

        if (!contacts.isExistContactById(id)) return;

        Contact targetContact = contacts.getContactById(id);

        String name = InputCollector.getUserInput("Enter your full name");
        int mobile = Integer.parseInt(InputCollector.getUserInput("Enter your mobile number"));
        targetContact.setName(name);
        targetContact.setMobile(mobile);

        contacts.updateContact(targetContact);
    }

    private void quitContact() {
        System.out.println("Bye!");
    }
}
