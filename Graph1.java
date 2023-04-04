import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph1 implements GraphInterface<Town,Road>{

	private HashSet<Road> list;
	private int townCount;
	
	
	public Graph1 () {
		list = new HashSet<Road>();
		townCount = 0;
		
	}


	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		for(Road each: list) {
			if(each.equals(new Road(sourceVertex, destinationVertex, "Dummy")))
				return each;
		}
		return null;
	}


	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		list.add(new Road(sourceVertex, destinationVertex, weight, description));
		return null;
	}


	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsVertex(Town v) {
		
		for(Road each: list) {
			if (each.getSource().equals(v) || each.getDestination().equals(v))
				return true;
			return false;
		}		return false;
	}


	@Override
	public Set<Road> edgeSet() {
		
		return list;
	}


	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		HashSet<Road> newList = new HashSet<Road>();
	
		for(Road each: list) {
			if (each.getSource().equals(vertex) || each.getDestination().equals(vertex))
				newList.add(each);
		}
		return newList;
	}


	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}
	
	public 
}
