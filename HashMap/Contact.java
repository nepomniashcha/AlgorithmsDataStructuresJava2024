package HashMap;

import java.util.ArrayList;

public class Contact {
    private final String name;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> emails;

    public Contact(String name, ArrayList<String> phoneNumber, ArrayList<String> email) {
        this.name = name;
        this.phoneNumbers = phoneNumber;
        this.emails = email;
    }
    public Contact(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }
    public Contact(String name, ArrayList<String> phoneNumber) {
        this(name, phoneNumber, new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }
    public ArrayList<String> getNumber() {
        return this.phoneNumbers;
    }
    public void setNumber(ArrayList<String> aList) {
        phoneNumbers = aList;
    }
    public ArrayList<String> getEmail() {
        return this.emails;
    }
    public void setEmail(ArrayList<String> aList) {
        emails = aList;
    }

    public void addPhone(String phoneNumber) {
        if (!this.phoneNumbers.contains(phoneNumber)) {
            this.phoneNumbers.add(phoneNumber);
        }
    }
    public void addEmail(String email) {
        if (!this.emails.contains(email)) {
            this.emails.add(email);
        }
    }

    public void removePhone(String phone) {
        if (this.phoneNumbers.contains(phone)) {
            this.phoneNumbers.remove(phone);
        }
    }
    public void removeEmail(String email) {
        if (this.emails.contains(email)) {
            this.emails.remove(email);
        }
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" + 
            "phone_numbers: \n" + phoneNumbers + "\n" + 
            "emails: \n" + emails + "\n";
    }
}
