package assessment1;

import java.util.Date;
import java.util.List;

public class ClaimBuilder {
    Claim claim = new Claim();
    public ClaimBuilder setID(String claimID){
        claim.setClaimID(claimID);
        return this;
    }
    public ClaimBuilder setClaimDate(Date date){
        claim.setClaimDate(date);
        return this;
    }
    public ClaimBuilder setInsuredPerson(Customer insuredPerson){
        claim.setInsuredPerson(insuredPerson);
        return this;
    }
    public ClaimBuilder setCardNumber(String CardNumber){
        claim.setCardNumber(CardNumber);
        return this;
    }
    public ClaimBuilder setExamDate(Date date){
        claim.setExamDate(date);
        return this;
    }
    public ClaimBuilder setDocuments(List<String> documents){
        claim.setDocuments(documents);
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
    public ClaimBuilder setBankingInfo(String bank,String name,String number){
        ReceiverBankingInfo receiverBankingInfo = new ReceiverBankingInfo(bank,name,number);
        claim.setReceiverBankingInfo(receiverBankingInfo);
        return this;
    }
    public Claim build(){
        return  claim;
    }
}
