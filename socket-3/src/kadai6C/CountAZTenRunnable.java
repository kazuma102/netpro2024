package kadai6C;

public class CountAZTenRunnable implements Runnable {

    public static void main(String[] args) {
        CountAZTenRunnable ct = new CountAZTenRunnable();
        Thread th = new Thread(ct);
        th.start();
    }

    public void run() {
        try {
            char ch = 97;
            for (int i = 1; i <= 10; i++) {
                for(int j = 0; j < 26; j++){
                    System.out.print((char)ch);
                    System.out.println(i);
                    Thread.sleep(500);
                    ch++;
                }
                ch = 97;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
