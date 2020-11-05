package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentsTest {

    @Test
    void getTypeDocument() {
        Documents documents = new Documents('C', "ABC0001");
        assertEquals(documents.getTypeDocument(), 'C');
    }

    @Test
    void getNumberDocument() {
        Documents documents = new Documents('C', "ABC0001");
        assertEquals(documents.getNumberDocument(), "ABC0001");
    }
}