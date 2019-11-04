public enum Menu {
    INIT(0),
    LIST(1),
    NEW(2),
    REMOVE(3),
    UPDATE(4),
    QUIT(5);

    private int num;

    Menu(int num) {
        this.num = num;
    }

    public int getIndex() {
        return this.num;
    }

    public static boolean isIn(int index) {
        for (Menu menu: values()) {
            if (menu.getIndex() == index)
                return true;
        }
        return false;
    }

    public static Menu getMenu(int index) {
        switch (index) {
            case 0:
                return INIT;
            case 1:
                return LIST;
            case 2:
                return NEW;
            case 3:
                return REMOVE;
            case 4:
                return UPDATE;
            default:
                return QUIT;
        }
    }
}
