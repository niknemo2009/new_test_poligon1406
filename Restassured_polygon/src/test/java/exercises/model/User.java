package exercises.model;

public class User {
    private String firstName = "";
    private String lastName = "";
    private String userName;
    private String password;
    private boolean active;
    private String id = "";

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
