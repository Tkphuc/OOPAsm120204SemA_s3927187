package assessment1;
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

}
