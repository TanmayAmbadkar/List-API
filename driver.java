import java.util.*;
public class driver
{
    public static void main(String args[])
    {
        LinkedList<Integer> list=new<Integer>LinkedList();
        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            if(in.hasNextInt())
            {
                int x=in.nextInt();
                list.add(x);
                if(x==-1)
                break;
                list.traverse();
            }
        }
        list.reverse();
        list.traverse();
    }
}