package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void testMaxBalance1() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(8000);

        Assertions.assertEquals(10000, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);
        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void testPayMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(1_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testNegativValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
              -2_000,
              -1_000,
              -10_000,
              -5
            );
        }
        );
    }

    @Test
    public void testPayNegative() {
        SavingAccount account = new SavingAccount(
          2_000,
          1_000,
          10_000,
          5
        );

        account.pay(3_000);

        Assertions.assertEquals(2000, account.getBalance());
    }

 }