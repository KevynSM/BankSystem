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

    public void add_client(String name, Date birthDay, char typeDocument, String numberDocument, String email, int phoneNumber){
        long idClient = clients.size() + 1;
        clients.add(new Client(idClient, name, birthDay, typeDocument, numberDocument, email, phoneNumber));
    }

    public boolean document_existent(String numberDocument){
        for(int i=0;i<clients.size();i++){
            if (clients.get(i).getDocuments().getNumberDocument() == numberDocument){
                return true;
            }
        }
        return false;
    }

}
