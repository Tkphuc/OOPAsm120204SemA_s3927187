package assessment1;

public class BankingInfoType implements DynamicAttributeType{
    private ReceiverBankingInfo attribute;
    private BankingInfoBuilder bankingInfoBuilder;

    public BankingInfoType(ReceiverBankingInfo attribute) {
        this.attribute = attribute;
    }
    /*
    public BankingInfoType(BankingInfoBuilder bankingInfoBuilder){
        this.bankingInfoBuilder = bankingInfoBuilder;
    }*/
}
