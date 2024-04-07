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
    public void updateAClaimOfCustomer(Customer customer){
        Claim claimToUpdate = new Claim();
        customer.update(claimToUpdate);
    }
    public void getAllClaimOfCustomer(Customer customer){
        customer.getAll();
    }
    public void deleteAClaimOfCustomer(Customer customer){
        customer.delete();
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
                ClaimCollection claimCollection;
                try {
                    claimCollection = new ClaimCollection( readClaimFile("claim.txt"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                do{
                switch (answer){
                    case "3":
                        //System.out.println("Enter file name: ");
                        //answer = scanner.nextLine();

                        IDChecks IDChecks = new IDChecks();
                        do{ System.out.println("Enter claim ID: ");
                            answer = scanner.nextLine();
                            if(IDChecks.claimIDCheck(answer) != null){
                                break;
                            }else{
                                System.out.println("Input does not follow format of f-10 numbers");
                            }
                        }while ((IDChecks.customerIDCheck(answer) == null));
                        Claim claimToRead = new Claim();
                        while (claimCollection.hasNext()){
                            if(claimCollection.next().getClaimID().equals(answer)){
                                claimToRead = claimCollection.next();
                            }
                        }
                        if(claimToRead != null){
                        consoleView.displayOneClaim(claimToRead);}
                        else{System.out.println("Claim does not exist");}
                        break;
                    case "2":
                        boolean earlyBreak = false;
                        Claim newClaim;
                        newClaim = consoleView.displayClaimCreationForm();
                        while(claimCollection.hasNext()){
                            if(newClaim.equals(claimCollection.next())){
                                System.out.println("Claim already exist.");
                                earlyBreak = true;
                                break;
                            }else {
                                claimCollection.addClaim(newClaim);}
                        }
                        if (!(earlyBreak)) {
                            try {
                                writeClaimFile("claim.txt", claimCollection.getClaimList());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        break;
                    case "1":
                        System.out.println("All claims: ");
                        while(claimCollection.hasNext()){
                            consoleView.displayOneClaim(claimCollection.next());
                        }
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
                }while(!answer.equalsIgnoreCase("exit"));
            } else if (answer.equals("2")) {
                consoleView.manageCustomerMenu();
                answer = scanner.nextLine();
                CustomerCollection customerCollection = new CustomerCollection();
                try {
                    customerCollection = new CustomerCollection(readCustomerFile("customer.txt"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                do{
                    switch (answer){
                        case "1":
                            System.out.println("All customer: ");
                            while (customerCollection.hasNext()){
                                consoleView.displayOneCustomer(customerCollection.next());
                            }
                            //Show all customers
                            break;
                        case "2":
                            IDChecks IDCheck = new IDChecks();
                            do{
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                                if(IDCheck.customerIDCheck(answer) != null){
                                    break;
                                }else{
                                    System.out.println("Input does not follow format of f-10 number");
                                }
                            } while ((IDCheck.customerIDCheck(answer) == null));
                            Customer customerToRead = null;
                            while(customerCollection.hasNext()){
                                if(customerCollection.next().getCustomerID().equals(answer)){
                                    customerToRead = customerCollection.next();
                                }
                            }
                            if(customerToRead != null){
                            consoleView.displayOneCustomer(customerToRead);}
                            else {System.out.println("No such customer exist");}
                            break;
                        case "3":
                            boolean earlyBreak = false;
                            Customer newCustomer = consoleView.displayCustomerCreationForm();
                            while(customerCollection.hasNext()){
                                if(newCustomer.equals(customerCollection.next())){
                                    System.out.println("Claim already exist.");
                                    earlyBreak = true;
                                    break;
                                }else {customerCollection.addCustomer(newCustomer);}
                            }
                            if(!(earlyBreak)){
                                try {
                                    writeCustomerFile("customer.txt", customerCollection.getCustomerList());
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
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
                }while(!answer.equalsIgnoreCase("exit"));

            } else if (answer.equals("3")) {
                consoleView.manageInsuranceCardMenu();
                answer = scanner.nextLine();
                CardCollection cardCollection = new CardCollection();
                try {
                    cardCollection = new CardCollection(readInsuranceCardFile("InsuranceCard.txt"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                IDChecks IDCheck = new IDChecks();
                do{
                    switch (answer){
                        case "1":
                            do{
                                System.out.println("Enter insurance card ID: ");
                                answer = scanner.nextLine();
                                if(IDCheck.cardIDCheck(answer) != null){
                                    break;
                                }else{
                                    System.out.println("Input does not follow format of 10 numbers");
                                }
                            }while ((IDCheck.cardIDCheck(answer)==null));
                            InsuranceCard cardToRead = new InsuranceCard();
                            while(cardCollection.hasNext()){
                                if(cardCollection.next().getCardID().equals(answer)){
                                    cardToRead = cardCollection.next();
                                }
                            }
                            consoleView.displayInsuranceCard(cardToRead);
                            break;
                        case "2":
                            System.out.println("All cards: ");
                            while (cardCollection.hasNext()){
                            consoleView.displayInsuranceCard(cardCollection.next());}
                            break;
                        case "exit":
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
