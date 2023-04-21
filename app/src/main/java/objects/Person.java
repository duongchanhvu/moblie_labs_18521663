package objects;

public class Person {

    protected int ID;

    protected String name;
    protected String phoneNumber;

    public Person (String name, String phone){

    }

    public Person (int ID, String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}
