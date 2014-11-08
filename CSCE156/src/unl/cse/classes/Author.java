package unl.cse.classes;
/**
 *
 */
public class Author {

    private String firstName;
    private String lastName;


    /**
     * Default Constructor
     */
    public Author() {
    }

    /**
     * Constructor
     * @param firstName
     * @param lastName
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return First name of author
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the author
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return Last name of author
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param Set the last name of the author
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}