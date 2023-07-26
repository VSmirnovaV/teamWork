package ru.netology.javaqadiplom;

public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;
    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Накопительная ставка не может быть отрицательной, а у вас: " + rate);
            }
            this.balance = initialBalance;
            this.minBalance = minBalance;
            this.maxBalance = maxBalance;
            this.rate = rate;
        }
        @Override
        public boolean pay(int amount) {
            if (amount <= 0) {
                return false;
            }
            balance = balance - amount;
            if (balance > minBalance) {
                return true;
            } else {
                return false;
            }
        }
        @Override
        public boolean add(int amount) {
            if (amount <= 0) {
                return false;
            }
            if (balance + amount < maxBalance) {
                balance = amount;
                return true;
            } else {
                return false;
            }
        }
        @Override
        public int yearChange() {

        return balance / 100 * rate;

    }

        public int getMinBalance() {

        return minBalance;
        }

        public int getMaxBalance() {

        return maxBalance;
    }
}

