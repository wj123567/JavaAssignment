/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package whatson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TestCustomer {
    Customer cust = new Customer();
    RewardPoint rp = new RewardPoint();
    
    public static void main(String[] args) {
        TestCustomer customer = new TestCustomer();
        int lineNo =0;
        
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
                lineNo=customer.findCustInfo();
                break;
            case 3:
                lineNo=customer.findCustInfo();
                customer.updateCustPoint(200,lineNo);
                break;
            case 4:
                lineNo=customer.findCustInfo();
                customer.updateCustPointExpDate(lineNo);
                break;
            default:
                System.out.println("Please enter a valid number");
        }
    }
    
       
    public void register(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter customer Name: ");
        String custName=scan.nextLine();
        System.out.print("Enter customer Phone: ");
        String custPhone=scan.nextLine();
        System.out.print("Enter customer Email: ");
        String custEmail=scan.nextLine();
        System.out.print("Enter customer Gender: ");
        char custGender=scan.next().charAt(0);
        scan.nextLine();
        System.out.print("Enter customer Birth Day(dd/mm/yyyy): ");
        String custDob=scan.nextLine();
        
                
        recordNewCustInfo(custName,custPhone,custEmail,custGender,custDob);
    }
    
     public void recordNewCustInfo(String custName,String custPhone,String custEmail,char custGender,String custDob){
         //Get Customer Data from file
        // Create an ArrayList to store the data read from the file
        ArrayList<String> custInfo = new ArrayList<>();

        // Specify the file path
        String filePath = "Customer.txt";
                
        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Read data from the file line by line
            while (scanner.hasNextLine()) {
                // Add each line to the ArrayList
                custInfo.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.err.println("File not found: " + e.getMessage());
        }
        String custID = "ABC"+ ((int)(Math.random()*90000)+10000);
        Double custPoint=0.0;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String custPointExpDate= dateFormat.format(date);
        
        custInfo.add(custInfo.size(),custID +";"+custName+";"+custPhone+";"+custEmail+";"+custGender+";"+custDob+";"+custPoint+";"+custPointExpDate);
        
        String filePaths ="Customer.txt";
        try(FileWriter fw = new FileWriter(filePaths)){
            for(int i=0;i<custInfo.size();i++){
                fw.write(custInfo.get(i)+"\n");
            }
            fw.close();
        }catch(IOException e){
            System.out.print("Fail writting file");
            return;
        }
        
        rp = new RewardPoint(custPoint,custPointExpDate);
        cust = new Customer(custID,custName,custPhone,custEmail,custGender,custDob,rp);

        System.out.print(cust.toString());
        }
     
     
        public int findCustInfo(){
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String inputCustID = scan.nextLine();
         //Get Customer Data from file
        // Create an ArrayList to store the data read from the file
        ArrayList<String> custInfo = new ArrayList<>();

        // Specify the file path
        String filePath = "Customer.txt";

        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Read data from the file line by line
            while (scanner.hasNextLine()) {
                // Add each line to the ArrayList
                custInfo.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.err.println("File not found: " + e.getMessage());
        }
        
        String[] temp=new String[8];

        int custLineNo;
        String custID;
        String custName;
        String custPhone;
        String custEmail;
        char custGender;
        String custDob;
        double custPoint;
        String custPointExpDate;
        
        for(custLineNo = 0;custLineNo<custInfo.size();custLineNo++){
        temp = custInfo.get(custLineNo).split(";");
        if(inputCustID.equals(temp[0])){
        custID=temp[0];
        custName=temp[1];
        custPhone=temp[2];
        custEmail=temp[3];
        custGender=temp[4].charAt(0);
        custDob=temp[5];
        custPoint=Double.parseDouble(temp[6]);
        custPointExpDate=temp[7];
        rp = new RewardPoint(custPoint,custPointExpDate);
        cust = new Customer(custID,custName,custPhone,custEmail,custGender,custDob,rp);
        System.out.print(cust.toString());
        break;
        }else if(custLineNo+1==custInfo.size()){
            System.out.println("Customer ID is invalid");
        }
        }
       
        return custLineNo;

    }
        
        public void updateExistingCustInfo(int custLineNo){
        //Get Customer Data from file
        // Create an ArrayList to store the data read from the file
        ArrayList<String> custInfo = new ArrayList<>();

        // Specify the file path
        String filePath = "Customer.txt";
                
        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Read data from the file line by line
            while (scanner.hasNextLine()) {
                // Add each line to the ArrayList
                custInfo.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.err.println("File not found: " + e.getMessage());
        }
        
        custInfo.set(custLineNo,cust.getCustID()+";"+cust.getCustName()+";"+cust.getCustPhone()+";"+cust.getCustEmail()+";"+cust.getCustGender()+";"+cust.getCustDob()+";"+rp.getCustPoint()+";"+rp.getCustPointExpDate());
        
        String filePaths ="Customer.txt";
        try(FileWriter fw = new FileWriter(filePaths)){
            for(int i=0;i<custInfo.size();i++){
                fw.write(custInfo.get(i)+"\n");
            }
            fw.close();
        }catch(IOException e){
            System.out.print("Fail writting file");
        }
        
        System.out.print(cust.toString());
        }
        
      public void updateCustPoint(double updatePoint, int custLineNo){
          double custPoint = rp.getCustPoint();
          custPoint += updatePoint;
          rp.setCustPoint(custPoint);
          updateExistingCustInfo(custLineNo);
      }
      
      public void updateCustPointExpDate(int custLineNo){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(rp.getCustPointExpDate(),dateFormat);
        LocalDate newDate = date.plusDays(90);
        rp.setCustPointExpDate(newDate.format(dateFormat));
        updateExistingCustInfo(custLineNo);

      }
    
}
