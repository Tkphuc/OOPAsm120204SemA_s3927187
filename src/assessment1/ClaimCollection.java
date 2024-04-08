package assessment1;
/**
 * @author <Tran Kiem Phuc - s3927187>
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ClaimCollection implements Collection {
    private List<Claim> claimList = new ArrayList<>();
    private int currentItem;

    public ClaimCollection(){}
    public ClaimCollection(List<Claim> claimList) {
        this.claimList = claimList;
        this.currentItem =0;
    }

    public List<Claim> getList() {
        return claimList;
    }
    public void add(Claim claim){
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

    public void sortCollection(){
        claimList.sort(Comparator.comparing(Claim::getClaimID));
        //Sort ID lexicographically
    }
}
