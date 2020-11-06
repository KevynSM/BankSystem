package D3.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getStreet() {
        Address address = new Address("street alpha", "100101102", "Lisbon", "Portugal");
        assertEquals(address.getStreet(), "street alpha");
    }

    @Test
    void getPostalCode() {
        Address address = new Address("street alpha", "100101102", "Lisbon", "Portugal");
        assertEquals(address.getPostalCode(), "100101102");
    }

    @Test
    void getCity() {
        Address address = new Address("street alpha", "100101102", "Lisbon", "Portugal");
        assertEquals(address.getCity(), "Lisbon");
    }

    @Test
    void getCountry() {
        Address address = new Address("street alpha", "100101102", "Lisbon", "Portugal");
        assertEquals(address.getCountry(), "Portugal");
    }
}