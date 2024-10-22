package HashMap;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ContactBook {
    private HashMap<String, Contact> map = new HashMap<>();

    public void createContact(String name, ArrayList<String> phones, ArrayList<String> emails) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("This field is obligatory! Please, enter the name.");
        }
        Contact contact = new Contact(name, phones, emails);
        map.put(name, contact);
    }
    public void createContact(String name, ArrayList<String> phones) {
        createContact(name, phones, null);
    }
    public void createContact(String name) {
        createContact(name, null);
    }

    public void addInfoToContact(String name, String phone, String email) {
        if (map.containsKey(name)) {
            Contact existingContact = map.get(name);

            if (existingContact.getNumber() == null) {
                existingContact.setNumber(new ArrayList<String>());
            }
            if (existingContact.getEmail() == null) {
                existingContact.setEmail(new ArrayList<String>());
            }

            if (phone != null && !phone.equals("")) {
                existingContact.addPhone(phone);
            }
            if (email != null && !email.equals("")) {
                existingContact.addEmail(email);
            }
        }
    }
    public void addPhoneToContact(String name, String phone) {
        addInfoToContact(name, phone, "");
    }
    public void addEmailToContact(String name, String email) {
        addInfoToContact(name, "", email);
    }

    public void removeContact(String name) {
        Contact contact = this.map.get(name);
        if (this.map.containsValue(contact) && contact != null) {
            this.map.remove(name);
        }
    }
    public void removeContactByPhone(String num) {
        Set<Map.Entry<String, Contact>> set = this.map.entrySet();
        for (Entry<String, Contact> e : set) {
            if (e.getValue().getNumber().contains(num)) {
                this.map.remove(e.getKey());
                break;
            }
        }
    }

    public Contact findContact(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }
    public Contact findContactByPhone(String num) {
        for (Contact contact : map.values()) {
            if (contact.getNumber().contains(num)) {
                return contact;
            }
        }
        return null;
    }

    public void print() {
        for (Contact contact : map.values()) {
            System.out.println(contact);
        }
    }

}
