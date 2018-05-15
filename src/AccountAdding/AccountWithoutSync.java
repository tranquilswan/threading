package AccountAdding;

//This code example is to highlight the issue of race conditions in multi-threading and how to make the class thread-safe

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("What is the balance? " + account.getBalance());
    }


    private static class AddAPennyTask implements Runnable {

        @Override
        public void run() {
            account.deposit(0.01);
        }
    }

    private static class Account {
        private double balance = 0.0;

        public double getBalance() {
            return this.balance;
        }

        public synchronized void deposit(double amount) {
            double newBalance = this.balance + amount;

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }

            this.balance = newBalance;
        }
    }
}

/*
    Before the "synchronized" keyword was added to the deposit method, the balance output was an incorrect value.
    This was due to a phenomenon referred to as a 'race condition'. In a race condition, multiple threads are accessing
    a critical region at the same time. Multiple threads were accessing the deposit method at the same time,
    overwriting values. To make the class thread safe, we use the 'synchronized' keyword in the critical region that is
    the deposit() method of the Account class. This implements a thread lock before the method is executed.

 */