package Final_p1;import java.util.Iterator;/** * Yue-Hsi Cheng, Huong Doan, Y Nhi Tran, Travis Huang * Professor Abolghasemi * CIS 22C * June 25th, 2023 */public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T>{	public UndirectedGraph()	{		super();	} // end default constructor		public boolean addEdge(T begin, T end, double edgeWeight)	{		return super.addEdge(begin, end, edgeWeight) &&             super.addEdge(end, begin, edgeWeight);	  // Assertion: edge count is twice its correct value due to calling addEdge twice	} // end addEdge		public boolean addEdge(T begin, T end)	{		return this.addEdge(begin, end, 0);	} // end addEdge		public boolean removeEdge(T begin, T end)	{		return super.removeEdge(begin, end);	}	 	public int getNumberOfEdges()	{		return super.getNumberOfEdges() / 2;	} // end getNumberOfEdges	public StackInterface<T> getTopologicalOrder() 	{		throw new UnsupportedOperationException("Topological sort illegal in an undirected graph.");			} // end getTopologicalOrder		public boolean removeVertex(T end) 	{		return super.removeVetex(end);	}	} // end UndirectedGraph// To make addEdge more efficient, DirectedGraph needs to provide accessors // to its data fields. (See Project 3, Chapter 29.)