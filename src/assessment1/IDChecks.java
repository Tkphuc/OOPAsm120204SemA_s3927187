package assessment1;

import java.util.regex.Pattern;

public class IDChecks {
    //private String inputString;
    //regex pattern for claimid regex pattern for claimid [f]*\d{10}
    private final Pattern claimIDpattern = Pattern.compile("[f]*\\d{10}");
    private final Pattern customerIDPattern = Pattern.compile("[c]*\\d{7}");
    private final Pattern cardIDPattern = Pattern.compile("\\d{10}");
    public IDChecks() {
    }
    public String claimIDCheck(String inputString){
        if(claimIDpattern.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }

    public String customerIDCheck(String inputString){
        if(customerIDPattern.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }
    public String cardIDCheck(String inputString){
        if(cardIDPattern.matcher(inputString).matches()){
            return inputString;
        }else{
            return null;
        }
    }

}
