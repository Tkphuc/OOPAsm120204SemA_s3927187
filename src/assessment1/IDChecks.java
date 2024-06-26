package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 *
 */
import java.util.regex.Pattern;
// Regex idea: https://viettuts.vn/java/su-dung-regex-trong-java

public class IDChecks {
    //private String inputString;
    //regex pattern for claimid regex pattern for claimid [f]*\d{10}
    private final Pattern CLAIM_ID_PATTERN = Pattern.compile("[f]*\\d{10}");
    private final Pattern CUSTOMER_ID_PATTERN = Pattern.compile("[c]*\\d{7}");
    private final Pattern CARD_ID_PATTERN = Pattern.compile("\\d{10}");
    private final Pattern DOCUMENT_NAME_PATTERN = Pattern.compile("[f]*\\d{10}+_+\\d{10}+_+[a-zA-Z0-9]");
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
    public String documentNameCheck(String inputString){
        if(DOCUMENT_NAME_PATTERN.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }

}
