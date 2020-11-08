package D3.controllers;

import D3.models.Tax;
import D3.models.Account;
import D3.models.Client;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/** Represents a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 *
 */
public class Bank {
    /**
     * @param tax the tax that are used in the accounts movements.
     * @param accounts A list with the accounts in the bank.
     * @param clients A list with the clients in the bank.
     *
     */
    Tax tax = new Tax();
    List<Account> accounts = new LinkedList<Account>();
    List<Client> clients = new LinkedList<Client>();

    /** Adds a client to the bank.
     *
     * @param name Name of the client.
     * @param birthDay birthday oi the client.
     * @param typeDocument type of the document
     * @param numberDocument number of the document
     * @param email email of the client
     * @param phoneNumber phone number of the client
     * @param street street of the client's address
     * @param postalCode postal code of the client's address
     * @param city city of the client's address
     * @param country country of the client's address
     */
    public void add_client(String name, Date birthDay, char typeDocument, String numberDocument, String email, int phoneNumber, String street, String postalCode, String city, String country){
        long idClient = clients.size() + 1;
        Client a = new Client(idClient, name, birthDay, typeDocument, numberDocument, email, phoneNumber);
        a.addAddress(street, postalCode, city, country);
        clients.add(a);

    }

    /** Checks if there are the given document in the bank.
     *
     * @param numberDocument Document to check.
     * @return True or False
     */
    public boolean document_existent(String numberDocument){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                return true;
            }
        }
        return false;
    }

    /** Returns a String with all the data's about a specific client.
     *
     * @param numberDocument the specific client.
     * @return a String with all the data's about a specific client.
     */
    public String data_client(String numberDocument){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                return clients.get(i).toString();
            }
        }
        return "";
    }

    /** Changes the name of a specific client.
     *
     * @param numberDocument the specific client.
     * @param name new name.
     */
    public void alter_client_name(String numberDocument,String name){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).setName(name);
            }
        }
    }

    /** Changes the birthday of a specific client.
     *
     * @param numberDocument the specific client.
     * @param birthDay the new birthday.
     */
    public void alter_client_birthDay(String numberDocument,Date birthDay){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).setBirthDay(birthDay);
            }
        }
    }

    /** Changes the email of a specific client.
     *
     * @param numberDocument the specific client.
     * @param email the new email.
     */
    public void alter_client_email(String numberDocument,String email){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addContacts(email);
            }
        }
    }

    /** Changes the phone number of a specific client.
     *
     * @param numberDocument the specific client.
     * @param phoneNumber the new phone number.
     */
    public void alter_client_phoneNumber(String numberDocument,int phoneNumber){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addContacts(phoneNumber);
            }
        }
    }

    /** Changes the address of a specific client.
     *
     * @param numberDocument the specific client.
     * @param street the new street of the client's address.
     * @param postalCode the new postal code of the client's address.
     * @param city the new city of the client's address.
     * @param country the new country of the client's address.
     */
    public void alter_client_address(String numberDocument, String street, String postalCode, String city, String country){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addAddress(street, postalCode, city, country);
            }
        }
    }

    /** Adds a new Account and returns the id of the account
     *
     * @param numberDocumentMain The document number of the main client of the account.
     * @param numberDocumentOthers A list of associated clients of the account.
     * @param value a possible first deposite.
     * @return the id of the account
     */
    public long add_account(String numberDocumentMain, List<String> numberDocumentOthers, double value){
        int posAccount = accounts.size();
        Account acc = null;
        //criar conta
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocumentMain)){
                if (value != 0) {
                    acc = new Account(posAccount + 1, clients.get(i), value);
                }else{
                    acc = new Account(posAccount + 1, clients.get(i));
                }
                clients.get(i).addAccount(acc);
            }
        }
        //adicionar outros clientes há conta
        for(int i=0; i<numberDocumentOthers.size();i++){
            for(int j=0;j<clients.size();j++){
                if (clients.get(j).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocumentOthers.get(i))){
                    acc.addOtherClients(clients.get(j));
                    clients.get(j).addAccount(acc);
                }
            }
        }
        accounts.add(acc);
        return posAccount + 1;

    }

    /** Checks if a specific account exist.
     *
     * @param accId the specific account.
     * @return true or false.
     */
    public Boolean account_existent(long accId){
        for(int i=0;i<accounts.size();i++){
            if (accounts.get(i).getAccId() == accId){
                return true;
            }
        }
        return false;
    }

    /** Returns the balance of the specific account.
     *
     * @param accId the specific account.
     * @return the balance of the specific account. 0 if the specific account doesn't exist.
     */
    public double balance_account(long accId){
        for(int i=0;i<accounts.size();i++){
            if (accounts.get(i).getAccId() == accId){
                return accounts.get(i).getAccBalance();
            }
        }
        return 0;
    }

    /** Returns a list with all the account of a specific client.
     *
     * @param numberDocument the specific client.
     * @return a list with all the account of a specific client.
     */
    public List<Long> idAccounts_Client(String numberDocument){
        List<Long> idAccounts = new LinkedList<Long>();
        for(int i=0; i<clients.size();i++){
            if(clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                for(int j=0; j<clients.get(i).getAccounts().size(); j++){
                    idAccounts.add( clients.get(i).getAccounts().get(j).getAccId() );
                }
            }
        }
        return idAccounts;
    }

    /** Make a debit movement at a specific account.
     *
     * @param accId the specific account.
     * @param value the value to be debited.
     * @return true if it was possible, false if it was not.
     */
    public Boolean debit_account(long accId, double value){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccId() == accId){
                return accounts.get(i).debit(value);
            }
        }
        return false;
    }

    /** Make a credit movement at a specific account.
     *
     * @param accId the specific account.
     * @param value the value to be debited.
     */
    public void credit_account(long accId, double value){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccId() == accId){
                accounts.get(i).credit(value);
            }
        }
    }

}
