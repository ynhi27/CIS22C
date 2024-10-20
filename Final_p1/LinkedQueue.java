package Final_p1;
/**
 * Yue-Hsi Cheng, Huong Doan, Y Nhi Tran, Travis Huang
 * Professor Abolghasemi
 * CIS 22C
 * June 25th, 2023
 */

public class LinkedQueue<T> implements QueueInterface<T> 
{
	class Node 
	{
		T data;
		Node next;
		
		public Node(T data) 
		{ 
			// takes value for data
			this.data = data;
		}
		
	}
	private Node head, tail; // head and tail two references of Node class
	public LinkedQueue() 
	{ 
		// starts empty queue
		head = tail = null;
	}
		
	@Override
	public void enqueue(T newEntry) 
	{
		Node n = new Node(newEntry); // creates node with value=newEntry
		if (isEmpty()) 
		{ 
			// if queue is empty set as head and tail
			head = tail = n;
		}
		
		else 
		{
			tail.next = n; // else append to tail and update tail
			tail = n;
		}
	}
	
	@Override
	public T dequeue() 
	{
		if (isEmpty()) 
		{ 
			// if queue is empty throw exception
			throw new EmptyQueueException("Queue is empty!");
		}
		T data = head.data; // fetch data at head, advance head and update tail
		head = head.next;
		if (head == null) 
		{
			tail = null;
		}
		return data;
	}
	
	@Override
	public T getFront() 
	{
		if (isEmpty()) 
		{ // if queue is empty throw exception
			throw new EmptyQueueException("Queue is empty!");
		}
		return head.data;
	}
	
	@Override
	public boolean isEmpty() 
	{
		return head == null; // if head is null then queue is empty
	}
		
	@Override
	public void clear() 
	{
		head = tail = null;
	}
}
