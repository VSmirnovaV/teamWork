package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.CreditAccount;

public class CreditAccountTest {

    @Test
    public void shouldAddPositiveBalance() { // следует пополнить баланс

        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.add(3000);

        Assertions.assertEquals(3_000, account.getBalance());

    }

    @Test
    public void shouldAddToBalanceZero() { // вызов метода add без пополнения
        CreditAccount account = new CreditAccount(3_000, 5_000, 15);

        account.add(0);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeBalance() { // невалидное пополнение
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionsNegativeRate() { //следует выкинуть исключение при отрицательной ставке

       Assertions.assertThrows(IllegalArgumentException.class, () -> {
           CreditAccount account = new CreditAccount(1000,5000,-15);
      });
    }

    @Test
    public void shouldThrowExceptionZeroRate() { //следует выкинуть исключение при ставке равной 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(1000,5000,0);
        });
    }
    @Test
    public void shouldThrowExceptionsNegativeCreditLimit() { //следует выкинуть исключение при отрицательном кредитном лимите

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(1000,-5000,15);
        });
    }

    @Test
    public void shouldThrowExceptionsNegativeInitialBalance() { //следует выкинуть исключение при начальном балансе

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-1000,5000,15);
        });
    }

    @Test
    public void initialBalanceZero() { //следует установить начальный баланс - 0
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void initialBalance() { //установка начального баланса валидное значение
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void zeroCreditLimit() { // следует установить кредитный лимит - 0
        CreditAccount account = new CreditAccount(1_000, 0, 15);

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void creditLimit() { //установка кредитного лимита валидное значение
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        Assertions.assertEquals(5_000, account.getCreditLimit());
    }

    @Test
    public void balanceNotChangeIfAmountZero() { //вызов метода без совершения покупки
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void balanceNotChangeIfAmountNegative() { //баланс не должен измениться при отрицательной покупке
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(-3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void balanceShouldChangeIfAmountPositive() { // следует сделать покупку за счет своих средств
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(1_500);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void balanceMustBecomeZero() { // следует сделать покупку за счет всех своих средств
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(2_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldUseCreditLimitNotInitialBalance() { // следует уйти в минус при покупке без использования собственных средств
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.pay(2_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldUseAllCreditLimitNotInitialBalance() { // следует уйти в минус при покупке без использования собственных средств
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.pay(5_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldUseCreditLimitWithInitialBalance() { // следует сделать покупку используя свои средства и кредитный лимит
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldUseInitialBalanceAndCreditLimit() { //следует сделать покупку, использовав все свои средства и весь кредитный лимит
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(7_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldMakeAmountMoreInitialBalanceAndCreditLimit() { // следует сделать покупку больше,чем собственные средства+кредитный лимит
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(10_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldCalculatePercentOnDebt() { //следует рассчитать процент
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.pay(2_000);

        Assertions.assertEquals(-300, account.yearChange());
    }

    @Test
    public void shouldUseInitialBalance() { // следует рассчитать процент, не используя кредитных средств
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(2_000);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldUseNotAllInitialBalance() { // следует рассчитать процент, не используя кредитный лимит и половину собсвтенных средств
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(1_000);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCountRateInitialBalanceAndCreditLimit() { // следует рассчитать процент при покупке за счет своих средств и кредитного лимита
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);

        account.pay(4_000);

        Assertions.assertEquals(-300, account.yearChange());
    }

    @Test
    public void shouldCountRateUseAllCreditLimit() { // следует рассчитать процент при покупке за счет всего кредитного лимита
        CreditAccount account = new CreditAccount(0, 5_000, 15);

        account.pay(5_000);

        Assertions.assertEquals(-750, account.yearChange());
    }
}
