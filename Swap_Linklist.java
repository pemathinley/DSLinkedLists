import java.util.Scanner;
class Node1
{
	int data;
	Node1 next;
	Node1(int d)
	{
		data = d;
	}	
}

public class  Swap_Linklist  
{
	private static Scanner ip = new Scanner(System.in);
	
	Node1 insert(Node1 head , int d)
	{
		Node1 temp = new Node1(d);
		if( head == null )
			head = temp;
		else
		{
			Node1 ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = temp;
		}
		return head;
	}
	
	void display(Node1 head)
	{
		Node1 ptr = head;
		while( ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	Node1 swapNode(Node1 head , int n1 , int n2)
	{
		if( n1 == n2 )
			return head;
		
		Node1 prevn1 = null, currn1 = head; 
        while (currn1 != null && currn1.data != n1) 
        { 
            prevn1 = currn1; 
            currn1 = currn1.next; 
        } 
  
        Node1 prevn2 = null, currn2 = head; 
        while (currn2 != null && currn2.data != n2) 
        { 
            prevn2 = currn2; 
            currn2 = currn2.next; 
        } 
  
        if (currn1 == null || currn2 == null) 
            return head; 
  
        if (prevn1 != null) 
            prevn1.next = currn2; 
		else 
            head = currn2; 
  
         
        if (prevn2 != null) 
            prevn2.next = currn1; 
        else 
            head = currn1; 
   
        Node1 temp = currn1.next; 
        currn1.next = currn2.next; 
        currn2.next = temp;
        return head;
	}
	
	public static void main(String[] args) 
	{
		Swap_Linklist obj = new Swap_Linklist();
		Node1 head = null;
		System.out.println("Enter size of link list");
		int n = ip.nextInt();
		System.out.println("Enter elements : ");
		for(int i=0 ; i<n ; i++ )
		{
			int d = ip.nextInt();
			head = obj.insert(head,d);
		}
		System.out.println("Elements before swapping :");
		obj.display(head);
		
		System.out.println("Enter two elements to swap :");
		int n1 = ip.nextInt();
		int n2 = ip.nextInt();
		head = obj.swapNode(head,n1,n2);
		
		System.out.println("Elements after swapping :");
		obj.display(head);
		ip.close();
	}

}