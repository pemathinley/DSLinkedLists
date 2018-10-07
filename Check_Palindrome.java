import java.util.*;
class Node3
{
	int data;
	Node3 next;
	Node3(int d)
	{
		data = d;
	}
}
public class Check_Palindrome 
{
	private static Scanner ip = new Scanner(System.in);
	
	public Node3 insertnodes(Node3 head)
	{
		int d = ip.nextInt();
		Node3 temp = new Node3(d);
		if(head == null)
		{
			head = temp;
		}
		else
		{
			Node3 ptr = head;
			while( ptr.next != null)
				ptr = ptr.next;
			ptr.next = temp; 
		}
		return head;
	}
	
	public void display(Node3 head)
	{
		Node3 ptr = head;
		while( ptr != null )
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	public boolean isPalindrome(Node3 head)
	{
		if(head == null || head.next == null)
			return true;
		
		//finding mid
		Node3 fast = head;
		Node3 slow = head;
		int f=0;
		while( fast != null && fast.next != null)
		{
			if( fast.next.next == null || fast.next == null)
				break;
			fast = fast.next.next;
			slow = slow.next;
			
		}
		
		Node3 secondHead = slow.next;
		slow.next = null;
			
		Node3 prev=null , curr = secondHead , nxt=null;
			
		
		//reverse the elements after mid
		while(curr != null)
		{
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		secondHead = prev;
		
		//compare elements of 1st list and 2nd list
		Node3 ptr = head;
		while(secondHead != null)
		{
			if( secondHead.data != ptr.data)
				return false;
			secondHead = secondHead.next;
			ptr = ptr.next;
		}
		return true;
	}
	public static void main(String[] args) 
	{
		Check_Palindrome n = new Check_Palindrome();
		Node3 head = null;
		int n1;
		System.out.println("Enter size");
		n1 = ip.nextInt();
		System.out.println("Enter data's");
		for(int i=0 ; i<n1; i++)
			head = n.insertnodes(head);
		System.out.println("Link list is : ");
		n.display(head);
		
		System.out.println("Is it palindrome? \n" + n.isPalindrome(head));
		ip.close();
	}
}