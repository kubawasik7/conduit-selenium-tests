package data;

public class TestUser {
    private String username;
    private String email;
    private String password;

    public TestUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public TestUser(String username, String email, String password) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {return username;}
}
