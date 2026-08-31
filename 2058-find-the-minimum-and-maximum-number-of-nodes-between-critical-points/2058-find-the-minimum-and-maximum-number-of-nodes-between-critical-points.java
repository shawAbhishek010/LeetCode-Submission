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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp= head.next;
        ListNode pr = head;
        int maxD = 0;
        int minD =Integer.MAX_VALUE;;
        ListNode marker1 = null;
        ListNode marker2 = null;
        ListNode marker3 = null;
        int criticalPoint =0;
        int arr[] = new int[2];
        while(temp.next!=null){
            if((temp.val>pr.val&&temp.val>temp.next.val)||(temp.val<pr.val&&temp.val<temp.next.val)){
                if(marker1 == null)marker1 = temp;
                 marker2= temp;
                if(marker3!=null){
                    int newDistance = distance(marker3, temp);
                    minD = Math.min(minD, newDistance);
                }
                criticalPoint++; 
                marker3 = temp; 
            }
            temp = temp.next;
            pr = pr.next;
        }
        maxD = distance(marker1,marker2);
                arr[0]=minD;
                arr[1]=maxD;
       if(criticalPoint<2){
        arr[0]=-1;
        arr[1] =-1;
        return arr;
       } 
       return arr;
    }
    public int distance(ListNode a, ListNode b){
        int count = 0;
        while(a!=b){
            a= a.next;
            count ++;
        }
        return count;

    }
}