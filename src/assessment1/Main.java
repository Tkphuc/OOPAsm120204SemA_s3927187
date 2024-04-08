package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Customer customer1 = customerFactory.createCustomer("Policy Holder");
        Customer customer2 = customerFactory.createCustomer("dependent");
        customer1.setFullName("ABC");
        customer1.setCustomerID("1234f");
        customer2.setFullName("CDE");
        customer2.setCustomerID("EFG");
        Date date1 = new Date(2015,11,18);
        Date date2 = new Date(2014,11,18);
        Date date3 = new Date(2014,12,18);
        //
        // ReceiverBankingInfo receiverBankingInfo1 = new ReceiverBankingInfo("AVC","ABC","1234A");
        InsuranceCard card1 = new InsuranceCard("123",customer1,"Company",date1);
        customer1.setInsuranceCard(card1);
        ClaimBuilder claimBuilder = new ClaimBuilder();
        Claim claim1 =
                claimBuilder.setID("134").setClaimAmount(123).setCardNumber(card1.getCardID()).
                        setClaimDate(date2).setExamDate(date3).setBankingInfo("134","322","943").setStatus(Status.NEW).build();

        customer1.add(claim1);
        System.out.println(customer1.getOne("134").toString());
        System.out.println(customer1.getAll());
        customer1.delete(claim1);
        System.out.println(customer1.getAll());
        customer1.add(claim1);
        System.out.println(customer1.getAll());
        ((Dependent)customer2).setDependOn(customer1);
        BankingInfoBuilder bankingInfoBuilder = new BankingInfoBuilder();
        ReceiverBankingInfo receiverBankingInfo;
        receiverBankingInfo = bankingInfoBuilder.setBank("ABC").setName("234").setNumber("123").build();
        /*
        boolean b = ((PolicyHolder) customer1).AddDependent((Dependent)customer2);
        System.out.println(b);
        System.out.println(((PolicyHolder) customer1).hasDependent(customer2));
        System.out.println(((PolicyHolder)customer1).getDepdendent(customer2));*/
        ConsoleView consoleView = new ConsoleView();
        Controller controller = new Controller(consoleView);
        controller.eventLoop();

    }
}
