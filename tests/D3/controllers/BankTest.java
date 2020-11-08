package D3.controllers;

import D3.models.Account;
import D3.models.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bk;
    @BeforeEach
    void setUp() throws Exception {
        this.bk = new Bank();
    }


    @Test
    void add_client(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getIdClient(), 1);
        assertEquals(bk.clients.get(0).getName(), name);
        assertEquals(bk.clients.get(0).getBirthDay(), birthDay);
        assertEquals(bk.clients.get(0).getDocuments().getTypeDocument(), typeDocument);
        assertEquals(bk.clients.get(0).getDocuments().getNumberDocument(), numberDocument);
        assertEquals(bk.clients.get(0).getContacts().getEmail(), email);
        assertEquals(bk.clients.get(0).getContacts().getPhoneNumber(), phoneNumber);
        assertEquals(bk.clients.get(0).getAddress().getStreet(), street);
        assertEquals(bk.clients.get(0).getAddress().getPostalCode(), postalCode);
        assertEquals(bk.clients.get(0).getAddress().getCity(), city);
        assertEquals(bk.clients.get(0).getAddress().getCountry(), country);


    }

    @Test
    void document_existent(){
        assertFalse(bk.document_existent("1"));
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertTrue(bk.document_existent(numberDocument));
        String numberDocument2 = "1235";
        bk.add_client(name, birthDay, typeDocument, numberDocument2, email, phoneNumber, street, postalCode, city, country);
        assertFalse(bk.document_existent("5648641654"));
        assertTrue(bk.document_existent(numberDocument2));
    }
    @Test
    void data_client() {
        String numberDocument = "12345";
        assertEquals(bk.data_client(numberDocument), "");
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.data_client(numberDocument),bk.clients.get(0).toString());

        String numberDocument2 = "2345";
        String email2 = "nocas@gmail.com";
        int phoneNumber2 = 91234233;
        String street2 = "Rua das Pontes";
        bk.add_client(name, birthDay, typeDocument, numberDocument2, email2, phoneNumber2, street2, postalCode, city, country);
        assertEquals(bk.data_client(numberDocument2),bk.clients.get(1).toString());
    }

    @Test
    void alter_client_name(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getName(),name);
        bk.alter_client_name(numberDocument,"Filipe");
        assertNotEquals(bk.clients.get(0).getName(),name);
        assertEquals(bk.clients.get(0).getName(),"Filipe");
    }
    @Test
    void alter_client_birthDay(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getBirthDay(),birthDay);
        bk.alter_client_birthDay(numberDocument,new Date(2000,10,05));
        assertNotEquals(bk.clients.get(0).getBirthDay(),birthDay);
        assertEquals(bk.clients.get(0).getBirthDay(),new Date(2000,10,05));
    }
    @Test
    void alter_client_email(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getContacts().getEmail(), email);
        bk.alter_client_email(numberDocument,"rui12hj@gmail.com");
        assertNotEquals(bk.clients.get(0).getContacts().getEmail(), email);
        assertEquals(bk.clients.get(0).getContacts().getEmail(), "rui12hj@gmail.com");
    }
    @Test
    void alter_client_phoneNumber(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getContacts().getPhoneNumber(), phoneNumber);
        bk.alter_client_phoneNumber(numberDocument,987654321);
        assertNotEquals(bk.clients.get(0).getContacts().getPhoneNumber(), phoneNumber);
        assertEquals(bk.clients.get(0).getContacts().getPhoneNumber(), 987654321);
    }
    @Test
    void alter_client_address(){
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        assertEquals(bk.clients.get(0).getAddress().getStreet(), street);
        assertEquals(bk.clients.get(0).getAddress().getPostalCode(), postalCode);
        assertEquals(bk.clients.get(0).getAddress().getCity(), city);
        assertEquals(bk.clients.get(0).getAddress().getCountry(), country);

        bk.alter_client_address(numberDocument,"Rua das Pedreiras", "2011-456", "Porto", "France");
        assertNotEquals(bk.clients.get(0).getAddress().getStreet(), street);
        assertNotEquals(bk.clients.get(0).getAddress().getPostalCode(), postalCode);
        assertNotEquals(bk.clients.get(0).getAddress().getCity(), city);
        assertNotEquals(bk.clients.get(0).getAddress().getCountry(), country);

        assertEquals(bk.clients.get(0).getAddress().getStreet(), "Rua das Pedreiras");
        assertEquals(bk.clients.get(0).getAddress().getPostalCode(), "2011-456");
        assertEquals(bk.clients.get(0).getAddress().getCity(), "Porto");
        assertEquals(bk.clients.get(0).getAddress().getCountry(), "France");
    }

    @Test
    void accountTest() {
        // Main Client
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);

        //Other Client
        String name2 = "Rui";
        Date birthDay2 = new Date(1980,01,01);
        char typeDocument2 = 'C';
        String numberDocument2 = "87654321";
        String email2 = "rui@gmail.com";
        int phoneNumber2 = 912345678;
        String street2 = "Rua de Mil Fontes";
        String postalCode2 = "2635-123";
        String city2 = "Lisboa";
        String country2 = "Portugal";
        bk.add_client(name2, birthDay2, typeDocument2, numberDocument2, email2, phoneNumber2, street2, postalCode2, city2, country2);


        List<String> numberDocumentOthers = new LinkedList<String>();
        numberDocumentOthers.add(numberDocument2);

        assertEquals(bk.add_account(numberDocument, numberDocumentOthers, 1000.00), bk.accounts.size());

        assertTrue(bk.account_existent(bk.clients.get(0).getAccounts().get(0).getAccId()));
        assertFalse(bk.account_existent(bk.accounts.size() + 1));

        assertEquals(bk.balance_account(bk.clients.get(0).getAccounts().get(0).getAccId()), 1000.00);
        assertEquals(bk.balance_account(bk.accounts.size() + 1), 0);

        assertEquals(bk.idAccounts_Client(numberDocument).get(0), bk.clients.get(0).getAccounts().get(0).getAccId());

        assertFalse(bk.debit_account(bk.accounts.size() + 1, 2000.00));
        assertTrue(bk.debit_account(bk.clients.get(0).getAccounts().get(0).getAccId(), 200.00));

        bk.credit_account(bk.clients.get(0).getAccounts().get(0).getAccId(), 1000.00);
        assertEquals(bk.balance_account(bk.clients.get(0).getAccounts().get(0).getAccId()), 1000 - 200 - bk.tax.getValue() + 1000 - bk.tax.getValue());


    }

    @Test
    void add_acocount_with_value() {
        // Main Client
        String name = "Rui";
        Date birthDay = new Date(1980,01,01);
        char typeDocument = 'C';
        String numberDocument = "12345678";
        String email = "rui@gmail.com";
        int phoneNumber = 912345678;
        String street = "Rua de Mil Fontes";
        String postalCode = "2635-123";
        String city = "Lisboa";
        String country = "Portugal";
        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);

        //Other Client
        String name2 = "Rui";
        Date birthDay2 = new Date(1980,01,01);
        char typeDocument2 = 'C';
        String numberDocument2 = "87654321";
        String email2 = "rui@gmail.com";
        int phoneNumber2 = 912345678;
        String street2 = "Rua de Mil Fontes";
        String postalCode2 = "2635-123";
        String city2 = "Lisboa";
        String country2 = "Portugal";
        bk.add_client(name2, birthDay2, typeDocument2, numberDocument2, email2, phoneNumber2, street2, postalCode2, city2, country2);


        List<String> numberDocumentOthers = new LinkedList<String>();
        numberDocumentOthers.add(numberDocument2);

        assertEquals(bk.add_account(numberDocument, numberDocumentOthers, 0), bk.accounts.size());
    }


}
