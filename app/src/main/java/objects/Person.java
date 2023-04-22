package objects;

public class Person {

    protected int ID;

    public String name;
    public String phoneNumber;

    public Person (String a, String b){
        this.name = a;
        this.phoneNumber = b;
    }

    public Person (int ID, String a, String b){
        this.name = a;
        this.phoneNumber = b;
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
        return phoneNumber;
    }

}
