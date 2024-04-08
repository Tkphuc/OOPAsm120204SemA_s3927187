package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 */

import java.io.*;
import java.util.List;
import java.util.Scanner;
public class Controller {

    private ConsoleView consoleView;
    public final String CUSTOMER_FILE = "customers.txt";
    public final String CARD_FILE = "cards.txt";
    public final String CLAIM_FILE = "claims.txt";

    public Controller(ConsoleView consoleView) {

        this.consoleView = consoleView;
    }
    public File createNewFile(String fileName){
        consoleView.createNewFileMenu();
        File newFile = null;
        if(fileName.equalsIgnoreCase(CUSTOMER_FILE)){
        newFile = new File(CUSTOMER_FILE);
        } else if (fileName.equalsIgnoreCase(CLAIM_FILE)) {
            newFile = new File(CLAIM_FILE);
        } else if (fileName.equalsIgnoreCase(CARD_FILE)) {
            newFile = new File(CARD_FILE);
        }
        try {
            if (newFile != null && newFile.createNewFile()) {
                System.out.println(newFile.getName() + "is created");
            }
        }catch (IOException e){
        System.out.println("Error creating file");
            }
        return newFile;
    }
    public List<Customer> readCustomerFile() throws Exception{
        @SuppressWarnings("unchecked")
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(CUSTOMER_FILE));
        List<Customer> customers = ((List<Customer>)in.readObject());
        in.close();
        return customers;
    }
    public List<Claim> readClaimFile() throws Exception{
        @SuppressWarnings("unchecked")
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(CLAIM_FILE));
        List<Claim> claims = ((List<Claim>)in.readObject());
        in.close();
        return claims;
    }
    public List<InsuranceCard> readInsuranceCardFile() throws Exception{
        @SuppressWarnings("unchecked")
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(CARD_FILE));
        List<InsuranceCard> cards = ((List<InsuranceCard>)in.readObject());
        in.close();
        return cards;
    }
    public void writeCustomerFile(List<Customer> customers)throws Exception{
        @SuppressWarnings("unchecked")
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CUSTOMER_FILE,false));
        out.writeObject(customers);
        out.close();
    }
    public void writeClaimFile(List<Claim> claims)throws Exception{
        @SuppressWarnings("unchecked")
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CLAIM_FILE,false));
        out.writeObject(claims);
        out.close();
    }
    public void writeInsuranceCardToFile(List<InsuranceCard> cards)throws Exception{
        @SuppressWarnings("unchecked")
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CARD_FILE,false));
        out.writeObject(cards);
        out.close();
    }
    public void eventLoop() throws Exception {
        String answer;
        Scanner scanner = DataInput.getDataInput().getScanner();
        IDChecks IDCheck = new IDChecks();
        do {
            consoleView.displayMainMenu();
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                consoleView.manageClaimMenu();
                answer = scanner.nextLine();
                ClaimCollection claimCollection = new ClaimCollection();
                CustomerCollection customerCollection = new CustomerCollection();
                CardCollection cardCollection = new CardCollection();
                try {
                    claimCollection = new ClaimCollection(readClaimFile());
                    customerCollection = new CustomerCollection(readCustomerFile());
                    cardCollection = new CardCollection(readInsuranceCardFile());
                } catch (Exception e) {
                    createNewFile(CUSTOMER_FILE);
                    createNewFile(CARD_FILE);
                    createNewFile(CLAIM_FILE);
                    System.err.println("New file created");
                }
                do{
                switch (answer){
                    case "1":
                        System.out.println("All claims: ");
                        while(claimCollection.hasNext()){
                            consoleView.displayOneClaim(claimCollection.next());
                        }
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
                                claimCollection.add(newClaim);}
                        }
                        if (!(earlyBreak)) {
                            try {
                                claimCollection.sortCollection();
                                writeClaimFile(claimCollection.getList());
                            } catch (Exception e) {
                                System.err.println("Cannot write to "+CLAIM_FILE);
                            }
                        }
                        break;
                    case "3":
                        do{
                            System.out.println("Enter claim ID: ");
                            answer = scanner.nextLine();
                            claimCollection.next();
                        } while (claimCollection.hasNext() &&!(claimCollection.next().getClaimID().equals(answer)));
                        Claim claimToRead = new Claim();
                        while (claimCollection.hasNext()){
                            if(claimCollection.next().getClaimID().equals(answer)){
                                claimToRead = claimCollection.next();
                            }
                        }
                        if(! (claimToRead instanceof Claim) ){
                            consoleView.displayOneClaim(claimToRead);}
                        else{System.out.println("Claim does not exist");}
                        break;
                    case "4":

                        Claim originalClaim = null;
                        Claim toUpdate = new Claim();
                        do{
                            System.out.println("Enter claim ID: ");
                            answer = scanner.nextLine();
                        } while (!(claimCollection.next().getClaimID().equals(answer)));
                        while (claimCollection.hasNext()){
                            if(claimCollection.next().getClaimID().equals(answer)){
                                originalClaim = claimCollection.next();
                            }
                        }
                        if(originalClaim != null) {
                               consoleView.displayOneClaim(originalClaim);
                               consoleView.updateClaimMenu();
                               answer = scanner.nextLine();
                               if(answer.equalsIgnoreCase("1")){
                                    consoleView.upadteDocumentsMenu();
                                    answer = scanner.nextLine();
                                    if(answer.equalsIgnoreCase("1")){
                                        System.out.println("Enter new document: ");
                                        answer = scanner.nextLine();
                                        if(!(originalClaim.getDocuments().contains(answer))){
                                            originalClaim.addDocument(answer);
                                        }else{
                                            System.out.println("documents exist or input error");
                                        }
                                    } else if (answer.equalsIgnoreCase("2")) {
                                        System.out.println("Enter document to remove: ");
                                        answer = scanner.nextLine();
                                        if(originalClaim.getDocuments().contains(answer)){
                                            originalClaim.removeDocument(answer);
                                        }else{
                                            System.out.println("Document not exists");
                                        }
                                    }else{System.out.println("Wrong input");}
                               } else if (answer.equalsIgnoreCase("2")) {
                                   System.out.println("Claim current amount: "+originalClaim.getClaimAmount());
                                   System.out.println("Enter new amount: ");
                                   double newAmount = scanner.nextDouble();
                                   if(originalClaim.getClaimAmount() != newAmount){
                                   originalClaim.setClaimAmount(newAmount);}
                               } else if (answer.equalsIgnoreCase("3")) {
                                   consoleView.updateStatusMenu();
                                   answer = scanner.nextLine();
                                   if(answer.equalsIgnoreCase("1")){
                                       originalClaim.setStatus(Status.PROCESSING);
                                   } else if (answer.equalsIgnoreCase("2")) {
                                       originalClaim.setStatus(Status.DONE);
                                   }else{System.out.println("wrong input");}
                               } else if (answer.equalsIgnoreCase("4")) {
                                    ReceiverBankingInfo newInfo;
                                    System.out.println("Create new banking info to replace the old: ");
                                    newInfo = consoleView.bankingInfoCreation();
                                    originalClaim.setReceiverBankingInfo(newInfo);
                               }
                               claimCollection.getList().remove(originalClaim);
                               toUpdate = originalClaim;
                               claimCollection.add(toUpdate);
                               while(customerCollection.hasNext()){
                                   if(customerCollection.next().getClaimsList().contains(originalClaim)){
                                       customerCollection.next().getClaimsList().remove(originalClaim);
                                       customerCollection.next().getClaimsList().add(toUpdate);
                                   }
                               }
                               writeClaimFile(claimCollection.getList());
                               writeCustomerFile(customerCollection.getCustomerList());
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
                CardCollection cardCollection = new CardCollection();
                ClaimCollection claimCollection = new ClaimCollection();
                try {
                    customerCollection = new CustomerCollection(readCustomerFile());
                    cardCollection = new CardCollection(readInsuranceCardFile());
                    claimCollection = new ClaimCollection(readClaimFile());
                } catch (Exception e) {
                    createNewFile(CUSTOMER_FILE);
                    createNewFile(CARD_FILE);
                    createNewFile(CLAIM_FILE);
                    System.err.println("No existing file,create new file");
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
                                customerCollection.next();
                            } while (customerCollection.hasNext() && !(customerCollection.next().getCustomerID().equals(answer)));
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
                            while(customerCollection.hasNext() && customerCollection !=null){
                                if(newCustomer.equals(customerCollection.next())){
                                    System.out.println("Customer already exist.");
                                    earlyBreak = true;
                                    break;
                                }else if(customerCollection == null){System.out.println("Customer list is empty");}
                            }
                            if(!(earlyBreak)){
                                InsuranceCard insuranceCard1 = consoleView.displayInsuranceCardCreation();
                                newCustomer.setInsuranceCard(insuranceCard1);
                                customerCollection.add(newCustomer);
                                cardCollection.add(insuranceCard1);}
                                try {
                                    customerCollection.sortCollection();
                                    cardCollection.sortCollection();
                                    writeCustomerFile(customerCollection.getCustomerList());
                                    writeInsuranceCardToFile(cardCollection.getList());
                                } catch (Exception e) {
                                    System.err.println("Error write to file");
                                    //throw new RuntimeException(e);
                                }

                            break;
                        case "4":
                            Customer toDelete = null;
                            do {
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                                while (customerCollection.hasNext()) {
                                    if (customerCollection.next().getCustomerID().equals(answer)) {
                                        toDelete = customerCollection.next();
                                    } else {
                                        System.out.println("Input error");
                                    }
                                }
                            }while (!(customerCollection.next().getCustomerID().equals(answer)));
                            if(toDelete != null) {
                                do {
                                    answer = scanner.nextLine();
                                    if (answer.equalsIgnoreCase("Y")) {
                                        consoleView.deleteACustomer();
                                        claimCollection.getList().remove(toDelete.getClaimsList());
                                        cardCollection.getList().remove(toDelete.getInsuranceCard());
                                        customerCollection.getCustomerList().remove(toDelete);
                                        writeClaimFile(claimCollection.getList());
                                        writeInsuranceCardToFile(cardCollection.getList());
                                        writeCustomerFile(customerCollection.getCustomerList());
                                    } else if (answer.equalsIgnoreCase("N")) {
                                        System.out.println("Confirm no delete");
                                    } else {
                                        System.out.println("Wrong input: Y/N please.");
                                    }
                                }while (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"));
                            }
                            break;
                        case "6":
                            ClaimCollection claimsOfCustomer = new ClaimCollection();
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
                            Customer customerGetAllClaim = null;
                            do{
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                                customerCollection.next();
                            } while (customerCollection.hasNext() && !(customerCollection.next().getCustomerID().equals(answer)));
                            while(customerCollection.hasNext()){
                                if(customerCollection.next().getCustomerID().equals(answer)){
                                    customerGetAllClaim = customerCollection.next();
                                }
                            }
                            assert customerGetAllClaim != null;
                            ClaimCollection claimsOfCustomer2 = new ClaimCollection(customerGetAllClaim.getAll());
                            while (claimsOfCustomer2.hasNext()){
                                consoleView.displayOneClaim(claimsOfCustomer2.next());
                            }
                            break;
                        case "8":
                            //delete customer's one claim
                            Customer customerGetDeleteClaim = null;

                            do{
                                System.out.println("Enter customer ID: ");
                                answer = scanner.nextLine();
                                customerCollection.next();
                            } while (customerCollection.hasNext() && !(customerCollection.next().getCustomerID().equals(answer)));
                            while(customerCollection.hasNext()){
                                if(customerCollection.next().getCustomerID().equals(answer)){
                                    customerGetDeleteClaim = customerCollection.next();
                                }
                            }
                            assert customerGetDeleteClaim != null;
                            claimsOfCustomer = new ClaimCollection(customerGetDeleteClaim.getAll());
                            System.out.println("Enter id of a customer's claim: ");
                            answer = scanner.nextLine();
                            while (claimsOfCustomer.hasNext()){
                                if(claimsOfCustomer.next().getClaimID().equals(answer)){
                                    customerGetDeleteClaim.delete(claimsOfCustomer.next());
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
                    cardCollection = new CardCollection(readInsuranceCardFile());
                } catch (Exception e) {
                    createNewFile(CARD_FILE);

                }
                do{
                    switch (answer){
                        case "1":
                            do{
                                System.out.println("Enter 3card ID: ");
                                answer = scanner.nextLine();
                                cardCollection.next();
                            }while (cardCollection.hasNext() && !(cardCollection.next().getCardID().equals(answer)));
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
        //writeClaimFile("claim.txt");
    }

}
