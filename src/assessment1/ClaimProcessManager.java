package assessment1;

import java.util.List;

public interface ClaimProcessManager {
    boolean add(Claim claim);
    void update(Claim claim);
    boolean delete(Claim claim);




    Claim getOne(String claimID);
    List<Claim> getAll();
    /*
    Return type of the methods to be decided later
    * */

}
