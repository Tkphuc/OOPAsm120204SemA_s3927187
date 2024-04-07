package assessment1;
// https://www.baeldung.com/java-hashmap-different-value-types
//https://stackoverflow.com/questions/24863185/what-is-an-assertionerror-in-which-case-should-i-throw-it-from-my-own-code
//https://www.w3schools.com/java/java_files_create.asp
import java.util.Date;
import java.util.Scanner;

public class ConsoleView{

    public void displayOneClaim(Claim claim){
        System.out.println("All info of the claim");
        System.out.println();
        System.out.println("Claim ID: "+claim.getClaimID());
        System.out.println("Claim date: "+claim.getClaimDate());
        System.out.println("Insured Person name: "+claim.getInsuredPerson().getFullName());
        System.out.println("Insured person ID: "+claim.getInsuredPerson().getCustomerID());
        System.out.println("Card number: "+claim.getCardNumber());
        System.out.println("Exam date: "+claim.getExamDate());
        System.out.println("Documents: "+claim.getDocuments());
        System.out.println("Claim amount: "+claim.getClaimAmount());
        System.out.println("Claim status: "+claim.getStatus());
        System.out.println("Receiver Banking info: "+claim.getReceiverBankingInfo());
    }
    public void displayClaimStatus(Claim claim){
        System.out.println("Current Status" + claim.getStatus());
    }
    public Claim displayClaimCreationForm(){
        //Map<String,DynamicAttributeType> claimForm = new HashMap<>();
        ClaimBuilder claimBuilder = new ClaimBuilder();
        Claim newClaim;
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Claim creation form");
        System.out.println();

        System.out.println("Enter claim ID: ");
        String claimID;
        IDChecks IDChecks = new IDChecks();
        do{claimID = scanner.nextLine();
            if(IDChecks.claimIDCheck(claimID) != null){
            claimBuilder.setID(scanner.nextLine());
            break;
        }else{
            System.out.println("Input does not follow format of f-10 numbers");
        }
        }while (IDChecks.customerIDCheck(claimID) == null);
        System.out.println("Enter claim date: ");
        System.out.println("Enter claim day,month, and year in dd/mm/yyyy format:  ");
        String claimDateString = scanner.nextLine();
        DateWrapper claimDate = new DateWrapper();
        claimBuilder.setClaimDate(claimDate.dateCreate(claimDateString));

        System.out.println("Enter insured Person name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter insured person ID: ");
        String customerID = scanner.nextLine();
        /*
        * There is nothing yet to Store a customer
        * */
        System.out.println("Enter card number: ");
        claimBuilder.setCardNumber(scanner.nextLine());
        //String cardNumber = scanner.nextLine();

        System.out.println("Enter exam day,month, and year in dd/mm/yyyy format:  ");
        String examDateString = scanner.nextLine();
        DateWrapper examDate = new DateWrapper();
        claimBuilder.setExamDate(claimDate.dateCreate(examDateString));

        System.out.println("Enter documents: ");
        String documents = scanner.nextLine();
        /*
        * Other regex are yet to be implemented
        * */
        System.out.println("Enter claim amount: ");
        claimBuilder.setClaimAmount(scanner.nextDouble());

        //double claimAmount =
        System.out.println("Enter claim status: ");
        claimBuilder.setStatus(Status.NEW);
        //claimForm.put(STATUS,new StatusTypeAttribute(Status.NEW));

        System.out.println("Enter receiver Banking info ");
        System.out.println("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        //new ReceiverBankingInfo(bankName,name,number);

        claimBuilder.setBankingInfo(bankName,name,number);
        return newClaim = claimBuilder.build();
    }

    public Customer displayCustomerCreationForm(){
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Customer creation form");
        System.out.println();

        System.out.println("Enter customer full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter customer ID: ");
        String ID = scanner.nextLine();

        System.out.println("Enter customer type (Policy holder or Dependent): ");
        String customerType = scanner.nextLine();
        Customer newCustomer = customerFactory.createCustomer(customerType);

        if (newCustomer == null) throw new AssertionError("This customer object is null");//prevent crashing from null exception error
        newCustomer.setCustomerID(ID);
        newCustomer.setFullName(fullName);
        return newCustomer;
    }

    public InsuranceCard insuranceCardCreationForm(){
        Scanner scanner = DataInput.getDataInput().getScanner();

        System.out.println("New insurance card form ");
        System.out.println();
        System.out.println("Enter card ID: ");
        String cardID = scanner.nextLine();
        System.out.println("Enter Policy Owner: ");
        String policyOwner = scanner.nextLine();
        System.out.println("Enter expiration date in dd/mm/yyyy format: ");
        String expirationDateString = scanner.nextLine();
        DateWrapper expirationDate = new DateWrapper();
        Date dateFormatExpirationDate = expirationDate.dateCreate(expirationDateString);

        System.out.println("Enter card holder name: ");
        String cardHolderName = scanner.nextLine();
        System.out.println("Enter card holder ID: ");
        String cardHolderID;
        IDChecks IDChecks = new IDChecks();
        do{ cardHolderID = scanner.nextLine();
            if(IDChecks.claimIDCheck(cardHolderID) != null){
                break;
            }else{
                System.out.println("Input does not follow format of f-10 numbers");
            }
        }while ((IDChecks.customerIDCheck(cardHolderID) == null));

        InsuranceCard newCard = new InsuranceCard();
        newCard.setCardID(cardID);
        newCard.setExpirationDate(dateFormatExpirationDate);
        newCard.setPolicyOwner(policyOwner);
        return newCard;
    }
    public void displayOneCustomer(Customer customer){
        System.out.println("Customer name: "+customer.getFullName());
        System.out.println("Customer ID: "+customer.getCustomerID());
        System.out.println("Customer card : "+customer.getInsuranceCard().getCardID());
        if(customer instanceof PolicyHolder){
        System.out.println("Customer type: Policy holder");
        System.out.println("Customer dependents");

        }else if(customer instanceof Dependent){
            System.out.println("Customer type: dependent");
            System.out.println("Depend on ");
            System.out.println("ID: "+((Dependent) customer).getDependOn().getCustomerID());
            System.out.println("Full name: "+((Dependent) customer).getDependOn().getFullName());
        }
        customer.getAll();
    }
    public  void displayInsuranceCard(InsuranceCard insuranceCard){
        System.out.println("Card ID"+insuranceCard.getCardID());
        System.out.println("Card holder ID:"+insuranceCard.getCardHolder().getCustomerID());
        System.out.println("Card holder name:"+insuranceCard.getCardHolder().getFullName());
        System.out.println("Policy Owner:  "+insuranceCard.getPolicyOwner());
        System.out.println("Card expiration date: "+insuranceCard.getExpirationDate());
    }
    public void updateClaim(){}
    public void

    public void displayMainMenu() {
        System.out.println("Enter 1,2, or 3 to choose a function: ");
        System.out.println("1. Manage claim");
        System.out.println("2. Manage " +
                "customer");
        System.out.println("Type 'exit' to leave the program ");
    }
    public String createNewFileMenu(){
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Create a new file: ");
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        return fileName;
    }
    public void manageClaimMenu(){
        System.out.println("Manage claim menu");
        System.out.println();
        System.out.println("1: Show all existing claims");
        System.out.println("2: File new claim");
        System.out.println("3: View a specific claim");
        System.out.println("4 View whose does a claim belongs");
        System.out.println("5. Update a claim");
        System.out.println("Type 'exit' to leave the program ");
    }
    public void manageCustomerMenu(){
        System.out.println("Manage customer menu");
        System.out.println();
        System.out.println("1. shows all customers' info");
        System.out.println("2. shows a specific customer info");
        System.out.println("3. Register new customer");
        System.out.println("4. Delete a customer");
        System.out.println("5. Update a customer claim ");
        System.out.println("6. get a claim of customer");
        System.out.println("7. get  all claim of a customer");
        System.out.println("8. delete a claim of a customer");
    }
    public void manageInsuranceCardMenu(){
        System.out.println("Manage insurance card menu");
        System.out.println();
        System.out.println("1. shows all cards' info");
        System.out.println("2. shows a specific card info");
    }


}
