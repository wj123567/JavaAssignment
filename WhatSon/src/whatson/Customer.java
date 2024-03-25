/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whatson;

public class Customer {
    private String custID;
    private String custName;
    private String custPhone;
    private String custEmail;
    private char custGender;
    private String custDob;
    private RewardPoint rp;
    
    public Customer(){
        custID=" ";
        custName=" ";
        custPhone=" ";
        custEmail=" ";
        custGender=' ';
        custDob=" ";
    }
    
    public Customer(String custID, String custName, String custPhone, String custEmail, char custGender, String custDob, RewardPoint rp){
        this.custID=custID;
        this.custName=custName;
        this.custPhone=custPhone;
        this.custEmail=custEmail;
        this.custGender=custGender;
        this.custDob=custDob;
        this.rp=rp;
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
    public String getCustDob(){
        return custDob;
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
               
      public String toString(){
          return "\nCustomer Information\n====================================\n"
                  + "Customer ID: " +custID
                  +"\nCustomer Name: "+ custName
                  +"\nCustomer Phone No: "+ custPhone
                  +"\nCustomer Email Address: " + custEmail
                  +"\nCustomer Gender: " + custGender
                  +"\nCustomer Birth Date: "+ custDob
                  +rp.toString();
      }
      
    }
    
    