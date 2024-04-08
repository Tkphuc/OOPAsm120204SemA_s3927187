
package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 */
public class customerFactory {
    public static Customer createCustomer(String customerType){
        if(customerType.equalsIgnoreCase("policy holder")){
            return  new PolicyHolder();
        }
        else if(customerType.equalsIgnoreCase("dependent")){
            return  new Dependent();
        }
        else{return  null;}
    }
}
