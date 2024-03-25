/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whatson;

/**
 *
 * @author User
 */
public class RewardPoint {
    private double custPoint;
    private String custPointExpDate;
    
    public RewardPoint(){
        custPoint = 0.0;
        custPointExpDate = " ";
    }
            
    public RewardPoint(double custPoint, String custPointExpDate){
        this.custPoint=custPoint;
        this.custPointExpDate=custPointExpDate;
    }
    
    public double getCustPoint(){
        return custPoint;
    }
    
    public String getCustPointExpDate(){
        return custPointExpDate;
    }
    
    public void setCustPointExpDate(String custPointExpDate){
        this.custPointExpDate=custPointExpDate;
    }
    
    public void setCustPoint(double custPoint){
        this.custPoint = custPoint;
    }
    
    public String toString(){
        return                  
        "\nCustomer Reward Point: " + custPoint +
        "\nReward Point Expiry Date: " + custPointExpDate +
        "\n";
    }
}
