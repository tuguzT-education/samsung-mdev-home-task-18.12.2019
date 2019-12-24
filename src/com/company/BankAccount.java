package com.company;

import java.util.Random;

public class BankAccount extends Thread {
    private boolean flag;
    protected static int moneySum;

    BankAccount(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        while (true) {
            int temp = Math.abs(new Random().nextInt()) % 1000 + 1;
            String message;
            if (flag) {
                if (moneySum - temp >= 0) {
                    moneySum -= temp;
                    message = "Было снято " + temp + " рублей\n";
                } else {
                    message = "Недостаточно средств для снятия " + temp + " рублей!\n";
                }
            } else {
                moneySum += temp;
                message = "Было зачислено " + temp + " рублей\n";
            }
            message += "Текущая сумма на аккаунте (в рублях): " + moneySum + "\n";
            Main.print(message);
        }
    }
}
