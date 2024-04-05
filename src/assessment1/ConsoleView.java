package assessment1;

public class ConsoleView extends View{

    public void displayClaim(Claim claim){
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
    public void displayClaimCreationForm(){
        System.out.println("Enter claim ID: ");
        System.out.println("Enter claim date: ");
        System.out.println("Enter insured Person: ");
        System.out.println("Enter card number: ");
        System.out.println("Enter exam date: ");
        System.out.println("Enter documents: ");
        System.out.println("Enter claim amount: ");
        System.out.println("Enter claim status: ");
        System.out.println("Enter receiver Banking info: ");

    }

}
