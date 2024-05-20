
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//一度だけ(サーバー)
public class TaskServerOnce {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("ポート番号を入力してください→");
            int port = sc.nextInt();
            System.out.println(port + "番ポートで待機します...");
            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("接続しました。クライアントの入力待ちです...");

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                try {
                    TaskObject taskObj = (TaskObject) ois.readObject();

                    if (taskObj == null) {
                        System.out.println("クライアントが接続を終了しました");
                        break;
                    }

                    taskObj.exec();
                    oos.writeObject(taskObj);
                    oos.flush();
                } catch (Exception e) {
                    System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                } finally {
                    // close処理
                    ois.close();
                    oos.close();
                    // socketの終了
                    socket.close();
                    break;
                }
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください");
        } catch (Exception e) {
            System.err.println("エラーが発生しました。プログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
