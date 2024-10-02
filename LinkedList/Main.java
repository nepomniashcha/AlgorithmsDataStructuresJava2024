package LinkedList;

public class Main {
    public static void main(String[] args) {
        final ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        final ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        final ListNode list3 = new ListNode();
        final ListNode list4 = new ListNode(0);

        System.out.println(Solution.mergeTwoLists(list1, list2));
        System.out.println(Solution.mergeTwoLists(list3, list3));
        System.out.println(Solution.mergeTwoLists(list3, list4));
    }

}
