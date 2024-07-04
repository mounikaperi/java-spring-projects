class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode curr = head, temp = head.next, lastCheck = null;
        while (curr.next != null) {
            sum = 0;
            while (temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            curr.val = sum;
            curr.next = temp;
            lastCheck = curr;
            curr = curr.next;
            temp = curr.next;
        }
        lastCheck.next = null;
        return head;
    }  
}
