public class LinkedList<Type> implements List<Type>
{
    int size;
    Node<Type> FirstNode;
    Node<Type> LastNode;
    LinkedList()
    {
        size=0;
        FirstNode=null;
        LastNode=null;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void add(Type x)
    {
        if(size==0)
        {
            FirstNode=new<Type> Node(x);
            LastNode=FirstNode;
            size++;
        }
        else
        {
            Node<Type> Temp=new<Type> Node(x);
            LastNode.next=Temp;
            LastNode=Temp;
            size++;
        }
    }
    public void add(Type x, int pos)
    {
        if(pos<=size && pos>=0)
        {
            if(pos==0)
            {
                Node temp=new Node(x,FirstNode);
                FirstNode=temp;
            }
            else if(pos==size)
            {
                Node temp=new Node(x);
                LastNode.next=temp;
                LastNode=temp;
            }
            else
            {
                Node temp=FirstNode;
                Type t=null;
                for(int i=0;i<pos;i++)
                {
                    temp=temp.next;
                }
                Node tm=new Node(x,temp.next);
                temp.next=tm;
            }
             size++;
        }
        else
            throw new IndexOutOfBoundsException("List Index out of range");
    }
    public int search(Type x)
    {
        Node<Type> temp=FirstNode;
        int pos=-1;
        for(int i=0;i<size;i++)
        {
            if(temp.data==x)
            {
                pos=i;
                break;
            }
            temp=temp.next;
        }
        return(pos);
    }
    public Type getElementAt(int pos)
    {
        if(pos>=0&&pos<size)
        {
            Node<Type> temp=FirstNode;
            for(int i=0;i<pos;i++)
            {
                temp=temp.next;
            }
            return(temp.data);
        }
        else
            throw new IndexOutOfBoundsException("List Index out of range");
    }
    public void traverse()
    {
        Node CurrentNode=FirstNode;
        System.out.print("["+CurrentNode.data);
        for(int i=1;i<size;i++)
        {
            CurrentNode=CurrentNode.next;
            System.out.print(", "+CurrentNode.data);
        }
        System.out.println("]");
    }
    public void remove(Type x)
    {
        int pos=search(x);
        if(pos!=-1)
        {
            if(pos==0)
                FirstNode=FirstNode.next;
            else if(pos==size-1)
            {
                Node CurrentNode=FirstNode;
                for(int i=0;i<size-1;i++)
                    CurrentNode=CurrentNode.next;
                CurrentNode.next=null;
            }
            else
            {
                Node CurrentNode=FirstNode;
                for(int i=0;i<pos;i++)
                CurrentNode=CurrentNode.next;
                CurrentNode.next=CurrentNode.next.next;
            }
            size--;
        }
        else
            
            throw new IndexOutOfBoundsException("List Index out of range");
    }
    public void reverse()
    {
        Node<Type>PrevNode=null;
        Node<Type>CurrentNode=FirstNode;
        Node<Type>NextNode=null;
        while(CurrentNode!=null)
        {
            NextNode=CurrentNode.next;
            CurrentNode.next=PrevNode;
            PrevNode=CurrentNode;
            CurrentNode=NextNode;
        }
        FirstNode=PrevNode;
    }
}
