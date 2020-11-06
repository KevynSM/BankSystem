package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {

    @Test
    void Email() {
        Contacts contacts = new Contacts(null,0);
        assertEquals(contacts.getEmail(), null);
        contacts.setEmail("person@someplace.com");
        assertEquals(contacts.getEmail(), "person@someplace.com");
    }

    @Test
    void PhoneNumber() {
        Contacts contacts = new Contacts(null, 0);
        assertEquals(contacts.getPhoneNumber(), 0);
        contacts.setPhoneNumber(111111111);
        assertEquals(contacts.getPhoneNumber(), 111111111);
    }
}