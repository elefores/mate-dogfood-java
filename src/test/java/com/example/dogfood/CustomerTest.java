package com.example.dogfood;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void gettersReturnConstructorValues() {
        Customer customer = new Customer("Ada", "ada@example.com", 36);

        assertEquals("Ada", customer.getName());
        assertEquals("ada@example.com", customer.getEmail());
        assertEquals(36, customer.getAge());
    }
}
