import java.util.*;

public class ArrayList {
    public static void main(String[] args) {
        ArrayList<String> colours = new ArrayList<>();
        
        colours.add("blue");
        colours.add("red");
        colours.add("yellow");
        colours.add("pink");
        colours.add("black");
        colours.add("white");
        colours.add("brown");
        System.out.println(colours + "\n");
        
        
        System.out.println("Iterate through arraylist:");
        // a
        System.out.print("For loop: ");
        for (int i = 0; i < colours.size(); i++) {
            System.out.print(colours.get(i) + " ");
        }
        System.out.println();
        // b
        System.out.print("While loop: ");
        int c = 0;
        while (c < colours.size()) {
            System.out.print(colours.get(c) + " ");
            c++;
        }
        System.out.println();
        // c
        System.out.print("For each loop: ");
        for (String i : colours) {
            System.out.print(i + " ");
        }
        System.out.println();
        // d
        System.out.print("Lambda expression: ");
        colours.forEach(colour->System.out.print(colour + " "));
        System.out.println();
        // e
        System.out.print("Iterator: ");
        Iterator it = colours.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
        
        
        System.out.println("Insert element at first position:");
        colours.add(0, "orange");
        System.out.println(colours + "\n");
        
        
        System.out.println("Retrieve element:");
        // a
        colours.remove(6);
        System.out.println(colours);
        // b
        colours.remove("red");
        System.out.println(colours);
        // c
        ArrayList<String> tempColours = new ArrayList<>();
        tempColours.add("blue");
        tempColours.add("brown");
        colours.removeAll(tempColours);
        System.out.println(colours + "\n");
        
        
        System.out.println("Update specific array element by given one:");
        colours.set(0, "gold");
        System.out.println(colours + "\n");
        
        
        System.out.println("Remove the third element:");
        colours.remove(2);
        System.out.println(colours + "\n");
        
        
        System.out.println("Search the element:");
        if (colours.contains("yellow")) {
            System.out.println("The index: " + colours.indexOf("yellow") + "\n");
        }
        
        
        System.out.println("Sort the arraylist:");
        Collections.sort(colours); 
        System.out.println(colours + "\n");
        
        
        System.out.println("Copy one arraylist into another:");
        ArrayList<String> copyOfArrayList = new ArrayList<String>();
        ArrayList<String> newCopyOfArrayList = new ArrayList<String>(colours);
        copyOfArrayList.addAll(colours);
        System.out.println(copyOfArrayList);
        System.out.println(newCopyOfArrayList +"\n");
        
        
        System.out.println("Reverse elements:");
        Collections.sort(colours, Collections.reverseOrder());
        System.out.println(colours +"\n");
        
        
        System.out.println("Compare two arraylists:");
        // element-wise comparison
        System.out.println(colours.equals(copyOfArrayList));
        // checks if one list is a subset of another
        System.out.println(newCopyOfArrayList.containsAll(colours));
        // intersection of two lists
        ArrayList<String> array = new ArrayList<>();
        array.add("gold");
        array.add("pink");
        array.add("green");
        array.add("black");
        array.add("grey");
        System.out.println(array.retainAll(colours) + "\n");
        
        
        System.out.println("Empty the arraylist and check it:");
        colours.clear();
        System.out.println(colours.isEmpty() + "\n");
        
        
        // Increase size of the arraylist
        array.ensureCapacity(15);
        // Trim the capacity of the arraylist to its size
        array.trimToSize();
        
    }
}
