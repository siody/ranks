package siody.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {
    public static void main(String[] args) {
        InetAddress address=null;
        try {
            address = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (null!=address){
            System.out.println(address.getHostAddress().toString());
            System.out.println(address.getHostName().toString());
            System.out.println(address.getAddress());
            System.out.println(address.getCanonicalHostName());
        }

    }
}
