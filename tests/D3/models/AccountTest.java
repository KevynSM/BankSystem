package D3.models;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getAccId() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client);
        assertEquals(account.getAccId(), 50001);
    }

    @Test
    void mainClient() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client);
        Client newClient = new Client(10001, "Nome2 Apelido2", birthDay, 'B', "ABC001", null, 0);
        assertEquals(account.getMainClient(), client);
        account.setMainClient(newClient);
        assertEquals(account.getMainClient(), newClient);
    }

    @Test
    void otherClients() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client);
        Client otherClient = new Client(10001, "Nome2 Apelido2", birthDay, 'B', "ABC001", null, 0);
        account.addOtherClients(otherClient);
        assertTrue(account.getOtherClients().contains(otherClient));
        account.removeOtherClients(otherClient);
        assertFalse(account.getOtherClients().contains(otherClient));
    }

    @Test
    void accMovements() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client);
        AccMovement accMovement = new AccMovement("01/01/2020", 100.00, 0.49, 'D');
        account.addAccMovements(accMovement);
        assertTrue(account.getAccMovements().contains(accMovement));
    }

    @Test
    void credit() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client, 1000.00);
        account.credit(1000.00);
        Tax tax = new Tax();
        assertEquals(account.getAccBalance(), 2000.00 - tax.getValue());
    }

    @Test
    void debit() {
        Date birthDay = new Date(1980,01,01);
        Client client = new Client(10001, "Nome Apelido", birthDay, 'B', "ABC001", null, 0);
        Account account = new Account(50001, client);
        account.credit(1000.00);
        Tax tax = new Tax();
        assertEquals(account.getAccBalance(), 1000.00 - tax.getValue());
        account.debit(500.00);
        assertEquals(account.getAccBalance(), 500.00 - 2*tax.getValue());
        assertFalse(account.debit(1000.00));
    }
}