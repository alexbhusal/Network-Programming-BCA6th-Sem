package LAB;

import LAB.Adder;

import java.rmi.Naming;
import java.util.Scanner;

public class AdderClient {

    public static void main(String[] args) throws Exception {

        Adder adder = (Adder) Naming.lookup("rmi://localhost/AdderService");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");

        int num1 = sc.nextInt(), num2 = sc.nextInt();

        System.out.println("Sum: " + adder.add(num1, num2));

    }

} 