import java.util.*;
import java.io.*;
public class ArrayList implements List
{
    Integer buffer;
    Integer size;
    Object arr[];
    
    ArrayList(Integer b)
    {
        buffer=b;
        size=0;
        arr=new Object[buffer];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void add(Object x)
    {
        if(size==buffer)
        {
            Object arr2[]=new Object[buffer+1];
            arr2=Arrays.copyOf(arr,buffer+1);
            arr2[size]=x;
            arr=arr2;
            size++;
            buffer+=1;
        }
        else
        {
            arr[size]=x;
            size+=1;
        }
    }
    public void add(Object x, Integer pos)
    {
        try
        {
            if(pos>size)
            throw new BoundsException();
            Object arr2[]=new Object[buffer+1];
            Integer c=0;
            for(Integer i=0;i<pos;i++)
                arr2[i]=arr[i];
            arr2[pos]=x;
            c=pos+1;
            for(Integer i=pos;i<size;i++)
                arr2[c++]=arr[i];
            size++;
            arr=arr2;
            buffer++;
        }
        catch(BoundsException E)
        {
            E.print();
        }
    }
    public void traverse()
    {
        System.out.print("[");
        System.out.print(arr[0]);
        for(Integer i=1;i<size;i++)
        System.out.print(", "+arr[i]);
        System.out.println("]");
    }
    public int size()
    {
        return size;
    }
    public int search(Object O)
    {
        int pos=-1;
        for(int i=0;i<size;i++)
        {
            if(O.equals(arr[i]))
            {
                pos=i;
                break;
            }
        }        
        return(pos);
    }
    public void remove(Object O)
    {
        int pos=search(O);
        if(pos==-1)
            throw new NoSuchElementException("Element does not exist in ArrayList");
        else
        for(int i=pos;i<size-1;i++)
        {
            arr[i]=arr[i+1];
        }
    }
    public Object getElementAt(int pos)
    {
        if(pos<0 || pos>=size)
            throw new IndexOutOfBoundsException("List Index out of range");
        else
            return(arr[pos]);
    }
}