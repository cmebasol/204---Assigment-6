import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph implements GraphInterface <Town,Road>{

	private Map <Town, ArrayList<Road>> rep;
	
	private int townCount;
	
	
	public Graph() {
		this.rep = new HashMap<Town, ArrayList<Road>>();
		townCount = 0;
	}
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road dummy = new Road(sourceVertex, destinationVertex, "dummy");
		// if the sorurce town is not in the list of sources
		if (!rep.keySet().contains(sourceVertex) )
			return null;
		
		//this gets me the arraylist of roads which are pointed by the source vertex
		ArrayList<Road> sourceList = rep.get(sourceVertex);

		// look for the road that contains the destination vertex as a destination
		for(Road each: sourceList) {
			if(each.equals(dummy))
				return each;
			}
		return null;
		
		
		// from the above array list i  have to find the destination vertices
		// if the destination town is in the destinations ArrayList
//		if (sourceList.contains(new RoaddestinationVertex))
//			//create a road named after the two towns 
//			return new Road(destinationVertex, sourceVertex,"dummy");
//		else 
//			return null;
	}
	/**
	 * checks if the town is in the Graph
	 * @param town the town to be looked for in the Graph
	 * @return true if the town is in the Graph
	 */
	public boolean has(Town town) {
		// look for the town in the keys
		if (rep.keySet().contains(town))
			return true;
		
		// look for the town in the each array of destinations
		for (ArrayList<Road> each: rep.values()) {
			for(Road t : each) {
				if(t.getDestination().equals(town) || t.getSource().equals(town))
					return true;
			}
		}
		return false;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destination, int weight, String description) {

		
		// dummy road that has source and destination vertics
		Road newRoad = new Road(sourceVertex, destination, weight, description );
		if(!(has(sourceVertex) && has(destination)))
			throw new IllegalArgumentException();
		// if the source vertex is not in the 
		if(!(rep.keySet().contains(sourceVertex))) {
			// add sourceVertex as a key( source)
			rep.put(sourceVertex, new ArrayList<Road>());
		}
		// add new road to the list of destinations of source town
		rep.get(sourceVertex).add(newRoad);
		
//		if (!(rep.keySet().contains(sourceVertex))) {
//			// add a map with the source vertex and an empty arraylist
//			rep.put(destinationVertex, new ArrayList<Town>());
//		}
//		// look if the destination is already in the set of destinations of the source town
//		if (!(rep.get(sourceVertex).contains(destinationVertex))) {
//			// add the destination to the set of destinations of the source town
//			rep.get(sourceVertex).add(destinationVertex);
//			return new Road (destinationVertex, sourceVertex, weight, description);
//		}
		return null;
	}

	// works
	@Override
	public boolean addVertex(Town v) {
		if (!(has(v))) {
			rep.put(v,new ArrayList<Road> ());
			return true;
		}
		return false;
	}

	//works
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		// create dummy road
		Road dummy = new Road (sourceVertex, destinationVertex, "dummy");
		// if source town is in the set of keys
		if (rep.containsKey(sourceVertex)) {
			for(Road each: rep.get(sourceVertex)) {
				if (each.equals(dummy))
					return true;
			
			}
			return false;
		}
		
		else 
			return false;
	}

	//works
	@Override
	public boolean containsVertex(Town v) {
		return has(v);
	}

	// works
	@Override
	public Set<Road> edgeSet() {
		//create set
		Set<Road> mySet = new HashSet<Road>();
		// for each arraylist in the values
		for (ArrayList<Road> source: rep.values()) {
			// for each roads in source
			for (Road road: source) {
				mySet.add(road);
			}
		}
		return mySet;
	}
	//works
	@Override
	public Set<Road> edgesOf(Town vertex) {
		//create set
		Set<Road> set = new HashSet<Road>();
		// if the town is in the set of the dictionary key set
		if(rep.containsKey(vertex)) {
			// for each destination
			set.addAll(rep.get(vertex));
		}
		
		return set;
	}

	//
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		System.out.println(this.edgeSet().toString());
		if(weight > -1 && description != null) {
			// create dummy
			Road dummy  = new Road(sourceVertex, destinationVertex, "dummy");
			// if the source vertex is in the set of source towns
			if(rep.keySet().contains(sourceVertex)) {
				//save the Road before it is deleted
				Road save = null;
				for (Road road: rep.get(sourceVertex) )
					if(road.equals(dummy))
						save = road;
				// removes the destination vertex from the list of destinations
				rep.get(sourceVertex).remove(dummy);
				System.out.println(this.edgeSet().toString());

				return save;
				
			}
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		rep.remove(v);
		for (ArrayList<Road> list:rep.values()) {
			for (Road rod : list) {
				if (rod.getSource().equals(v) || rod.getDestination().equals(v)) {
					list.remove(rod);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> newSet = new HashSet<Town> ();
		newSet.addAll(rep.keySet());
		
		// for each arraylist of roads source
		for(ArrayList<Road> source: rep.values()) {
			
			for(Road destinations: source) {
				if(!newSet.contains(destinations)) {
					newSet.add(destinations.getDestination());
				}
			}
		}
		return newSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		return null;
	}

	private class Node implements Comparable<Node>{
		public Town destination;
		public int weight;
		public Town via;
		public boolean visited;
		public Node(Town destination) {
			this.destination = destination;
			this.weight = Integer.MAX_VALUE;
			this.via = null;
			this.visited = false;
		}
		@Override
		public int compareTo(Graph.Node o) {
			if (destination.equals(o.destination))
				return 0;
			return -1;
			
		}
		@Override
		public boolean equals(Object o) {
			Node node = (Node) o;
			return this.destination.equals(node.destination);
		}
	}
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {

		// set to store towns in my graph
		Set<Town> towns = this.vertexSet();
		
		//queue to store the towns to be visited
		ArrayList<Town> queue  = new ArrayList <Town>();
		
		// list to store nodes of towns
		ArrayList<Node>  unvisited = new ArrayList<Node>();
		
		// i have to move the node to visited if all its vertices are read
		
		// for each town in the graph create node
		for(Town each: towns) {
			// create a node and add it to the list of townNodes
			unvisited.add(new Node(each));
		}
		for(Road each: rep.get(sourceVertex)) {
			ArrayList <Road> one = new ArrayList<Road>();
			if(this.findNode(sourceVertex, unvisited))
		}
		
		// do the recursive function
		
	}
	
	
	
	public ArrayList<Node> findNode(Town sourceVertex, ArrayList<Node> townNodes) {
		
		ArrayList<Node> my = new ArrayList<Node>();
		for(Node each: townNodes) {
			if(each.destination.equals(sourceVertex){
				my.add(each);
			}
		}
		return null;
	}
		//// there should be recursion
//		
//		for (ea)
//		s
//		// first go through the destinations of the source vertex
//		for(Road each: rep.get(sourceVertex)) {
//			// if the distance is shorter than stated on the nodes
//			if(each.getDegrees() <)
//			//			if (each.getDegrees() < 
//		}
//		
//	}
//	public recursive

	
}
