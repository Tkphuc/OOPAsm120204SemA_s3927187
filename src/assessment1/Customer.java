package assessment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ClaimProcessManager, Serializable {
    private String customerID;
    private String fullName;
    private  InsuranceCard insuranceCard;
    private List<Claim> claimsList;

    //public Customer(){}
    public Customer() {
        this.customerID = "Default";
        this.fullName = "Default";
        this.insuranceCard = null;
        this.claimsList = new ArrayList<>();
    }
    public Customer(String customerID, String fullName, InsuranceCard insuranceCard) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claimsList = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {

        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public List<Claim> getClaimsList() {
        return claimsList;
    }

    public void setClaimsList(List<Claim> claimsList) {
        this.claimsList = claimsList;
    }
    @Override
    public boolean add(Claim claim) {
    if(!(this.getClaimsList().contains(claim))){
            this.getClaimsList().add(claim);
            return  true;}
        else{return  false;}
    }

    @Override
    public void update(Claim claim) {
        if(this.getClaimsList().contains(claim)){

        }
    }

    @Override
    public boolean delete(Claim claim) {
        if(this.getClaimsList().contains(claim)){
            this.getClaimsList().remove(claim);
            return  true;
        }else{
            return false;}
    }
    @Override
    public Claim getOne(String claimID) {
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        while (localClaimList.hasNext()){
            Claim localClaim;
            localClaim = localClaimList.next();
            if(localClaim.getClaimID().equals(claimID)){
                return localClaim;
            }
        }
        return null;
    }

    @Override
    public Claim getAll() {
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        if(localClaimList.hasNext()){
            return localClaimList.next();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return this.customerID.length();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }
        if(!(other instanceof Customer)){
            return false;
        }
        Customer customer = (Customer) other;
        return this.customerID.equals(((Customer) other).customerID);
    }
}
