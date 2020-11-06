package com.company;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;


public class Client {
    private long idClient;
    private String name;
    private Date birthDay;
    private Address address;
    private Documents documents;
    private Contacts contacts;
    private List<Account> accounts;

    Client(long idClient, String name, Date birthDay, char typeDocument, String numberDocument, String email, String phoneNumber) {
        this.idClient = idClient;
        this.name = name;
        this.birthDay = birthDay;
        this.documents = new Documents(typeDocument, numberDocument);
        this.contacts = new Contacts();
        this.accounts = new LinkedList<Account>();
    }

    public long getIdClient() {
        return this.idClient;
    }

    public void addAddress(String street, String postalCode, String city, String country) {
        this.address = new Address(street, postalCode, city, country);
    }

    public Address getAddress() {
        return this.address;
    }

    public Documents getDocuments() {
        return this.documents;
    }

    public void addContacts(String email, int number) {
        this.contacts.setEmail(email);
        this.contacts.setPhoneNumber(number);
    }

    public void addContacts(String email) {
        this.contacts.setEmail(email);
    }

    public void addContacts(int number) {
        this.contacts.setPhoneNumber(number);
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

}
