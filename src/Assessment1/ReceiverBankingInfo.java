package Assessment1;

public class ReceiverBankingInfo {
    private String bank;
    private  String name;
    private  String number;

    public ReceiverBankingInfo(){
        bank = "Default";
        name = "Default";
        number = "Default";
    }
    public ReceiverBankingInfo(String bank, String name, String number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }
}
