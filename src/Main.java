import java.util.Scanner;

class Node{
    int value;
    Node next;
    Node prev;
    public Node(int value)
    {
        this.value=value;
    }
}
class Doublelinkedlist {
    Node head;
    Node tail;
    int length;

    void append(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev=tail;
            tail = newNode;
        }
        length++;
    }

    Node removeFromLast(){
        if(length ==0)
        {
            return null;
        }
        Node temp = tail;
        if(length ==1)
        {
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length ==0)
        {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length ++;
    }

    Node removeFromFirst()
    {
        if(length == 0)
        {
            return null;
        }
        Node temp = head;
        if(length ==1)
        {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length --;
        return temp;
    }

    Node getNode(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        Node temp = head;
        if(index<length/2)
        {
            for(int i=0;i<index;i++)
            {
                temp = temp.next;
            }
        }
        else {
            temp = tail;
            for(int i = length-1;i>index;i--)
            {
                temp = temp.prev;
            }
        }
        return temp;
    }

    boolean set(int index,int value)
    {
        Node temp = getNode(index);
        if(temp!=null)
        {
            temp.value = value;
            return true;
        }
        return false;
    }

    boolean insertAtIndex(int index,int value)
    {
        if(index<0 || index>length)
        {
            return false;
        }
        if(index==0)
        {
            prepend(value);
            return true;
        }
        if(index==length)
        {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = getNode(index-1);
        Node after = before.next;
        before.next = newNode;
        newNode.prev = before;
        after.prev = newNode;
        newNode.next = after;
        length ++;
        return true;
    }

    Node removeAtIndex(int index)
    {
        if(index<0 || index>= length)
        {
            return null;
        }
        if(index == 0)
        {
            return removeFromFirst();
        }
        if(index==length-1)
        {
            return removeFromLast();
        }
        Node temp = getNode(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }
    void print()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Doublelinkedlist doublelinkedlist = new Doublelinkedlist();
        System.out.println("Enter the value(enter -1 to finish): ");
        while (true)
        {
            int num = scanner.nextInt();
            if(num==-1)
            {
                break;
            }
            doublelinkedlist.append(num);

        }
        int index;
        int value;
        System.out.println("1-Prepend\n" +
                "2-Remove from last\n" +
                "3-Remove from first\n" +
                "4-Get Node\n" +
                "5-Update Node\n" +
                "6-Insert at an index\n" +
                "7-Remove at an index\n" +
                "8-print\n" +
                "9-Length\n" +
                "0-Exit");
        int input = scanner.nextInt();
        while(input!=0){
            switch(input) {
                case 1:
                    System.out.println("Enter a value Prepend:");
                    value = scanner.nextInt();
                    doublelinkedlist.prepend(value);
                    System.out.println("Prepend is done");
                    break;
                case 2:
                    System.out.println(doublelinkedlist.removeFromLast().value);
                    System.out.println("Remove From Last is done is done");
                    break;
                case 3:
                    System.out.println(doublelinkedlist.removeFromFirst().value);
                    System.out.println("Remove From First is done is done");
                    break;
                case 4:
                    System.out.println("Enter an index : ");
                    index = scanner.nextInt();
                    System.out.println(doublelinkedlist.getNode(index).value);
                    System.out.println("Get is done");
                    break;
                case 5:
                    System.out.println("Enter an index:");
                    index = scanner.nextInt();
                    System.out.println("Enter value :");
                    value = scanner.nextInt();
                    doublelinkedlist.set(index,value);
                    System.out.println("Set is done");
                    break;
                case 6:
                    System.out.println("Enter an index and element to insert an index");
                    index = scanner.nextInt();
                    System.out.println("Enter value :");
                    value = scanner.nextInt();
                    doublelinkedlist.insertAtIndex(index,value);
                    System.out.println("Index the element  is done");
                    break;
                case 7:
                    System.out.println("Enter an index to remove at an index");
                    index = scanner.nextInt();
                    doublelinkedlist.removeAtIndex(index);
                    System.out.println("remove at index is done");
                    break;
                case 8:
                    System.out.println("node in doubleLinked :");
                    doublelinkedlist.print();
                    break;
                case 9:
                    System.out.println("The length of the double linked list:"+doublelinkedlist.length);
                    break;

                default:
                    System.out.println("Invalid input.");
            }
            System.out.println("1-Prepend\n" +
                    "2-Remove from last\n" +
                    "3-Remove from first\n" +
                    "4-Get Node\n" +
                    "5-Update Node\n" +
                    "6-Insert at an index\n" +
                    "7-Remove at an index\n" +
                    "8-print\n" +
                    "9-Length\n" +
                    "0-Exit");
            input = scanner.nextInt();
        }
    }
}