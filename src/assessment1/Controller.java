package assessment1;

import java.util.Map;
import java.util.Date;

public class Controller {
    private Claim claim;
    private Customer customer;

    private InsuranceCard insuranceCard;
    private View consoleView;

    public Controller(Claim claim, Customer customer, InsuranceCard insuranceCard, View consoleView) {
        this.claim = claim;
        this.customer = customer;
        this.insuranceCard = insuranceCard;
        this.consoleView = consoleView;
    }
    public Claim createClaim(){
        Map<String,DynamicAttributeType> claimForm;
        claimForm = consoleView.displayClaimCreationForm();
        Claim localClaim;
        ClaimBuilder claimBuilder = new ClaimBuilder();
        String id = claimForm.get(View.CLAIM_ID).toString();
        Date claimDate = (Date) claimForm.get(View.CLAIM_DATE);
        Customer insuredPerson = (Customer) claimForm.get(View.INSURED_PERSON);

        localClaim = claimBuilder.setID

    }



}
