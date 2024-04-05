package assessment1;



public class Dependent extends Customer{
    //should we have a policyHolder attribute for the one that this customer depend on
    private Customer DependOn;
    public Dependent (){super();}
    public  Dependent(String customerID, String fullName, InsuranceCard insuranceCard/*,PolicyHolder dependOn*/ ){
        super(customerID, fullName, insuranceCard);
    }

    public Customer getDependOn() {
        return DependOn;
    }

    public boolean setDependOn(Customer dependOn) {
        if(dependOn instanceof PolicyHolder){
        DependOn = dependOn;
        return true;}
        else {return false;}
    }

}
