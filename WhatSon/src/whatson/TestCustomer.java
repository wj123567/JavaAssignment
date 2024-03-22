/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package whatson;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class TestCustomer {
    public static void main(String[] args) {
        Customer customer =new Customer();
        
        
        Scanner scan=new Scanner(System.in);
        System.out.println("1 Register Customer");
        System.out.println("2 Check Customer Detail");
        System.out.println("3 Update Point");
        System.out.println("4 Update Date");
        int selection = scan.nextInt();
        scan.nextLine();
        
        switch(selection){
            case 1:
                customer.register();
                break;
            case 2:
                System.out.print("Enter customer ID: ");
                String inputCustID = scan.nextLine();
                customer.findCustInfo(inputCustID);
                System.out.print(customer.toString());
                break;
            case 3:
                System.out.print("Enter customer ID: ");
                String inputCustID2 = scan.nextLine();
                customer.findCustInfo(inputCustID2);
                customer.updateCustPoint(200);
                System.out.print(customer.toString());
                break;
            case 4:
                System.out.print("Enter customer ID: ");
                String inputCustID3 = scan.nextLine();
                customer.findCustInfo(inputCustID3);
                customer.updateCustPointExpDate();
                System.out.print(customer.toString());
                break;
            default:
                System.out.println("Please enter a valid number");
        }
    }
    
}
