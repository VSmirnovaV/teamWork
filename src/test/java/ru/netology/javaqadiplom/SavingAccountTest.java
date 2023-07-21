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

    @Test
    public void testNegativeValuesInitialBalanceMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            999,
                            1000,
                            10000,
                            5
                    );
                }
        );

    }


    @Test
    public void testNegativeValuesInitialBalanceMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            10001,
                            1000,
                            10000,
                            5
                    );
                }
        );

    }

    @Test
    public void testNegativeValuesMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            -1,
                            10000,
                            5
                    );
                }
        );

    }

    @Test
    public void testNegativeValuesMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            1000,
                            999,
                            5
                    );
                }
        );

    }

    @Test
    public void testNegativeValuesMaxBalance_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            1000,
                            1000,
                            5
                    );
                }
        );

    }

    @Test
    public void testNegativeValuesRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            1000,
                            10000,
                            -5
                    );
                }
        );

    }


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
    public void testMaxBalance2() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(8001);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testMaxBalance3() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(7999);

        Assertions.assertEquals(9999, account.getBalance());
    }

    @Test
    public void testMaxBalance4() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(10000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testNegative() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(-1000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testNegative_1() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.pay(-10000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testBoundaryValues() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testBoundaryValues_1() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.pay(1001);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testBoundaryValues_2() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.pay(999);

        Assertions.assertEquals(1_001, account.getBalance());
    }

    @Test
    public void testMinBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );


        Assertions.assertEquals(1000, account.getMinBalance());
    }

    @Test
    public void testMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );


        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void testPayMinBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        boolean result = account.pay(1_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayNegative() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );

        account.pay(3000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(300, account.yearChange());
    }
}