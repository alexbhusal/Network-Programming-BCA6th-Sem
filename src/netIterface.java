import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class netIterface {
    public static void main(String[] args) throws SocketException {

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = netInterfaces.nextElement();
            System.out.println(netInterface);
        }

        NetworkInterface nt= NetworkInterface.getByName("en0");
        if(nt == null) {
            System.out.println("No network interface found.");
        }else{
            System.out.println("Network interface found with en0");
        }

    }
}
