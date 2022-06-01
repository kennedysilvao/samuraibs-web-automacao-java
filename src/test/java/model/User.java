package model;

public class User {
    private String name;
    private String email;
    private String password;
    private Boolean is_provider;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIs_provider() {
        return is_provider;
    }

    public void setIs_provider(Boolean is_provider) {
        this.is_provider = is_provider;
    }

}
