package D3.models;


/** Represents a Contact of a Client in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Contacts {
    private String email;
    private int phoneNumber;

    /** Create a contact object with the given parameters.
     *
     * @param email The email contact.
     * @param phoneNumber The phone number contact.
     */
    Contacts(String email, int phoneNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /** Sets the email contact with the new given email
     *
     * @param email The new email.
     */
    public void setEmail (String email) {
        this.email = email;
    }

    /** Returns the email contact.
     *
     * @return the email contact.
     */
    public String getEmail () {
        return this.email;
    }

    /** Sets the phone number contact with the given phone number.
     *
     * @param phoneNumber the new phone number.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /** Returns the phone number contact.
     *
     * @return the phone number contact.
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
}
