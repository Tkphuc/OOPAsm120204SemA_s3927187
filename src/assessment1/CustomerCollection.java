package assessment1;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CustomerCollection implements Iterator {
    private List<Customer> customerList;
    private  int currentItem;

    public CustomerCollection() {
    }
    public CustomerCollection(List<Customer> customerList) {
        this.customerList = customerList;
        this.currentItem = 0;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public boolean hasNext() {
        if(currentItem >= customerList.size()){
            currentItem = 0;
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return customerList.get(currentItem++);
    }
    public void sortCustomerCollection(){
        customerList.sort(Comparator.comparing(Customer::getCustomerID));
        //Sort ID lexicographically
    }
}
