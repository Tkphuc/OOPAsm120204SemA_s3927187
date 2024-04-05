package assessment1;

public interface ClaimProcessManager {
    boolean add(Claim claim);
    void update(Claim claim);
    boolean delete(Claim claim);




    Claim getOne(String claimID);
    Claim getAll();
    /*
    Return type of the methods to be decided later
    * */

}
