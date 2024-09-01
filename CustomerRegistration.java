import java.util.Stack;

class Customer{
    String name;
    String mobileNumber;
    String email;
    String city;
    int age;

Customer(String name, String mobileNumber,String email,String city,int age){
        this.name=name;
        this.mobileNumber=mobileNumber;
        this.email=email;
        this.city=city;
        this.age=age;

    }
    public String toString(){
        return "Customer{name='" + name + "', mobile='" + mobileNumber + "', email='" + email + "', city='" + city + "', age='" + age + "}";
    }

}
public class CustomerRegistration {
    Stack <Customer>customerStack= new Stack<>();

    public void registerCustomer(String name, String mobileNumber,String email,String city,int age){
        try { 
            if(age<18 || age>60){
              throw new IllegalArgumentException("Age should be between 18 and 60");
            }
            else{
                Customer customer = new Customer(name, mobileNumber, email, city, age);
                customerStack.push(customer);
                System.out.println("Successfully Registered Customer "+customer);

            }
        } catch (IllegalArgumentException e) {
           System.out.println("An Error Occured "+e.getMessage());
        }

    }
    public void displayAllCustomer(){
        for (Customer customer : customerStack) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByName(String name){
        for(Customer customer:customerStack){
            if(customer.name.equals(name)){
                return customer;
            }
        }
        return null;
    }

    
}
