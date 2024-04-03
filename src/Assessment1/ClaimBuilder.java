package Assessment1;

import java.util.List;

public class ClaimBuilder {
    Claim claim = new Claim();
    public ClaimBuilder setID(String claimID){
        claim.setClaimID(claimID);
        return this;
    }
    public ClaimBuilder setDate(){}
    public ClaimBuilder setInsuredPerson(Customer insuredPerson){
        claim.setInsuredPerson(insuredPerson);
        return this;
    }
    public ClaimBuilder setCardNumber(String CardNumber){
        claim.setCardNumber(CardNumber);
        return this;
    }
    public ClaimBuilder setExamDate(){

        return this;
    }
    public ClaimBuilder setClaimAmount(double claimAmount){
        claim.setClaimAmount(claimAmount);
        return this;
    }
    public ClaimBuilder setStatus(Status status){
        claim.setStatus(status);
        return this;
    }
    public ClaimBuilder setBankingInfo(){
        return this;
    }
    public Claim build(){
        return  claim;
    }
}
