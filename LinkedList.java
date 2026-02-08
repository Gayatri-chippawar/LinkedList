package Linked_List;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static  Node head;
    public static  Node tail;
    public static  int size;

    public void addFirst(int data){

        //step1:create new node
        Node newNode = new Node(data);
        size++;

        //Empty linkedList
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2:next node poiting to head
        newNode.next = head;

        //step3:head = newNode
        head = newNode;
    }
    public void addLast(int data){

        //step1:create new node
        Node newNode = new Node(data);
        size++;
        //Empty linkedList
        if(head == null){
            head = tail = newNode;
            return;
        }
//        newNode.next = null; already as a new node

        //step2:next of tail pointing to newnode
        tail.next = newNode;

        //step3:tail = newNode
        tail = newNode;
    }

    public  void printList(){//O(n)
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addMiddle(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        int i=0;
        while (i<(idx-1)){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("Linked List is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int i=0;
        int val = tail.data;
        Node temp = head;
        while (i<(size-2)){//arr ka last idx = size-1 hence 2nd last size-2
            temp = temp.next;
            i++;
        }
        size--;
        temp.next = null;
        tail = temp;
        return val;
    }


    public static void main(String[] args) {
            LinkedList ll = new LinkedList();
            ll.head = new Node(1);
            ll.head.next = new Node(2);
        ll.addFirst(1);//1
        ll.addLast(5);
        ll.addMiddle(2,7);
        System.out.println("Data of head that is removed : "+ll.removeFirst());
        System.out.println("Data of tail that is removed : "+ll.removeLast());
        ll.printList();
        System.out.println("Size of List : "+ll.size);

    }
}
