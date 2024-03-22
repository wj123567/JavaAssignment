/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whatson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Customer {
    private int custLineNo;
    private String custID;
    private String custName;
    private String custPhone;
    private String custEmail;
    private char custGender;
    private String custBirthDay;
    private double custPoint;
    private String custPointExpDate;
    
    public Customer(){
        custLineNo=0;
        custID=" ";
        custName=" ";
        custPhone=" ";
        custEmail=" ";
        custGender=' ';
        custBirthDay=" ";
        custPoint=0.0;
        custPointExpDate=" ";
        
    }
    
    public String getCustID(){
        return custID;
    }
    public String getCustName(){
        return custName;
    }
    public String getCustPhone(){
        return custPhone;
    }
    public String getCustEmail(){
        return custEmail;
    }
    public char getCustGender(){
        return custGender;
    }
    public String getCustBirthDay(){
        return custBirthDay;
    }
    public double getCustPoint(){
        return custPoint;
    }
    public String getCustPointExpDate(){
        return custPointExpDate;
    }
    public void setCustName(String custName){
        this.custName=custName;
    }
    public void getCustPhone(String custPhone){
        this.custPhone=custPhone;
    }
    public void getCustEmail(String custEmail){
        this.custEmail=custEmail;
    }
    
    public void register(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter customer Name: ");
        custName=scan.nextLine();
        System.out.print("Enter customer Phone: ");
        custPhone=scan.nextLine();
        System.out.print("Enter customer Email: ");
        custEmail=scan.nextLine();
        System.out.print("Enter customer Gender: ");
        custGender=scan.next().charAt(0);
        scan.nextLine();
        System.out.print("Enter customer Birth Day(dd/mm/yyyy): ");
        custBirthDay=scan.nextLine();
                
        recordNewCustInfo();
        toString();
    }
    
     public void recordNewCustInfo(){
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
        custID = "ABC"+ ((int)(Math.random()*90000)+10000);
        custPoint=0.0;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String custPointExpDate= dateFormat.format(date);
        
        custInfo.add(custInfo.size(),custID +";"+custName+";"+custPhone+";"+custEmail+";"+custGender+";"+custBirthDay+";"+custPoint+";"+custPointExpDate);
        
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
        
        }
     
        public void updateExistingCustInfo(){
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
        
        custInfo.set(custLineNo,custID +";"+custName+";"+custPhone+";"+custEmail+";"+custGender+";"+custBirthDay+";"+custPoint+";"+custPointExpDate);
        
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
        }
        
        
        public void findCustInfo(String inputCustID){
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


        for(custLineNo = 0;custLineNo<custInfo.size();custLineNo++){
        temp = custInfo.get(custLineNo).split(";");
        if(inputCustID.equals(temp[0])){
        custID=temp[0];
        custName=temp[1];
        custPhone=temp[2];
        custEmail=temp[3];
        custGender=temp[4].charAt(0);
        custBirthDay=temp[5];
        custPoint=Double.parseDouble(temp[6]);
        custPointExpDate=temp[7];
        break;
        }else if(custLineNo+1==custInfo.size()){
            System.out.println("Customer ID is invalid");
        }
        }
    }
        
      public void updateCustPoint(double updatePoint){
          custPoint += updatePoint;
          updateExistingCustInfo();
      }
      
      public void updateCustPointExpDate(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(custPointExpDate,dateFormat);
        LocalDate newDate = date.plusDays(90);
        custPointExpDate=newDate.format(dateFormat);
        updateExistingCustInfo();

      }
      
               
      public String toString(){
          return "\nCustomer Information\n====================================\n"
                  + "Customer ID: " +custID
                  +"\nCustomer Name: "+ custName
                  +"\nCustomer Phone No: "+ custPhone
                  +"\nCustomer Email Address: " + custEmail
                  +"\nCustomer Gender: " + custGender
                  +"\nCustomer Birth Date: "+ custBirthDay
                  +"\nCustomer Reward Point: " + custPoint
                  +"\nReward Point Expiry Date: " + custPointExpDate
                  +"\n";
      }
      
    }
    
    
