package kadai6A;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("サーバーはクライアントからのメッセージを待っています...");

                socket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("受信: " + clientMessage);

                //Scanner scanner = new Scanner(System.in);
                //System.out.print("返信を入力してください: ");
                //String serverResponse = scanner.nextLine();
                sendData = toUpStr(clientMessage);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    public static byte[] toUpStr(String str) {
        return str.toUpperCase().getBytes();
    }
}
