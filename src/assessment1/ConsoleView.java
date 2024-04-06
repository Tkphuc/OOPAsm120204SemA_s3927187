package assessment1;
// https://www.baeldung.com/java-hashmap-different-value-types
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
        Map<String,DynamicAttributeType> claimForm = new HashMap<>();
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Claim creation form");
        System.out.println();
        System.out.println("Enter claim ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter claim date: ");
        System.out.println("Enter claim day,month, and year in dd/mm/yyyy format:  ");
        String claimDateString = scanner.nextLine();
        DateAttributeType claimDate = new DateAttributeType();
        claimDate.dateCreate(claimDateString);
        System.out.println("Enter insured Person name: ");
        String customerName = scanner.nextLine();
        String customerID = scanner.nextLine();
        /*
        * There is nothing yet to Store a customer
        * */
        System.out.println("Enter card number: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter exam day,month, and year in dd/mm/yyyy format ");
        String examDateString = scanner.nextLine();
        DateAttributeType examDate = new DateAttributeType();
        claimDate.dateCreate(examDateString);
        System.out.println("Enter documents: ");
        String documents = scanner.nextLine();
        /*
        * Other regex are yet to be implemented
        * */
        System.out.println("Enter claim amount: ");
        double claimAmount = scanner.nextDouble();
        System.out.println("Enter claim status: ");
        claimForm.put(STATUS,new StatusTypeAttribute(Status.NEW));
        System.out.println("Enter receiver Banking info: ");
        System.out.println("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        new ReceiverBankingInfo(bankName,name,number);
        return claimForm;
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Enter 1,2, or 3 to choose a function: ");
        System.out.println("1. Manage claim");
        System.out.println("2. Track claim");
        System.out.println("3. Process claim");
    }

}
