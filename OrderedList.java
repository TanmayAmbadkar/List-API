import java.util.*;
public class OrderedList implements List
{
    protected Object OL[];
    protected Integer buffer, size;
    OrderedList(int cap)
    {
        OL=new Object[cap];
        buffer=cap;
        size=0;
    }
    OrderedList()
    {
        this(10);
    }
    public void add(Object O)
    {
        if(size==0)
            OL[0]=O;
        else
        {
            if(size==buffer)
            buffer*=2;
            int pos=-1;
            Object temp[]=new Object[buffer];
            for(int i=0;i<size;i++)
            {
                if((Integer)O<=(Integer)OL[i])
                {
                    pos=i;
                    break;
                }
            }
            if(pos!=-1)
            {
                for(int i=0;i<pos;i++)
                    temp[i]=OL[i];
                temp[pos]=O;
                for(int i=pos;i<size;i++)
                    temp[i+1]=OL[i];
                OL=temp;
            }
            else
            {
                for(int i=0;i<size;i++)
                    temp[i]=OL[i];
                temp[size]=O;
                OL=temp;
            }
        }
        size++;
    }
    public void traverse()
    {
        System.out.print("[");
        System.out.print(OL[0]);
        for(Integer i=1;i<size;i++)
            System.out.print(", "+OL[i]);
        System.out.println("]");
    }
    public int search(Object O)
    {
        int f=0,l=size;
        int m=(f+l)/2;
        while(f<=l)
        {
            if(OL[m]==O)
            {
                return m;
            }
            else if((int)O<(int)OL[m])
            l=m-1;
            else
            f=m+1;
            m=(f+l)/2;
        }
        return -1;
    }
    public void remove(Object O)
    {
        int x=search(O);
        if(x!=-1)
        {
        for(int i=x;i<size-1;i++)
            OL[i]=OL[i+1];
        size--;
        }
        else
            throw new NoSuchElementException("Element does not exist in OrderedList");
    }
    public int size()
    {
        return(size);
    }
    public boolean isEmpty()
    {
        return size==0;
    }
        public Object getElementAt(int pos)
    {
        if(pos<0 || pos>=size)
            throw new IndexOutOfBoundsException("List Index out of range");
        else
            return(OL[pos]);
    }
}