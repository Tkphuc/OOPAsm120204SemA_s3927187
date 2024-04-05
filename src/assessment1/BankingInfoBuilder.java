package assessment1;

public class BankingInfoBuilder {
    ReceiverBankingInfo receiverBankingInfo = new ReceiverBankingInfo();
    public BankingInfoBuilder setBank(String bank){
        receiverBankingInfo.setBank(bank);
        return this;
    }
    public BankingInfoBuilder setName(String name){
        receiverBankingInfo.setName(name);
        return this;
    }
    public BankingInfoBuilder setNumber(String number){
        receiverBankingInfo.setNumber(number);
        return this;
    }
    public ReceiverBankingInfo build(){return receiverBankingInfo;}
}
