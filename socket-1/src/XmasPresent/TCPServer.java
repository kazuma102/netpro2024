package XmasPresent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

    private static final int times = 2;

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁");
        for (int i = 0; i < times; i++) {
            sb.append(content);
        }
        sb.append("🎁");
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            while (true) { // サーバーを継続してクライアントからの接続を待つ
                Socket socket = server.accept(); // クライアントからの接続要求を待ち、接続を行う
                System.out.println("接続しました。相手の入力を待っています......");

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                try {
                    while (true) { // クライアントからの複数メッセージを処理するループ
                        Present present = (Present) ois.readObject(); // メッセージを受け取る

                        // クライアントが接続を終了するメッセージを確認
                        if (present == null || "exit".equalsIgnoreCase(present.getMessage())) {
                            System.out.println("クライアントが接続を終了しました");
                            break;
                        }

                        String msgPresent = present.getMessage();
                        System.out.println("メッセージは " + msgPresent);
                        String presentFromClient = present.getContent();
                        System.out.println("プレゼントの内容は " + presentFromClient);

                        Present response = new Present();
                        response.setMessage("サーバーです。メリークリスマス！\n" + presentFromClient + "ありがとう。\nプレゼントのお返しは " + times + "倍 です");
                        response.setContent(serverProcess(presentFromClient));

                        oos.writeObject(response);
                        oos.flush();
                    }
                } catch (Exception e) {
                    System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                } finally {
                    // close処理
                    ois.close();
                    oos.close();
                    // socketの終了
                    socket.close();
                }
            }
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}