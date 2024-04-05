package assessment1;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Dependent> dependents;
    public PolicyHolder (){super();
    this.dependents = new ArrayList<>();}
    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard, List<Dependent> dependents){
        super(customerID, fullName, insuranceCard);
        this.dependents = dependents;
    }
    public boolean AddDependent(Customer Dependent){
        if(!hasDependent(Dependent)){
            dependents.add((assessment1.Dependent) Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public  boolean RemoveDependent(Customer Dependent){
        if(hasDependent(Dependent)){
            dependents.remove((assessment1.Dependent)Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public Customer getDepdendent(Customer Dependent){
        if(dependents.contains(Dependent)){
            return Dependent;
        }else {return  null;}
    }
    public boolean hasDependent(Customer Dependent){
        return Dependent instanceof Dependent && dependents.contains(Dependent);
    }
}
