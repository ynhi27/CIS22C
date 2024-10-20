package Final_p1;
/**
 * Yue-Hsi Cheng, Huong Doan, Y Nhi Tran, Travis Huang
 * Professor Abolghasemi
 * CIS 22C
 * June 25th, 2023
 */
public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
	
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		}
		
		private T getData()
		{
			return data;
		}
		
		private Node getNextNode()
		{
			return next;
		}
	}
	
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	
	public T pop()
	{
		T top = peek();
		assert topNode != null;
		topNode = topNode.getNextNode();
		return top;
	}
	
	public T peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}
	
	public boolean isEmpty()
	{
		return topNode == null;
	}
	
	public void clear()
	{
		topNode = null;
	}
}
