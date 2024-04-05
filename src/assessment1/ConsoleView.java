package assessment1;
// https://www.baeldung.com/java-hashmap-different-value-types
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView extends View{

    public void displayClaim(Claim claim){
        System.out.println("All info of the claim");
        System.out.println();
        System.out.println("Claim ID: "+claim.getClaimID());
        System.out.println("Claim date: "+claim.getClaimDate());
        System.out.println("Insured Person: "+claim.getInsuredPerson());
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
    public Map<String,DynamicAttributeType> displayClaimCreationForm(){
        Map<String,DynamicAttributeType> claimForm = new HashMap<>();

        System.out.println("Claim creation form");
        System.out.println();
        System.out.println("Enter claim ID: ");
        claimForm.put(CLAIM_ID)
        System.out.println("Enter claim date: ");
        System.out.println("Enter insured Person: ");
        System.out.println("Enter card number: ");
        System.out.println("Enter exam date: ");
        System.out.println("Enter documents: ");
        System.out.println("Enter claim amount: ");
        System.out.println("Enter claim status: ");
        System.out.println("Enter receiver Banking info: ");

    }

    @Override
    public void displayMainMenu() {
        System.out.println("Enter 1,2, or 3 to choose a function: ");
        System.out.println("1. Manage claim");
        System.out.println("2. Track claim");
        System.out.println("3. Process claim");
    }

}
