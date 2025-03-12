package algo.easy;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1,new ListNode(3, new ListNode(4, null)));

        ListNode result = mergeTwoLists(list1, list2);
        /*
        *   L1 -> [1,2,4], L2 -> [1,3,4] -> [1, mergeTwoLists([2,4], [1,3,4])] -> [1,1,2,3,4,4]
            L1 -> [1,3,4], L2 -> [2,4]  -> [1, mergeTwoLists([4], [3,4])] -> [1,2,3,4,4]
            L1 -> [2,4], L2 -> [3,4] -> [2, mergeTwoLists([4], [3,4])] -> [2,3,4,4]
            L1 -> [3,4], L2 -> [4] -> [3, mergeTwoLists([4], [4])] -> [3,4,4]
            L1 -> [4], L2 -> [4] -> [4, mergeTwoLists([null], [4])] -> [4,4]
            L1 -> [null], L2 -> [4] -> [4]
        * */
        System.out.println(result);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) return (list1 != null ? list1 : list2);

        if(list1.val>list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode temp = this;
        String s = "[" + temp.val;
        while (temp.next != null) {
            s = s + "," + temp.next.val;
            temp = temp.next;
        }
        return s + "]";
    }
}
