package linkedlist;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        listNode.print();

        reverseVIAConstructor(listNode).print();
        reverse(listNode).print();
    }

    public static ListNode reverse(ListNode head) {
       ListNode current = head;
       ListNode next;
       ListNode prev = null;
       while (current != null) {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       return prev;
    }

    public static ListNode reverseVIAConstructor(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            reversed = new ListNode(head.val, reversed);
            head = head.next;
        }
        return reversed;
    }
}
