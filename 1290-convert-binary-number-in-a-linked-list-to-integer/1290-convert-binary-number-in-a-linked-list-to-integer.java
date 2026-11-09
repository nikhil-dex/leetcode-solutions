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
    int res;
    int val;
    public int getDecimalValue(ListNode head) {
        res = 0;
        bin(head,0);
        return res;
    }

    void bin(ListNode head,int i){
        if(head==null){
            val = i-1;
            return;
        }
        bin(head.next,i+1);
        res+=head.val*(int)Math.pow(2,val-i);
        return;

        
    }
}