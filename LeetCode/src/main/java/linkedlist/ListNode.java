package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode head = this;
        System.out.print(head.val + " ");
        while (head.next != null) {
            System.out.print(head.next.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
