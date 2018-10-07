import java.util.*;
class mynode
{
	int data;
	mynode next;
	mynode(int d)
	{
		data = d;
	}
}
public class MergeLinkList 
{
	private static Scanner ip = new Scanner(System.in);
	mynode insert(mynode head , int d)
	{
		mynode temp = new mynode(d);
		if( head == null )
		{
			head = temp;
		}
		else
		{
			mynode ptr = head;
			while( ptr.next != null )
				ptr = ptr.next;
			ptr.next = temp;
		}
		return head;
	}
	
	void display(mynode head)
	{
		mynode ptr = head;
		while( ptr != null )
		{
			System.out.print( ptr.data +  " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	mynode mergeList(mynode head1 , mynode head2)
	{
		mynode head = new mynode(0);
		mynode ptr = head; 
		mynode ptr1 = head1;
		mynode ptr2 = head2;
		while(ptr1 != null && ptr2 != null)
		{
			if(ptr1.data <= ptr2.data)
			{
				ptr.next = ptr1;
				ptr1 = ptr1.next;
			}
			else
			{
				ptr.next = ptr2;
				ptr2 = ptr2.next;
			}
			ptr = ptr.next;
		}
 
		if(ptr1 != null){
			ptr.next = ptr1;
		}
		if(ptr2 != null){
			ptr.next = ptr2;
		}
		return head.next;
	}
	
	
	public static void main(String[] args) 
	{
		mynode head1 = null;
		mynode head2 = null;
		MergeLinkList obj1 = new MergeLinkList();
		MergeLinkList obj2 = new MergeLinkList();
		
		System.out.println("Enter size for first link list");
		int size1 = ip.nextInt();
		
		System.out.println("Enter size for second link list");
		int size2 = ip.nextInt();
		
		System.out.println("Enter data's for first link list");
		for(int i=0 ; i<size1 ; i++ )
		{
			int d = ip.nextInt();
			head1 = obj1.insert(head1,d);
		}
		
		System.out.println("Enter data's for second link list");
		for(int i=0 ; i<size2 ; i++ )
		{
			int d = ip.nextInt();
			head2 = obj2.insert(head2,d);
		}
		
		System.out.println("Data's of first link list are :");
		obj1.display(head1);
		
		System.out.println("Data's of second link list are :");
		obj2.display(head2);
		
		head1 = obj1.mergeList(head1,head2);
		
		System.out.println("Sorted List After Merge :");
		obj2.display(head1);
		ip.close();
	}

}