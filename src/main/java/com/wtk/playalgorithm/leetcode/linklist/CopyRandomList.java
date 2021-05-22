package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: WentaoKing
 * created on: 5/20/21
 * description: 剑指Offer-35：复杂链表的复制
 * 复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
class CopyRandomList {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //1.创建一份新链表
        createNewList(head);
        //2.新链表连接到random指针
        linkRandom(head);
        //3.拆分两链表，取出复制链表部分
        return getCopyLinkList(head);
    }

    private void createNewList(Node head) {
        Node node = head;
        while (node != null){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
    }

    private void linkRandom(Node head) {
        Node node = head;
        while (node != null){
            if (node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    private Node getCopyLinkList(Node head) {
        Node node = head.next;
        Node pre = head;
        Node copyNode = head.next;
        while (node.next != null){
            pre.next = pre.next.next;
            node.next = node.next.next;
            pre = pre.next;
            node = node.next;
        }
        //单独处理原链表尾节点
        pre.next = null;
        //返回新链表头节点
        return copyNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
