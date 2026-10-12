/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = lists.length;
        if(lists.length==0){
            return null;
        }
        if(n<=1){
            return lists[0];
        }
        for(int i=0;i<n;i++){
            if(lists[i]==null){
                continue;
            }
            ListNode temp = lists[i];
            while(temp!=null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(pq.poll());
        ListNode temp1 = head;
        while(!pq.isEmpty()){
            ListNode temp = new ListNode(pq.poll());
            temp1.next = temp;
            temp1 = temp;
        }
        return head;
        
    }
}