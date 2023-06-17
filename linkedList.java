public class linkedList {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    Node temp = head;
    public void insert(int data){
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = null;
        if(head == null){
        head = newNode;
        }
        newNode.next = null;
        while(temp.next !=null){
            temp = temp.next;
            temp.next = newNode;
        }
}
    public void insertAtIndex(int index, int data){
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void print(){
        while(temp!=null){
            System.out.println(" "+temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static void main(String[] args) {
        linkedList l = new linkedList();
        l.insert(20);
        l.insert(40);
        l.insert(100);
        l.insert(11);
        l.insert(8);
        l.insertAtIndex(2, 90);
        l.print();
    }
}
