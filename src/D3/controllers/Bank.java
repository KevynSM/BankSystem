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
        //criar conta
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocumentMain)){
                if (value != 0) {
                    accounts.add(new Account(posAccount + 1, clients.get(i), value));
                }else{
                    accounts.add(new Account(posAccount + 1, clients.get(i)));
                }
            }
        }
        //adicionar outros clientes há conta
        for(int i=0; i<numberDocumentOthers.size();i++){
            for(int j=0;j<clients.size();j++){
                if (clients.get(j).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocumentOthers.get(i))){
                    accounts.get(posAccount).addOtherClients(clients.get(j));
                }
            }
        }
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
        for(int i=0;i<accounts.size();i++){
            //verificar o cliente principal da conta
            if(accounts.get(i).getMainClient().getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                idAccounts.add(accounts.get(i).getAccId());
            }
            //verificar os outros clientes da conta
            for(int j=0; j<accounts.get(j).getOtherClients().size(); j++){
                if(accounts.get(j).getOtherClients().get(j).getDocuments().getNumberDocument().equalsIgnoreCase(numberDocument)){
                    idAccounts.add(accounts.get(i).getAccId());
                }
            }
        }
        return idAccounts;
    }
    public void imprimir_clientes(){
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getDocuments().getNumberDocument());
            System.out.println(clients.size());
                System.out.println(clients.get(i).toString());
        }
    }
}
