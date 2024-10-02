package LinkedList;

public class Solution {
    public static String mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        final ListNode head = list;

        if (list1.val != -101 && list2.val != -101) { 
            ListNode temp = new ListNode();
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    temp.val = list1.val;
                    list1 = list1.next;
                } else {
                    temp.val = list2.val;
                    list2 = list2.next;
                }
                list.next = new ListNode(temp.val);
                list = list.next;
            }

            if (list1 != null) {
                list.next = list1;
            } else if (list2 != null) {
                list.next = list2;
            }
        } else {
            if (list1.val != -101) {
                list.next = list1;
            } else if (list2.val != -101) {
                list.next = list2;
            }
        }

        return head.next != null ? head.next.toString() : "[]";
    }
}
