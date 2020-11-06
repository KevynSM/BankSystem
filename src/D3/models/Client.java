package D3.models;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/** Represents a Client in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Client {
    private long idClient;
    private String name;
    private Date birthDay;
    private Address address;
    private Documents documents;
    private Contacts contacts;
    private List<Account> accounts;

    /** Create a new Client with the given parameters.
     *
     * @param idClient The identification number of the Client.
     * @param name The name of the Client.
     * @param birthDay The birthDay date of the Clint.
     * @param typeDocument The letter that represent the type of the document chosen by the Client
     * @param numberDocument The number of the document chosen by the Client
     * @param email The email of the Client
     * @param phoneNumber The phone number of the Client
     */
    public Client(long idClient, String name, Date birthDay, char typeDocument, String numberDocument, String email, int phoneNumber) {
        this.idClient = idClient;
        this.name = name;
        this.birthDay = birthDay;
        this.documents = new Documents(typeDocument, numberDocument);
        this.contacts = new Contacts(email, phoneNumber);
        this.accounts = new LinkedList<Account>();
    }


    /** Returns the identification number of the Client.
     *
     * @return the identification number of the Client.
     */
    public long getIdClient() {
        return this.idClient;
    }

    /** Add a new Address object created with the given parameters
     *
     * @param street The street of the Client's address
     * @param postalCode The postal code of the Client's address
     * @param city The city of the Client's address
     * @param country The country of the Client's address
     */
    public void addAddress(String street, String postalCode, String city, String country) {
        this.address = new Address(street, postalCode, city, country);
    }

    /** Returns the address object of the Client.
     *
     * @return the address object of the client.
     */
    public Address getAddress() {
        return this.address;
    }

    /** Returns the document object of the Client.
     *
     * @return the document object of the Client.
     */
    public Documents getDocuments() {
        return this.documents;
    }

    /** Add the given contacts to the contacts object of the Client.
     *
     * @param email The Email of the Client
     * @param number The phone number of the Client
     */
    public void addContacts(String email, int number) {
        this.contacts.setEmail(email);
        this.contacts.setPhoneNumber(number);
    }

    /** Add the given email to the contacts object of the Client.
     *
     * @param email The Email of the Client
     */
    public void addContacts(String email) {
        this.contacts.setEmail(email);
    }

    /** Add the given phone number to the contacts object of the Client.
     *
     * @param number The phone number of the Client
     */
    public void addContacts(int number) {
        this.contacts.setPhoneNumber(number);
    }

    /** Returns the contacts object of the Client.
     *
     * @return the contacts object of the Client.
     */
    public Contacts getContacts() {
        return this.contacts;
    }

    /** Add a new account to the Client.
     *
     * @param account The new Account of the Client.
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /** Returns a list with all the Client's Accounts.
     *
     * @return
     */
    public List<Account> getAccounts() {
        return this.accounts;
    }

}
