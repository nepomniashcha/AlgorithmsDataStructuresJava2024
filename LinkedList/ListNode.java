package LinkedList;

public class ListNode {
    int val = -101; // [-100; 100]
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();
        if (curr.val == -101) { return "[]"; }

        sb.append("[");
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append("]");
        
        return sb.toString();
    }
}
