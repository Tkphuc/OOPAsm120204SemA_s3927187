package Assessment1;

import java.util.List;

public class PolicyHolder extends Customer{
    private List<Dependent> dependents;
    public PolicyHolder (){super();}
    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList, List<Dependent> dependents){
        super(customerID, fullName, insuranceCard, claimsList);
        this.dependents = dependents;
    }
    public boolean AddDependent(Customer Dependent){
        if(isDependentOfCustomer(Dependent)){
            dependents.add((Assessment1.Dependent) Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public  boolean RemoveDependent(Customer Dependent){
        if(isDependentOfCustomer(Dependent)){
            dependents.remove((Assessment1.Dependent)Dependent);
            return  true;
        }else{
            return  false;
        }
    }
    public boolean isDependentOfCustomer(Customer Dependent){
        if(Dependent instanceof  Dependent && dependents.contains(Dependent)){
            return  true;
        }else {return  false;}
    }
    /*
    @Override
    public boolean add(Claim claim) {
        if(!this.getClaimsList().contains(claim)){
        this.getClaimsList().add(claim);
        return  true;}
        else{return  false;}
    }
    @Override
    public void update(Claim claim) {
        if(this.getClaimsList().contains(claim)){

            Claim updatedClaim = new Claim();
            /*
            updatedClaim.setClaimID(claim.getClaimID());
            updatedClaim.setClaimDate(claim.getClaimDate());
            updatedClaim.setInsuredPerson(claim.getInsuredPerson());
            updatedClaim.setCardNumber(claim.getCardNumber());
            updatedClaim.setExamDate(claim.getExamDate());
            updatedClaim.setStatus(claim.getStatus());
            updatedClaim.setClaimAmount(claim.getClaimAmount());
            claim = updatedClaim;
        }
    }

    @Override
    public boolean delete(Claim claim) {
        if(this.getClaimsList().contains(claim)){
            this.getClaimsList().remove(claim);
            return  true;
        }else{
        return false;}
    }*/
    /*
    @Override
    public Claim getOne(String claimID) {
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        while (localClaimList.hasNext()){
            Claim localClaim = new Claim();
            localClaim = (Claim) localClaimList.next();
            if(localClaim.getClaimID().equals(claimID)){
                return localClaim;
            }
        }
        return null;
    }

    @Override
    public Claim getAll() {
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        while (localClaimList.hasNext()){
            return localClaimList.next();
        }
        return null;
        }
    }*/
    /*
    @Override
    public boolean IDFormatCheck(String inputID) {

        return false;
    }*/
}
