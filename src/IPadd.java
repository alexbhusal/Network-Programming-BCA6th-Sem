import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPadd {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("127.0.0.1");
            if(address.isAnyLocalAddress()){
                System.out.println(address+" is any local address");
            }
            if(address.isLoopbackAddress()){
                System.out.println(address+" is loopback address");
            }
            if(address.isLinkLocalAddress()){
                System.out.println(address+" is link local address");
            }
            if(address.isSiteLocalAddress()){
                System.out.println(address+" is site local address");
            }else {
                System.out.println(address+" is a global site address");
            }

            if(address.isMulticastAddress()){
                if(address.isMCGlobal()){
                    System.out.println(address+" is multicast address");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address+" is multicast address");
                }else{
                    System.out.println(address+" is unknown multicast local address");
                }
            }else {
                System.out.println(address+" is a unicast address");
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
