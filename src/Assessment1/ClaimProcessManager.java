package Assessment1;

public interface ClaimProcessManager {
    public boolean add(Claim claim);
    public void update(Claim claim);
    public boolean delete(Claim claim);




    public Claim getOne(String claimID);
    public  void getAll();
    /*
    Return type of the methods to be decided later
    * */

}
