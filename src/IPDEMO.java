import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDEMO {
    public static void main(String[] args) throws UnknownHostException {

        String Hname = "bhuvanbhusal.com.np";
        InetAddress iName= InetAddress.getByName(Hname);
        String hostname = iName.getHostName();
        String ip = iName.getHostAddress();
        String Cname = iName.getCanonicalHostName();
        System.out.println("The Host Name is: "+hostname);
        System.out.println("The Ip Address is: "+ip);
        System.out.println("The CNAME is: "+Cname+"\n");

        InetAddress lAddress = InetAddress.getLocalHost();
        System.out.println("The LocalHost Address is: "+lAddress);


        byte[] hostAddress =lAddress.getAddress();
        if(hostAddress.length == 6) {
            System.out.println("IP address is IPv6 address");
        }
        else if(hostAddress.length == 4) {
            System.out.println("IP address is IPv4 address");
        }
        else{
            System.out.println("Invalid Ip Address");
        }
    }
}
