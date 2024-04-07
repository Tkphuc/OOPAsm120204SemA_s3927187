package assessment1;
import java.util.Comparator;
import java.util.List;
public class ClaimList implements Iterator {
    private List<Claim> claimList;
    private int currentItem;

    public ClaimList(){}
    public ClaimList(List<Claim> claimList) {
        this.claimList = claimList;
        this.currentItem =0;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }
    public void addClaim(Claim claim){
        claimList.add(claim);
    }
    @Override
    public boolean hasNext() {

        if(currentItem >= claimList.size()){
            currentItem = 0;
            return false;
        }
        return true;
    }
    public  Claim next(){
        return claimList.get(currentItem++);
    }

    public void sortClaimCollection(){
        claimList.sort(Comparator.comparing(Claim::getClaimID));
        //Sort ID lexicographically
    }
}
