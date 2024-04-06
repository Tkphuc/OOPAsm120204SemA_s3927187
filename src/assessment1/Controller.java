package assessment1;

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
         Claim newClaim;
         newClaim = consoleView.displayClaimCreationForm();
         return newClaim;
    }
    public Customer createCustomer(){
        Customer newCustomer;
        newCustomer = consoleView.displayCustomerCreationForm();
        return newCustomer;
    }
    public InsuranceCard createInsuranceCard(){
        InsuranceCard newInsuranceCard;
        newInsuranceCard = consoleView.insuranceCardCreationForm();
        return newInsuranceCard;
    }


}
