package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxTest {

    @Test
    void getValue() {
        Tax tax = new Tax();
        assertEquals(0.49, tax.getValue());
    }

    @Test
    void setValue() {
        Tax tax = new Tax();
        assertEquals(0.49, tax.getValue());
        tax.setValue(1.0);
        assertEquals(1.0, tax.getValue());
    }
}