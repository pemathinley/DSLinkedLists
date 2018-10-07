import java.util.*;
class node5
{
	int data;
	node5 next;
	node5(int d)
	{
		data = d;
	}
}

public class LinkListOddEven
{
	private static Scanner ip = new Scanner(System.in);
	node5 insert(node5 head , int d)
	{
		node5 temp = new node5(d);
		if( head == null )
		{
			head = temp;
		}
		else
		{
			node5 ptr = head;
			while( ptr.next != null )
				ptr = ptr.next;
			ptr.next = temp;
		}
		return head;
	}
	
	void display(node5 head)
	{
		node5 ptr = head;
		while( ptr != null )
		{
			System.out.print( ptr.data +  " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	node5 checkOddEven(node5 head)
	{
		node5 ptr = head;
		node5 ehead=null;
		node5 ohead=null;
		node5 eend=null;
		node5 oend=null;
	
		while(ptr != null)
		{
			if(ptr.data % 2 == 0)
			{
				if(ehead==null)
				{
					ehead=eend=ptr;
				}
				else
				{
					eend.next=ptr;
					eend=ptr;
				}
			}
			else
			{
				if(ohead==null)
				{
					ohead=oend=ptr;
				}
				else
				{
					oend.next=ptr;
					oend=ptr;
				}
			}
			ptr=ptr.next;
		}
		
		oend.next = ehead;
		eend.next = null;
		
		return ohead;
	}
	public static void main(String[] args)
	{
		LinkListOddEven obj = new LinkListOddEven();
		node5 head = null;
		
		System.out.println("Enter size");
		int size = ip.nextInt();
		
		System.out.println("Enter data's");
		for(int i=0 ; i<size ; i++ )
		{
			int d = ip.nextInt();
			head = obj.insert(head,d);
		}
		
		head = obj.checkOddEven(head);
		
		System.out.println("List after odd and even elements are arranged");
		obj.display(head);
		ip.close();
	}
}