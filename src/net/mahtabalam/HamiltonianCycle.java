package net.mahtabalam;
import java.util.Arrays;

public class HamiltonianCycle {

	private static int numOfVertices;
	private static int hamiltonianPath[];
	private static int[][] adjacencyMatrix;

	public static void findHamiltonianCycle(int graphAdjacencyMatrix[][]) {
		adjacencyMatrix = graphAdjacencyMatrix;
		numOfVertices = adjacencyMatrix[0].length;
		hamiltonianPath = new int[numOfVertices];
		
		hamiltonianPath[0] = 0;

		if (findFeasibleSolution(1)) {
			printHamiltonianCycle();
			
		}else{
			System.out.println("There is no Hamiltonian Cycle in the graph...");
		}
	}

	public static boolean findFeasibleSolution(int nextVertex) {
	
		System.out.println("Checking Next Vertex "+nextVertex);
		/* base case: If all vertices are included in hamiltonian path */
		if (nextVertex == numOfVertices) {
			// Checking whether there is an edge from the last included vertex to the first vertex 
			if (adjacencyMatrix[hamiltonianPath[nextVertex - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		for (int vertexIndex = 1; vertexIndex < numOfVertices; ++vertexIndex) {
			if (isFeasible(vertexIndex, nextVertex)) {

				hamiltonianPath[nextVertex] = vertexIndex;
				System.out.println("Added Vertex "+vertexIndex + " - " + Arrays.toString(hamiltonianPath));

				if (findFeasibleSolution(nextVertex + 1)) { 
					return true;
				}
				// !!! Backtrack
				System.out.println("Backtracking Vertex "+(nextVertex));
				hamiltonianPath[nextVertex] = 0;
			}
			
		}
		return false;
	}

	public static boolean isFeasible(int vertex, int nextVertex) {
		// first condition: whether the two nodes are connected?
		if (adjacencyMatrix[hamiltonianPath[nextVertex - 1]][vertex] == 0){
			return false;
			
		}
		//second condition: whether we have already added this node to hamiltonian path?
		for (int i = 0; i < nextVertex; ++i){
			if (hamiltonianPath[i] == vertex){
				System.out.println("___Vertex "+vertex+" is already added to hamiltonian path___");
				return false;
			}
		}
		return true;
	}

	public static void printHamiltonianCycle() {
		System.out.println("Hamiltonian cycle exists: ");
		for (int i = 0; i < numOfVertices; ++i) {
			System.out.print(hamiltonianPath[i] + " ");
		}
		System.out.println(hamiltonianPath[0]);
	}
	
}
