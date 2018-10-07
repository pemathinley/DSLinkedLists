import java.util.*;
class Node2
{
  int data;
  Node2 next;
  Node2(int d)
  {
    data = d;
  }
}

public class RemoveDuplicates 
{
  private static Scanner ip = new Scanner(System.in);
  public Node2 insert(Node2 start , int d)
  {
	Node2 temp = new Node2(d);
	if( start == null)
	  start = temp;
    else
	{
       Node2 ptr = start;
	   while( ptr.next != null)
	   ptr = ptr.next;
	   ptr.next = temp;
	}
	return start;
  }

  public void display(Node2 start)
  { 
    Node2 ptr = start;
    while( ptr != null)
    {
      System.out.print(ptr.data + " ");
      ptr = ptr.next;
    }
    System.out.println();
  }

  public Node2 sortinglist(Node2 start)
  {
    Node2 ptr1 = start , ptr2 = null;
    while( ptr1.next != null)
    {
      ptr2 = ptr1;
      while( ptr2.next != null )
      {
        if( ptr1.data == ptr2.next.data )
        {
          ptr2.next = ptr2.next.next;
        }
        else
          ptr2 = ptr2.next;
      }
      ptr1 = ptr1.next;
    }
    return start;
  }
  public static void main(String[] args) 
  {
	RemoveDuplicates o = new RemoveDuplicates();
    Node2 head = null;
    System.out.println("Enter size");
    int n = ip.nextInt();
    System.out.println("Enter elements");
    for( int i=0 ; i<n ; i++ )
    {
      int d = ip.nextInt();
      head = o.insert(head,d);
    }
    System.out.println("ELements are :");
    o.display(head);
    head = o.sortinglist(head);
    System.out.println("ELements after duplicates are removed :");
    o.display(head);
    ip.close();
  }
}