package assessment1;
// https://www.baeldung.com/java-hashmap-different-value-types
//https://stackoverflow.com/questions/24863185/what-is-an-assertionerror-in-which-case-should-i-throw-it-from-my-own-code
//https://www.w3schools.com/java/java_files_create.asp
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ConsoleView extends View{

    public void displayClaim(Claim claim){
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
        claimBuilder.setID(scanner.nextLine());

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

        System.out.println("Enter exam day,month, and year in dd/mm/yyyy format ");
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
    @Override
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
    @Override
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
        String cardHolderID = scanner.nextLine();

        InsuranceCard newCard = new InsuranceCard();
        newCard.setCardID(cardID);
        newCard.setExpirationDate(dateFormatExpirationDate);
        newCard.setPolicyOwner(policyOwner);
        return newCard;
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Enter 1,2, or 3 to choose a function: ");
        System.out.println("1. Manage claim");
        System.out.println("2. Track claim");
        System.out.println("3. Process claim");
    }
    public String createNewFileMenu(){
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Create a new file: ");
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        return fileName;
    }

}
