package LAB;

import LAB.AdderImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AdderServer {

    public static void main(String[] args) throws Exception {

        LocateRegistry.createRegistry(1099);

        Naming.rebind("AdderService", new AdderImpl());

        System.out.println("Server ready.");

    }

} 