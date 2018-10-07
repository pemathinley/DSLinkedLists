import java.util.Scanner;
class Node4
{
	int data;
	Node4 next;
	Node4(int d)
	{
		data = d;
	}
}
public class Reverse_List 
{
	Node4 head;
	private static Scanner ip = new Scanner(System.in);
	
	public void insertlist(int d)
	{
		 Node4 temp = new Node4(d);
		 if( head == null)
		 {
			 temp.next = head;
			 head = temp;
		 }
		 else
		 {
			 Node4 ptr = head;
			 while(ptr.next != null)
			 {
				 ptr = ptr.next;
			 }
			 ptr.next = temp;
		 }
	}
	
	public void display()
	{
		Node4 temp = head;
		while(temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void reverse1()
	{
		Node4 prev = null;
		Node4 curr = head;
		Node4 next1 = null;
		while( curr != null )
		{
			next1 = curr.next ;
			curr.next = prev;
			prev = curr;
			curr = next1;
			
		}
		head = prev;
	}
	public static void main(String[] args) 
	{
		Reverse_List r = new Reverse_List();
		System.out.println("Enter size :");
		int n = ip.nextInt();
		System.out.println("Enter data");
		for(int i=0 ; i<n ; i++)
		{
			int d = ip.nextInt();
			r.insertlist(d);
		}
		System.out.println("List is :");
		r.display();
		
		System.out.println("Reverse link list : ");
		r.reverse();
		r.display();
		ip.close();
	}

}