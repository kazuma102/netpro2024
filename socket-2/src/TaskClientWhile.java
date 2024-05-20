import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    //繰り返し(クライアント)
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.print("判定する整数を入力してください→ ");
            int number = scanner.nextInt();

            TaskObject task = new TaskObject();
            task.setExecNumber(number);

            oos.writeObject(task);
            oos.flush();

            TaskObject resultTask = (TaskObject) ois.readObject();
            System.out.println("入力値以下で最大の素数は"+ resultTask.getResult() + "です");

            ois.close();
            oos.close();
            socket.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
