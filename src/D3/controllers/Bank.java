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
    public void imprimir_clientes(){
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getDocuments().getNumberDocument());
            System.out.println(clients.size());
                System.out.println(clients.get(i).toString());
        }
    }
}
