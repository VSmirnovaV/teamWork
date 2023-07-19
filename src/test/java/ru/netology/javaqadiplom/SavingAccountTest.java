package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void testAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.add(3000);

        Assertions.assertEquals(5000, account.getBalance());
    }
   }
   