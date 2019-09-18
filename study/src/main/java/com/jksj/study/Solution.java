package com.jksj.study;

/**
 * @author: yachen.shen
 * @Date 2019/9/4 11:32
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(null, "1");
        ListNode listNode2 = new ListNode(listNode1, "2");
        ListNode listNode3 = new ListNode(listNode2, "2");
        ListNode listNode4 = new ListNode(listNode3, "1");
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(listNode4);
        System.out.println(palindrome);

    }
}

class ListNode{
    public ListNode next;
    public String val;

    public ListNode(ListNode next, String val) {
        this.next = next;
        this.val = val;
    }
}


