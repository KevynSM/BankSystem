package com.company;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getIdClient() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        assertEquals(client.getIdClient(), 10001);
    }

    @Test
    void addAddress() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        client.addAddress("street 1", "101101101", "Lisbon", "Portugal");
        assertEquals(client.getAddress().getStreet(), "street 1");
    }

    @Test
    void getDocuments() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        assertEquals(client.getDocuments().getNumberDocument(), "ABC001");
    }

    @Test
    void addContacts() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        client.addContacts("person@someplace.com", 101101101);
        assertEquals(client.getContacts().getPhoneNumber(), 101101101);
        assertEquals(client.getContacts().getEmail(), "person@someplace.com");
    }

    @Test
    void testAddContacts() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        client.addContacts("person@someplace.com");
        assertEquals(client.getContacts().getEmail(), "person@someplace.com");
    }

    @Test
    void testAddContacts1() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        client.addContacts( 101101101);
        assertEquals(client.getContacts().getPhoneNumber(), 101101101);
    }

    @Test
    void addAccount() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001");
        Account account = new Account(50001, client);
        client.addAccount(account);
        assertTrue(client.getAccounts().contains(account));
    }

}