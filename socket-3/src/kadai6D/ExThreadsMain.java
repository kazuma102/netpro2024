package kadai6D;

public class ExThreadsMain implements Runnable {

    public static void main(String[] args) {
        ExThreadsMain ct = new ExThreadsMain();
        Thread th = new Thread(ct);
        th.start();
    }

    public void run() {
        try {
            String str = "Wryyy";
            String[] word = new String[]{
                "らせん階段", "カブト虫", "廃墟の街",
                "イチジクのタルト", "カブト虫", "ドロローサへの道",
                "カブト虫", "特異点", "ジョット",
                "天使", "紫陽花", "カブト虫",
                "特異点", "秘密の皇帝"};

            for (int i = 0; i < word.length; i++) {
                System.out.println("プッチ神父 < " + word[i] + "...!");
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
