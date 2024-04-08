package assessment1;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Customer> dependents = new ArrayList<>();

    public PolicyHolder (){super();
    this.dependents = new ArrayList<>();}
    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard, List<Customer> dependents){
        super(customerID, fullName, insuranceCard);
        this.dependents = dependents;
    }
    public boolean AddDependent(Customer Dependent){
        if(!hasDependent(Dependent)){
            dependents.add(Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public  boolean RemoveDependent(Customer Dependent){
        if(hasDependent(Dependent)){
            dependents.remove(Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public Customer getDepdendent(Customer Dependent){
        if(hasDependent(Dependent)){
            return  Dependent;
        }else {return  null;}
    }
    public List<Customer> getAllDependent(){
       return dependents;
    }
    public boolean hasDependent(Customer Dependent){
        return Dependent instanceof Customer && dependents.contains(Dependent);
    }
}
