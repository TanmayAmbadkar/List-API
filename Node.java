public class Node<Type>
{
    Node<Type> next;
    Type data;
    Node()
    {
        this.next=null;
        this.data=null;
    }
    Node(Type o)
    {
        this.next=null;
        this.data=o;
    }
    Node(Type o, Node m)
    {
        this.next=m;
        this.data=o;
    }
}