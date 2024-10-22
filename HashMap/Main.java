package HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();

        ArrayList<String> p1 = new ArrayList<>();
        p1.add("1234892837");
        p1.add("2927372910");
        contactBook.createContact("Alex", p1);

        ArrayList<String> p2 = new ArrayList<>();
        p2.add("9273929192");
        ArrayList<String> e1 = new ArrayList<>();
        e1.add("myemail@gmail.com");
        contactBook.createContact("Simon", p2, e1);

        contactBook.createContact("Jane");

        ArrayList<String> p3 = new ArrayList<>();
        p3.add("2938717191");
        p3.add("2937163739");
        ArrayList<String> e2 = new ArrayList<>();
        e2.add("iiiriieii@gmail.com");
        e2.add("ueuowuowwu@gmail.com");
        contactBook.createContact("Katherine", p3, e2);

        ArrayList<String> e3 = new ArrayList<>();
        e3.add("hdhdjshhsjsj@gmail.com");
        contactBook.createContact("Dean", null, e3);

        contactBook.print();
        System.out.println("----------/----------");

        contactBook.addInfoToContact("Dean", "94948292929", "fjjdjdjej@gmail.com");
        contactBook.addEmailToContact("Alex", "skabdhyssj@gmail.com");
        contactBook.addPhoneToContact("Simon", "828929171919");
        contactBook.print();
        System.out.println("----------/----------");

        contactBook.removeContact("Jane");
        contactBook.removeContactByPhone("2937163739");
        contactBook.print();
        System.out.println("----------/----------");

        System.out.println(contactBook.findContact("Simon"));
        System.out.println(contactBook.findContactByPhone("1234892837"));
    }
}
