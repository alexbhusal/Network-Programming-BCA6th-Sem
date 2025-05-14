package LAB;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderImpl extends UnicastRemoteObject implements Adder {

    public AdderImpl() throws RemoteException {
        super();
    }

    public int add(int num1, int num2) throws RemoteException {

        return num1 + num2;

    }

} 