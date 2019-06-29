package net.mahtabalam;
import java.util.Arrays;

public class HamiltonianCycle {

	private static int numOfVertices;
	private static int hamiltonianPath[];
	private static int[][] adjacencyMatrix;

	public void findHamiltonianCycle(int graphAdjacencyMatrix[][]) {
		numOfVertices = adjacencyMatrix[0].length;
		hamiltonianPath = new int[numOfVertices];
		adjacencyMatrix = graphAdjacencyMatrix;
		
		hamiltonianPath[0] = 0;

		if (findFeasibleSolution(1)) {
			showHamiltonianPath();
			
		}else{
			System.out.println("There is no Hamiltonian Cycle in the graph...");
		}
	}

	boolean findFeasibleSolution(int position) {
	
		System.out.println("Checking Position "+position);
		/* base case: If all vertices are included in Hamiltonian Cycle */
		if (position == numOfVertices) {
			// Checking whether there is an edge from the last included vertex to the first vertex 
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		for (int vertexIndex = 1; vertexIndex < numOfVertices; ++vertexIndex) {
			if (isFeasible(vertexIndex, position)) {

				hamiltonianPath[position] = vertexIndex;
				System.out.println("Added Vertex "+vertexIndex);

				if (findFeasibleSolution(position + 1)) { 
					return true;
				}
				// !!! Backtrack
				System.out.println("Backtracking "+Arrays.toString(hamiltonianPath));
			}
			
		}
		return false;
	}

	boolean isFeasible(int vertex, int actualPosition) {
		// first criteria: whether the two nodes are connected?
		if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0){
			System.out.println("___Vertex "+vertex+" is not connected___");
			return false;
			
		}
		//second criteria: whether we have already added this node to hamiltonian path?
		for (int i = 0; i < actualPosition; ++i){
			if (hamiltonianPath[i] == vertex){
				System.out.println("___Vertex "+vertex+" is already added to hamiltonian path___");
				return false;
			}
		}
		return true;
	}

	public void showHamiltonianPath() {
		System.out.println("Hamiltonian cycle exists: ");
		for (int i = 0; i < numOfVertices; ++i) {
			System.out.print(hamiltonianPath[i] + " ");
		}
		System.out.println(hamiltonianPath[0]);
	}
	
}
