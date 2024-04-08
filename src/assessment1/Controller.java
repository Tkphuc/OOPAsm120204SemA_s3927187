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
         newClaim = consoleView.displayClaimCreation();
         return newClaim;
    }
    public Customer createCustomer(){
        Customer newCustomer;
        InsuranceCard insuranceCard1 = createInsuranceCard();
        newCustomer = consoleView.displayCustomerCreation();
        newCustomer.setInsuranceCard(insuranceCard);
        insuranceCard1.setCardHolder(newCustomer);
        return newCustomer;
    }
    public void deleteACustomer(Customer customer) throws Exception{
        readClaimFile("customer.txt");
    }
    public InsuranceCard createInsuranceCard(){
        InsuranceCard newInsuranceCard;
        newInsuranceCard = consoleView.displayInsuranceCardCreation();
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
        IDChecks IDCheck = new IDChecks();
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
                        do{
                            System.out.println("Enter claim ID: ");
                            answer = scanner.nextLine();
                        } while (!(claimCollection.next().getClaimID().equals(answer)));
                        Claim claimToRead = null;
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
                        newClaim = consoleView.displayClaimCreation();
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
                        Claim toUpdate = null;
                        do{
                            System.out.println("Enter claim ID: ");
                            answer = scanner.nextLine();
                        } while (!(claimCollection.next().getClaimID().equals(answer)));
                        while (claimCollection.hasNext()){
                            if(claimCollection.next().getClaimID().equals(answer)){
                                toUpdate = claimCollection.next();
                            }
                        }
                        if(toUpdate != null) {
                               consoleView.displayOneClaim(toUpdate);
                               consoleView.updateClaimMenu();
                               answer = scanner.nextLine();
                               if(answer.equalsIgnoreCase("1")){
                                    consoleView.upadteDocumentsMenu();
                                    answer = scanner.nextLine();
                                    if(answer.equalsIgnoreCase("1")){
                                        System.out.println("Enter new document: ");
                                        answer = scanner.nextLine();
                                        if(!(toUpdate.getDocuments().contains(answer))){
                                            toUpdate.addDocument(answer);
                                        }else{
                                            System.out.println("documents exist or input error");
                                        }
                                    } else if (answer.equalsIgnoreCase("2")) {
                                        System.out.println("Enter document to remove: ");
                                        answer = scanner.nextLine();
                                        if(toUpdate.getDocuments().contains(answer)){
                                            toUpdate.removeDocument(answer);
                                        }else{
                                            System.out.println("Document not exists");
                                        }
                                    }else{System.out.println("Wromg input");}
                               } else if (answer.equalsIgnoreCase("2")) {
                                   System.out.println("Claim current amount: "+toUpdate.getClaimAmount());
                                   System.out.println("Enter new amount: ");
                                   double newAmount = scanner.nextDouble();
                                   if(toUpdate.getClaimAmount() != newAmount){
                                   toUpdate.setClaimAmount(newAmount);}
                               } else if (answer.equalsIgnoreCase("3")) {
                                   consoleView.updateStatusMenu();
                                   answer = scanner.nextLine();
                                   if(answer.equalsIgnoreCase("1")){
                                       toUpdate.setStatus(Status.PROCESSING);
                                   } else if (answer.equalsIgnoreCase("2")) {
                                       toUpdate.setStatus(Status.DONE);
                                   }else{System.out.println("wrong input");}
                               } else if (answer.equalsIgnoreCase("4")) {
                                    ReceiverBankingInfo newInfo;
                                    System.out.println("Create new banking info to replace the old: ");
                                    newInfo = consoleView.bankingInfoCreation();
                                    toUpdate.setReceiverBankingInfo(newInfo);
                               }
                        }
                        //update a claim;
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
                            Customer customerToRead = null;
                            do{
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                            } while (!(customerCollection.next().getCustomerID().equals(answer)));
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
                            Customer newCustomer = consoleView.displayCustomerCreation();
                            while(customerCollection.hasNext()){
                                if(newCustomer.equals(customerCollection.next())){
                                    System.out.println("Customer already exist.");
                                     InsuranceCard insuranceCard1 = consoleView.displayInsuranceCardCreation();
                                     newCustomer.setInsuranceCard(insuranceCard1);
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
                            Customer toDelete = null;
                            do{
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                                while (customerCollection.hasNext()){
                                    if(customerCollection.next().getCustomerID().equals(answer)){
                                        toDelete = customerCollection.next();
                                        //Delete claim from file claim.txt
                                    }else{
                                        System.out.println("Input error");
                                    }
                            }while (!(customerCollection.next().getCustomerID().equals(answer)));


                            }
                            if(toDelete != null) {
                                do {
                                    answer = scanner.nextLine();
                                    if (answer.equalsIgnoreCase("Y")) {
                                        consoleView.deleteACustomer();
                                    } else if (answer.equalsIgnoreCase("N")) {
                                        System.out.println("Confirm no delete");
                                    } else {
                                        System.out.println("Wrong input: Y/N please.");
                                    }
                                }while (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"));
                            }
                            break;
                        case "6":
                            ClaimCollection claimsOfCustomer = new ClaimCollection(customer.getAll());
                            System.out.println("Enter id of a customer's claim: ");
                            answer = scanner.nextLine();
                            while (claimsOfCustomer.hasNext()){
                                if(claimsOfCustomer.next().getClaimID().equals(answer)){
                                    consoleView.displayOneClaim(claimsOfCustomer.next());
                                }else{
                                    System.out.println("Claim does not exist");
                                }
                            }
                        case "7":
                            claimsOfCustomer = new ClaimCollection(customer.getAll());
                            while (claimsOfCustomer.hasNext()){
                                consoleView.displayOneClaim(claimsOfCustomer.next());
                            }
                            break;
                        case "8":
                            claimsOfCustomer = new ClaimCollection(customer.getAll());
                            System.out.println("Enter id of a customer's claim: ");
                            answer = scanner.nextLine();
                            while (claimsOfCustomer.hasNext()){
                                if(claimsOfCustomer.next().getClaimID().equals(answer)){
                                    customer.delete(claimsOfCustomer.next());
                                }else{
                                    System.out.println("Claim does not exist");
                                }
                            }
                            break;
                        case "exit":
                            System.out.println("Exit customer manager.");
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
