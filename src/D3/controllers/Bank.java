package D3.controllers;

import D3.models.Tax;
import D3.models.Account;
import D3.models.Client;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    Tax tax = new Tax();
    List<Account> accounts = new LinkedList<Account>();
    List<Client> clients = new LinkedList<Client>();

    public void add_client(String name, Date birthDay, char typeDocument, String numberDocument, String email, int phoneNumber, String street, String postalCode, String city, String country){
        long idClient = clients.size() + 1;
        Client a = new Client(idClient, name, birthDay, typeDocument, numberDocument, email, phoneNumber);
        a.addAddress(street, postalCode, city, country);
        clients.add(a);

    }

    public boolean document_existent(String numberDocument){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                return true;
            }
        }
        return false;
    }

    public String data_client(String numberDocument){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                return clients.get(i).toString();
            }
        }
        return "";
    }

    public void alter_client_name(String numberDocument,String name){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).setName(name);
            }
        }
    }
    public void alter_client_birthDay(String numberDocument,Date birthDay){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).setBirthDay(birthDay);
            }
        }
    }
    public void alter_client_email(String numberDocument,String email){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addContacts(email);
            }
        }
    }
    public void alter_client_phoneNumber(String numberDocument,int phoneNumber){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addContacts(phoneNumber);
            }
        }
    }
    public void alter_client_address(String numberDocument, String street, String postalCode, String city, String country){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                clients.get(i).addAddress(street, postalCode, city, country);
            }
        }
    }
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

    public Boolean account_existent(long accId){
        for(int i=0;i<accounts.size();i++){
            if (accounts.get(i).getAccId() == accId){
                return true;
            }
        }
        return false;
    }
    public double balance_account(long accId){
        for(int i=0;i<accounts.size();i++){
            if (accounts.get(i).getAccId() == accId){
                return accounts.get(i).getAccBalance();
            }
        }
        return 0;
    }
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
    public Boolean debit_account(long accId, double value){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccId() == accId){
                return accounts.get(i).debit(value);
            }
        }
        return false;
    }
    public void credit_account(long accId, double value){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccId() == accId){
                accounts.get(i).credit(value);
            }
        }
    }
    public void imprimir_clientes(){
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getDocuments().getNumberDocument());
            System.out.println(clients.size());
                System.out.println(clients.get(i).toString());
        }
    }
}
