package net.mahtabalam;

class App {
	
	public static int graph1[][] = {
			{0, 1, 1}, 
	        {1, 0, 1}, 
	        {1, 1, 0}
	    }; 
	
	public static int graph2[][] = {
			{0, 1, 0}, 
	        {1, 0, 1}, 
	        {0, 1, 0}
	    }; 
	
	public static int graph3[][] = {
			{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
        }; 
	
	public static int graph4[][] = {
			{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 0}, 
            {0, 1, 1, 0, 0}, 
        }; 
    
    public static void main(String args[]) {
    	HamiltonianCycle hamiltonian = new HamiltonianCycle();
        hamiltonian.findHamiltonianCycle(graph4);
    }
}
