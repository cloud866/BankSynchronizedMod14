public class Bank {

    private static int money = 10000;

    static int getMoney() {
        return money;
    }

    static synchronized void take(int money) {
        Bank.money -= money;
    }

    static synchronized void repay(int money) {
        Bank.money += money;
    }

    static class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Client().start();
        new Client().start();
        new Client().start();
        while(true) {
            System.out.println(Bank.money);
            Thread.sleep(1000);
        }
    }
}