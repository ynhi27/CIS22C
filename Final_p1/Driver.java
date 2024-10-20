/**
 * Yue-Hsi Cheng, Huong Doan, Y Nhi Tran, Travis Huang
 * Professor Abolghasemi
 * CIS 22C
 * June 25th, 2023
 */
public class Driver 
{
	private static UndirectedGraph<String> myGraph = new UndirectedGraph<>();
	private static StackInterface<String> path = new LinkedStack<>();
	private static final String Huong = "Huong";
	private static final String Yueshi = "Yueshi";
	private static final String Nhi = "Nhi";
	private static final String Janet = "Janet";
	private static final String Bill = "Bill";
	private static final String Travis = "Travis";
	
	public static void main(String[] args)
	{ 
      System.out.println("Showing friends list:");
		setGraphFig28_18a();
      myGraph.displayEdges();
      checkVertexAndEdgeCount(9, 13);
		testEdgesFig28_18a();
      System.out.println("-------------------------------------------------------");
      testRemoveEdge(Bill, Janet);
      System.out.println("-------------------------------------------------------");
      testAddEdge(Nhi, Travis);

      
	}  // end main
	
   public static void setGraphFig28_18a()
   {
      setVerticesFig28_18a(); // Graph cleared before setting vertices
      setEdgesFig28_18a();
   } // end setGraphFig28_18a
   
   public static void checkVertexAndEdgeCount(int numberOfVertices, int numberOfEdges)
   {
      System.out.println("\nNumber of vertices = " + myGraph.getNumberOfVertices());
      System.out.println("Number of edges = " + myGraph.getNumberOfEdges());
   } // end checkVertexAndEdgeCount
   
	public static void testEdgesFig28_18a()
	{
      // Check existing edges
		boolean ok = true;
		ok = checkEdge(Huong, Yueshi, ok);	
		ok = checkEdge(Huong, Janet, ok);	
		ok = checkEdge(Huong, Bill, ok);	
		ok = checkEdge(Yueshi, Bill, ok);	
		ok = checkEdge(Nhi, Yueshi, ok);
		
		
      // Check some non-existing edges
		ok = checkNoEdge(Yueshi, Travis, ok);
		ok = checkNoEdge(Nhi, Bill, ok);
		ok = checkNoEdge(Bill, Travis, ok);
		
		if (ok)
			System.out.println("Edges are OK.");		
	} // end testEdgesFig28_18a

	private static boolean checkEdge(String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (!myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error: " + vertex1 + "is not friends with " + vertex2);
			check = false;
		} // end if
	
		return check;
	} // end checkEdge
	
	private static boolean checkNoEdge(String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error: " + vertex1 + " is not friends with " + vertex2);
			check = false;
		} // end if
	
		return check;
		
	} // end checkNoEdge
	
	public static void testBFS(String v)
	{
		System.out.println("\n\nBreadth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> bfs = myGraph.getBreadthFirstTraversal(v);
		
		printQueue(bfs);
	} // end testBFS
	
	public static void testDFS(String v)
	{
		System.out.println("\n\nDepth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> dfs = myGraph.getDepthFirstTraversal(v);
		
		printQueue(dfs);
	} // end testDFS	
	

	public static void testCheapestPath()
	{
	// UNWEIGHTED graph in Figure 28-18a
   
		setVerticesFig28_18a(); // graph cleared before setting vertices
		//setEdgesFig28_18a();
	
		showPath(Huong, Yueshi);
		showPath(Huong, Nhi);
		showPath(Huong, Janet);
		showPath(Huong, Bill);

	} // end testCheapestPath

	private static void showPath(String vertex1, String vertex2)
	{
		System.out.println("The cheapest path from " + vertex1 + " to " + vertex2 + " is ");
		double cost = myGraph.getCheapestPath(vertex1, vertex2, path);
		printStack(path);
		System.out.println("and has a cost of " + cost + ".");
		System.out.println();
	} // end showPath
		
	public static void testRemoveEdge(String vertex1, String vertex2)
	{
		System.out.print("Modify " + vertex1 + " profile, delete " + vertex2 + " from "+vertex1+" network.");
		if (myGraph.removeEdge(vertex1, vertex2))
			myGraph.displayEdges();
		else
			System.out.print("Friends not found!");
	}
	
	public static void testAddEdge(String vertex1, String vertex2)
	{
		System.out.print("Modify " + vertex1 + " profile, add " + vertex2 + " to "+vertex1+" network.");
		if (myGraph.addEdge(vertex1, vertex2))
			myGraph.displayEdges();
		else
			System.out.print("Friends not found!");
	}
	
	public static void testRemoveVertex(String vertex1, String vertex2)
	{
		System.out.println("Remove" + vertex1 + " from network.");
		
		System.out.println("Remove" + vertex2 + " from network.");
		
		System.out.println("What's left in the network: ");
		printStack(path);
	}
	public static void setVerticesFig28_18a()
	{
		myGraph.clear();

		myGraph.addVertex(Huong);
		myGraph.addVertex(Yueshi);
		myGraph.addVertex(Travis);
		myGraph.addVertex(Nhi);
		myGraph.addVertex(Bill);
		myGraph.addVertex(Janet);
		
	} // end setVerticesFig28_18a

	
	//setFriendships
	public static void setEdgesFig28_18a()
	{
		myGraph.addEdge(Huong, Yueshi, 0);
		myGraph.addEdge(Huong, Travis, 0);
		
		myGraph.addEdge(Yueshi, Bill, 0);
		
		myGraph.addEdge(Nhi, Huong, 0);
		myGraph.addEdge(Nhi, Yueshi, 0);
		
		myGraph.addEdge(Janet, Travis, 0);

		myGraph.addEdge(Bill, Janet, 0);
		

 /*Since additions are made to the end of each edge list, 
   these lists appear as follows:
		Huong: Yueshi -> Janet -> Bill
		Yueshi: Bill
		Nhi: Huong -> Yueshi
		Janet: Bill
		Bill: Nhi -> Yueshi

   We can predict the BFS and DFS traversals knowing this. */
	}// end setEdgesFig28_18a*/
	
	//remove friendship
	public static void removeEdges()
	{
		myGraph.removeEdge(Bill, Janet);
		myGraph.removeEdge(Janet, Travis);
	}//end removeEdges
	
	//remove person from network
	public static void removeVertices()
	{
		myGraph.removeVertex(Janet);
		myGraph.removeVertex(Bill);
	}
	
	
	public static void printStack(StackInterface<String> s)
	{
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println();
	} // end printStack
	
	public static void printQueue(QueueInterface<String> q)
	{
		while (!q.isEmpty())
			System.out.print(q.dequeue() + " ");
		System.out.println(" Actual");
	} // end printQueue
	
	
}
