package com.company;

import static com.company.BankAccount.moneySum;

public class Main {
    private static Object key = new Object();

    public static void main(String[] args) {
        BankAccount minus = new BankAccount(false),
                    plus = new BankAccount(true);
        System.out.println("Первоначальный баланс на банковском аккаунте равен " + moneySum + "\n");
        plus.start();
        minus.start();
    }

    public static void print(String message) {
        try {
            synchronized (key) {
                System.out.println(message);
                Thread.sleep(1000);
            }
        } catch(Exception e) { }
    }
}
