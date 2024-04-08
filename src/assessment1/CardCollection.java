package assessment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CardCollection implements Iterator {
    private List<InsuranceCard> insuranceCardList = new ArrayList<>();
    private  int currentItem;

    public CardCollection() {
    }

    public CardCollection(List<InsuranceCard> insuranceCardList ){
        this.insuranceCardList = insuranceCardList;
        this.currentItem = 0;
    }

    public List<InsuranceCard> getInsuranceCardList() {
        return insuranceCardList;
    }
    public void addCard(InsuranceCard card){
        insuranceCardList.add(card);
    }

    @Override
    public boolean hasNext() {
        if(currentItem >= insuranceCardList.size()){
            currentItem = 0;
            return false;
        }
        return true;
    }

    @Override
    public InsuranceCard next() {
        return insuranceCardList.get(currentItem++);
    }
    public void sortCollection(){
        insuranceCardList.sort(Comparator.comparing(InsuranceCard::getCardID));
        //Sort ID lexicographically
    }
}
