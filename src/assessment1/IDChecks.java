package assessment1;

import java.util.regex.Pattern;

public class IDChecks {
    //private String inputString;
    //regex pattern for claimid regex pattern for claimid [f]*\d{10}
    private final Pattern CLAIM_ID_PATTERN = Pattern.compile("[f]*\\d{10}");
    private final Pattern CUSTOMER_ID_PATTERN = Pattern.compile("[c]*\\d{7}");
    private final Pattern CARD_ID_PATTERN = Pattern.compile("\\d{10}");
    public IDChecks() {
    }
    public String claimIDCheck(String inputString){
        if(CLAIM_ID_PATTERN.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }

    public String customerIDCheck(String inputString){
        if(CUSTOMER_ID_PATTERN.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }
    public String cardIDCheck(String inputString){
        if(CARD_ID_PATTERN.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }

}
