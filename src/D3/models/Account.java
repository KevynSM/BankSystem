package D3.models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


/** Represents an Account in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Account {
    private long accId;
    private Client mainClient;
    private List<Client> otherClients;
    private double accBalance;
    private List<AccMovement> accMovements;

    /** Create a new Account with the given parameters.
     *
     * @param accId The identification number of the Account.
     * @param mainClient The main Client of the Account.
     */
    public Account(long accId, Client mainClient) {
        this.accId = accId;
        this.mainClient = mainClient;
        this.otherClients =  new LinkedList<Client>();
        this.accMovements = new LinkedList<AccMovement>();
    }

    /** Create a new Account with the given parameters.
     *
     * @param accId The identification number of the Account.
     * @param mainClient The main Client of the Account.
     */
    public Account(long accId, Client mainClient, double firstDeposit) {
        this.accId = accId;
        this.mainClient = mainClient;
        this.accBalance = firstDeposit;
        this.otherClients =  new LinkedList<Client>();
        this.accMovements = new LinkedList<AccMovement>();
    }

    /** Returns the identification number of the Account.
     *
     * @return the identification number of the Account.
     */
    public long getAccId() { return this.accId; }

    /** Sets the Account's main Client with the given client.
     *
     * @param mainClient The new main client
     */
    public void setMainClient(Client mainClient) {
        this.mainClient = mainClient;
    }

    /** Returns the main client of the Account.
     *
     * @return the main client of the Account.
     */
    public Client getMainClient() {
        return mainClient;
    }

    /** Add an client to the associated clients list of the Account.
     *
     * @param otherClient New associated client
     */
    public void addOtherClients(Client otherClient) {
        this.otherClients.add(otherClient);
    }

    /** Remove an associated client of the Account.
     *
     * @param otherClient The associated client to be remove.
     */
    public void removeOtherClients(Client otherClient) {
        this.otherClients.remove(otherClient);
    }

    /** Returns the associated clients list of the Account.
     *
     * @return the associated clients list of the Account.
     */
    public List<Client> getOtherClients() {
        return this.otherClients;
    }

    /** Returns the movements list of the Account.
     *
     * @return the movements list of the Account.
     */
    public List<AccMovement> getAccMovements() {
        return this.accMovements;
    }

    /** Add a account movement to the account movement list of the Account.
     *
     * @param accMovement The new account movement to be add.
     */
    public void addAccMovements(AccMovement accMovement) {
        this.accMovements.add(accMovement);
    }

    /** Return the balance of the Account.
     *
     * @return the balance of the Account.
     */
    public double getAccBalance() {
        return this.accBalance;
    }

    /** The credit operation
     *
     * @param value The value to be credited to the account balance.
     */
    public void credit(double value) {
        Tax tax = new Tax();
        this.accBalance = this.accBalance + value - tax.getValue();
        this.accMovements.add(new AccMovement(actual_date(), value, tax.getValue(), 'c'));
    }

    /** The debit operation
     *
     * @param value he value to be debited to the account balance.
     */
    public void debit(double value) {
        if(this.accBalance - value >= 0){
            Tax tax = new Tax();
            this.accBalance = this.accBalance - value - tax.getValue();
            this.accMovements.add(new AccMovement(actual_date(), value, tax.getValue(), 'd'));
        }
    }

    /** Returns the actual time of an account operation.
     *
     * @return the actual time of an account operation.
     */
    private String actual_date() {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatDate.format(data);
    }

}