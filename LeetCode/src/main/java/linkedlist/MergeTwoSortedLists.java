package linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(5)));
        ListNode list2 = new ListNode(2,
                new ListNode(3,
                        new ListNode(4)));

        ListNode merged = mergeTwoLists(list1, list2);
        merged.print();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list2 == null) {
                return list1;
            } else return list2;
        }
        ListNode merged;
        if (list1.val <= list2.val) {
            merged = list1;
            list1 = list1.next;
        } else {
            merged = list2;
            list2 = list2.next;
        }
        if (list1 == null || list2 == null) {
            if (list1 == null) {
                merged.next = list2;
            } else {
                merged.next = list1;
            }
            return merged;
        }
        merged.next = mergeTwoLists(list1, list2);
        return merged;
    }


}
