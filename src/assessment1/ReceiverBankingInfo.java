package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 *
 */
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
