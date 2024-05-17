
import java.net.InetAddress;

public class CheckLocalAddreess {

    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String hostName = addr.getHostName();
            System.out.println("Host name is " + hostName);
            String hostAddress = addr.getHostAddress();
            System.out.println("IP address is " + hostAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
