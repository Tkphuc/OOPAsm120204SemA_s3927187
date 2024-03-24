package Assessment1;

import java.util.*;

public class Claim {
    private String claimID;
    private Date claimDate;
    private Customer insuredPerson;
    private String CardNumber;
    private Date examDate;
    private List<String> Documents;
    private float claimAmount;
    private Status status;
    private ReceiverBankingInfo receiverBankingInfo;
    public Claim (){}

    public Claim(String claimID, Date claimDate, Customer insuredPerson, String cardNumber, Date examDate, List<String> documents, float claimAmount, Status status, ReceiverBankingInfo receiverBankingInfo) {
        this.claimID = claimID;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        CardNumber = cardNumber;
        this.examDate = examDate;
        Documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }
}
