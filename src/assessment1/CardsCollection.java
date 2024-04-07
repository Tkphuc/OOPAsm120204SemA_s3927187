package assessment1;

import java.util.List;

public class CardsCollection implements Iterator {
    private List<InsuranceCard> insuranceCardList;
    private  int currentItem;

    public CardsCollection() {
    }

    public CardsCollection(List<InsuranceCard> insuranceCardList ){
        this.insuranceCardList = insuranceCardList;
        this.currentItem = 0;
    }

    public List<InsuranceCard> getInsuranceCardList() {
        return insuranceCardList;
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
}
