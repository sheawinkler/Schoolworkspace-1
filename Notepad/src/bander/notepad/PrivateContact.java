package bander.notepad;

/**
 * Created by oscar on 12/8/14.
 */
public class PrivateContact {
    private String owner;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public PrivateContact(String owner, String name, String phoneNumber, String email, String address) {
        this.owner = owner;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
