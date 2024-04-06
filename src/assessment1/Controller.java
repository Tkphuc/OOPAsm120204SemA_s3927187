package assessment1;
//https://www.w3schools.com/java/java_files_read.asp
import java.io.*;
import java.util.Scanner;

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
    public File createNewFile(){
       String fileName = consoleView.createNewFileMenu();
    File newFile = new File(fileName+".txt");
        try {
        if (newFile.createNewFile()) {
            System.out.println(newFile.getName()+"is created");
        }else{
            System.out.println("File already exists");
        }
    }catch (IOException e){
        System.out.println("Error creating file");
            }
        return newFile;
    }
    public void readFromFileToConsole(String fileName){
        File myFile = new File(fileName + ".txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))){
            String nextLine;
            while ((nextLine = reader.readLine()) != null)
            {
                System.out.println(nextLine);
            }
        }catch (IOException e){
            System.err.printf("% file not found\n",myFile);
        }
    }
    public void writeObjectToFile(){

    }


}
