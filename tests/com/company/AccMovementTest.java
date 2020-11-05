package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccMovementTest {

    @Test
    void getDate() {
        AccMovement accMovement = new AccMovement("01/01/2020", 100.00, 0.49, 'D');
        assertEquals(accMovement.getDate(), "01/01/2020");
    }

    @Test
    void getValue() {
        AccMovement accMovement = new AccMovement("01/01/2020", 100.00, 0.49, 'D');
        assertEquals(accMovement.getValue(), 100.00);
    }

    @Test
    void getTax() {
        AccMovement accMovement = new AccMovement("01/01/2020", 100.00, 0.49, 'D');
        assertEquals(accMovement.getTax(), 0.49);
    }

    @Test
    void getTypeMovement() {
        AccMovement accMovement = new AccMovement("01/01/2020", 100.00, 0.49, 'D');
        assertEquals(accMovement.getTypeMovement(), 'D');
    }
}