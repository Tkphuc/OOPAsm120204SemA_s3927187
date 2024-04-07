package assessment1;
//https://www.w3schools.com/java/java_files_read.asp
//https://stackoverflow.com/questions/4388054/java-how-to-fix-the-unchecked-cast-warning
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Claim claim;
    private Customer customer;

    private InsuranceCard insuranceCard;
    private ConsoleView consoleView;

    public Controller(Claim claim, Customer customer, InsuranceCard insuranceCard, ConsoleView consoleView) {
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
        InsuranceCard insuranceCard1 = createInsuranceCard();
        newCustomer = consoleView.displayCustomerCreationForm();
        newCustomer.setInsuranceCard(insuranceCard);
        insuranceCard1.setCardHolder(newCustomer);
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
    public List<Customer> readCustomerFile(String fileName) throws Exception{
        /*
        File myFile = new File(fileName + ".txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))){
            String nextLine;
            while ((nextLine = reader.readLine()) != null)
            {

            }
        }catch (IOException e){
            System.err.printf("% file not found\n",myFile);
        }*/
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName+".txt"));
        List<Customer> customers = ((List<Customer>)in.readObject());
        in.close();
        return customers;
    }
    public List<Claim> readClaimFile(String fileName) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName+".txt"));
        List<Claim> claims = ((List<Claim>)in.readObject());
        in.close();
        return claims;
    }
    public List<InsuranceCard> readInsuranceCardFile(String fileName) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName+".txt"));
        List<InsuranceCard> cards = ((List<InsuranceCard>)in.readObject());
        in.close();
        return cards;
    }
    public void writeCustomerFile(String fileName,List<Customer> customers)throws Exception{
        /*
        File file = new File(fileName+".txt");
        try(
        FileOutputStream fileOutput = new FileOutputStream(fileName,true);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);){
        objectOutput.writeObject(object);}
        catch (IOException e){
            System.err.printf("Error write to file\n");
        }*/
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName+".txt"));
        out.writeObject(customers);
        out.close();
    }
    public void writeClaimFile(String fileName,List<Claim> claims)throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName+".txt"));
        out.writeObject(claims);
        out.close();
    }
    public void writeInsuranceCardToFile(String fileName,List<InsuranceCard> cards)throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName+".txt"));
        out.writeObject(cards);
        out.close();
    }
    public void eventLoop(){
        String answer;
        Scanner scanner = DataInput.getDataInput().getScanner();
        do {
            consoleView.displayMainMenu();
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                consoleView.manageClaimMenu();
                answer = scanner.nextLine();
                do{
                switch (answer){
                    case "1":
                        answer = scanner.nextLine();

                        //read from claim store file
                        //if such claim exist display claim
                        //else say that claim does not exist
                        consoleView.displayOneClaim();
                        break;
                    case "2":
                        Claim newClaim;
                        newClaim = consoleView.displayClaimCreationForm();
                        //store claim to file
                        //If claim exist then nice error message
                        break;
                    case "3":
                        consoleView.displayAllClaim();
                        break;
                    case "4":
                        answer = scanner.nextLine();
                        //input claim ID
                        //Return name and ID of claim owner
                        //consoleView.searchClaimOwner;
                        break;
                    case "5":
                        //input claim ID.
                        //Re-enter info as needed
                        //set new info to claim or create new claim to replace the old one
                        //consoleView.updateClaim();
                        break;
                    case "exit":
                        //exit the switch cases
                        break;
                    default:
                        System.out.println("Invalid input");
                        }
                }while(answer.equalsIgnoreCase("exit"));
            } else if (answer.equals("2")) {
                consoleView.manageCustomerMenu();
                answer = scanner.nextLine();
                do{
                    switch (answer){
                        case "1":
                            //consoleView.displayCustomers();
                            //Show all customers
                            break;
                        case "2":
                            //consoleView.displayOneCustomer();
                            //Show info of one customer
                            break;
                        case "3":
                            consoleView.displayCustomerCreationForm();
                            break;
                        case "4":
                            //consoleView.updateACustomer();
                            break;
                        case "5":
                            //consoleView.deleteACustomer();
                            break;
                        case "exit":
                            //exit the switch cases
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                }while(answer.equalsIgnoreCase("exit"));

            } else if (answer.equals("3")) {
                consoleView.manageInsuranceCardMenu();
                answer = scanner.nextLine();
                do{
                    switch (answer){
                        case "1":
                            //consoleView.displayInsuranceCards();
                            break;
                        case "2":
                            //

                            //consoleView.displayAnInsuranceCard();
                            break;
                        case "exit":
                            //exit the switch cases
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                }while(!answer.equalsIgnoreCase("exit"));
            }else if(answer.equalsIgnoreCase("exit")){
                System.out.println("Goodbye");
            }
        }while (!answer.equalsIgnoreCase("exit"));

    }

}
