public class Contact {

    private int id;
    private String name;
    private int mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    Contact(int id, String name, int mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }
}
