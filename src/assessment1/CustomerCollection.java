package assessment1;

import java.util.*;

public class CustomerCollection implements Collection {
    private List<Customer> customerList = new ArrayList<>();
    private  int currentItem;

    public CustomerCollection() {}
    public CustomerCollection(List<Customer> customerList) {
        this.customerList = customerList;
        this.currentItem = 0;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void add(Customer customer){
        customerList.add(customer);
    }
    @Override
    public boolean hasNext() {
        if(customerList != null){
        if(currentItem >= customerList.size()){
            currentItem = 0;
            return false;
        }
        return true;} return false;


    }

    @Override
    public Customer next() {
        return customerList.get(currentItem++);
    }
    public void sortCollection(){
        customerList.sort(Comparator.comparing(Customer::getCustomerID));
        //Sort ID lexicographically
    }
}
