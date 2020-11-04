package com.company;

import java.util.Date;
import java.util.List;


public class Client {
    private long idClient;
    private String name;
    private Date birthDay;
    private Address address;
    private Documents documents;
    private Contacts contacts;
    private List<Account> accounts;

    Client(long idClient, String name, Date birthDay) {
        this.idClient = idClient;
        this.name = name;
        this.birthDay = birthDay;
        this.documents = new Documents();
        this.contacts = new Contacts();
    }

    public long getIdClient() {
        return this.idClient;
    }

    public void addAddres(String street, String postalCode, String city, String country) {
        this.address = new Address(street, postalCode, city, country);
    }

    public Address getAddress() {
        return this.address;
    }

    public void addDocuments(char typeDocument, String numberDocument) {
        this.documents.setTypeDocument(typeDocument);
        this.documents.setNumberDocument(numberDocument);
    }

    public Documents getDocuments() {
        return this.documents;
    }

    public void addContacts(String email, int number) {
        this.contacts.setEmail(email);
        this.contacts.setNumber(number);
    }

    public void addContacts(String email) {
        this.contacts.setEmail(email);
    }

    public void addContacts(int number) {
        this.contacts.setNumber(number);
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
