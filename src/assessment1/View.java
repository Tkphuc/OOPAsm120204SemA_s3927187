package assessment1;

import java.io.File;

public abstract class View {
    /*
    public static final String CLAIM_ID = "CLAIM_ID";
    public static final String CLAIM_DATE = "CLAIM_DATE";
    public static final String INSURED_PERSON = "INSURED PERSON";
    public static final String CARD_NUMBER = "CARD_NUMBER";
    public static final String EXAM_DATE = "EXAM_DATE";
    public static final String DOCUMENTS = "DOCUMENTS";
    public static final String CLAIM_AMOUNT = "CLAIM_AMOUNT";
    public static final String STATUS = "STATUS";
    public static final String RECEIVER_BANKING_INFO = "RECEIVER_BANKING_INFO";

    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String FULL_NAME = "FULL_NAME";
    public static final String INSURANCE_CARD = "INSURANCE CARD";
    public static final String CLAIM_LIST = "CLAIM_LIST";

    public static final String DEPENDENTS_LIST = "DEPENDENT_LISTS";

    public static final String DEPEND_ON = "DEPEND_ON";*/

    public abstract void displayClaim(Claim claim);
    public abstract Claim displayClaimCreationForm();
    public abstract void displayMainMenu();
    public abstract Customer displayCustomerCreationForm();
    public abstract InsuranceCard insuranceCardCreationForm();
    public abstract String createNewFileMenu();

}
