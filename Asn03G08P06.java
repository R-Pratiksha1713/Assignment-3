import java.util.*;

public class Asn03G08P06
{
	public static void printleft(Node root)
	{
		root=root.leftchild;
		System.out.println("Sum="+root.sum);
		System.exit(0);
	}
	public static void printright(Node root)
	{
		root=root.rightchild;
		System.out.println("Sum="+root.sum);
		System.exit(0);
	}
	public static void invalid()
	{
		System.out.println("Invalid Input \nPlease enter Yes or No");
		System.exit(0);
	}
 	public static void main(String[] args)
	{
		Scanner read=new Scanner(System.in);
		PriorityQueue<Node> pq=new PriorityQueue<Node>(16,new MyComparator());
		String ans;
		int[] arr={3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		int[] freq={1,3,6,10,15,21,25,27,27,25,21,15,10,6,3,1};
		for(int i=0;i<16;i++)
		{	
			Node h=new Node();
			h.sum=arr[i];
			h.f=freq[i];
			h.leftchild=null;
			h.rightchild=null;
			pq.add(h);
		}
		Node root=null;
		while(pq.size()>1)
		{
			Node n1=pq.peek();
			pq.poll();
			Node n2=pq.peek();
			pq.poll();
			Node n3=new Node();
			n3.f=n1.f+n2.f;
			n3.sum='-';
			n3.leftchild=n1;
			n3.rightchild=n2;
			root=n3;
			pq.add(n3);
		}
		System.out.println("Answer the following questions as Yes or No");
		System.out.println("Is the sum 5 or 9 or 12 or 13 or 15 or 16?");
		ans=read.next();
		if(ans.equals("Yes"))
		{
			root=root.leftchild;
			System.out.println("Is the sum 13 or 12 or 9?");
			ans=read.next();
			if(ans.equals("Yes"))
			{
				System.out.println("Is the sum 13?");
				ans=read.next();
				if(ans.equals("Yes"))	
				{	
					root=root.leftchild;
					printleft(root);
				}
				else if(ans.equals("No"))
				{
					root=root.rightchild;
					System.out.println("Is the sum 12?");
					ans=read.next();
					if(ans.equals("Yes"))	
					{
						printleft(root);
					}
					else if(ans.equals("No"))
					{
						printright(root);
					}
					else
					{
						invalid();
					}
				}
				else
				{
					invalid();
				}
			}
			else if(ans.equals("No"))
			{	
				root=root.leftchild;
				root=root.rightchild;
				System.out.println("Is the sum 15?");
				ans=read.next();
				if(ans.equals("Yes"))		
				{	
					printleft(root);
				}
				else if(ans.equals("No"))
				{
					root=root.rightchild;
					System.out.println("Is the sum 16?");
					ans=read.next();
					if(ans.equals("Yes"))
					{
						printleft(root);
					}
					else if(ans.equals("No"))
					{
						printright(root);
					}
					else
					{
						invalid();
					}
				}
				else
				{
					invalid();
				}
			}
			else
			{
				invalid();
			}
		}
		else if(ans.equals("No"))
		{
			root=root.rightchild;
			System.out.println("Is the sum 10 or 11?");
			ans=read.next();
			if(ans.equals("Yes"))	
			{
				root=root.leftchild;
				System.out.println("Is the sum 10?");
				ans=read.next();
				if(ans.equals("Yes"))
				{
					printleft(root);
				}
				else if(ans.equals("No"))
				{
					printright(root);
				}
				else
				{
					invalid();
				}
			}
			else if(ans.equals("No"))
			{
				System.out.println("Is the sum 14 or 7 or 8?");
				ans=read.next();
				if(ans.equals("Yes"))
				{
					root=root.rightchild;
					System.out.println("Is the sum 14 or 7?");
					ans=read.next();
					if(ans.equals("Yes"))			
					{
						root=root.leftchild;
						System.out.println("Is the sum 14?");
						ans=read.next();
						if(ans.equals("Yes"))
						{
							printleft(root);
						}
						else if(ans.equals("No"))
					    {
							printright(root);
					    }
						else
						{
							invalid();
						}
					}
					else if(ans.equals("No"))
					{
						root=root.rightchild;
						printright(root);
					}
					else
					{
						invalid();
					}
				}
				else if(ans.equals("No"))
				{			
					System.out.println("Is the sum 17 or 6 or 4?");
					ans=read.next();
					if(ans.equals("Yes"))
					{
						root=root.rightchild;
						root=root.rightchild;
						root=root.leftchild;
						System.out.println("Is the sum 17 or 6?");
						ans=read.next();
						if(ans.equals("Yes"))
						{
							System.out.println("Is the sum 17?");
							ans=read.next();
							if(ans.equals("Yes"))
							{
								root=root.leftchild;
								printleft(root);
							}
							else if(ans.equals("No"))
							{
								printright(root);
							}
							else
							{
								invalid();
							}
						}
						else if(ans.equals("No"))
						{
							root=root.leftchild;
							root=root.rightchild;
							printright(root);
						}
						else
						{
							invalid();
						}
					}
					else if(ans.equals("No"))
					{
						root=root.rightchild;
						root=root.rightchild;
						root=root.leftchild;
						root=root.leftchild;
						root=root.rightchild;
						root=root.leftchild;
						System.out.println("Is the sum 3?");
						ans=read.next();
						if(ans.equals("Yes"))
						{
							printleft(root);
						}
						else if(ans.equals("No"))
						{
							printright(root);
						}	
						else
						{
							invalid();
						}
					}
					else
					{
						invalid();
					}
				}
			}
			else
			{
				invalid();
			}
		}
		else
		{
			invalid();
		}
	}
}


class Node
{
	int f;
	int sum;
	Node leftchild;
	Node rightchild;
}


class MyComparator implements Comparator<Node>
{
	public int compare(Node n1,Node n2)
	{
		return n1.f-n2.f;
	}
}