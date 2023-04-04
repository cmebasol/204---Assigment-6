
public class Road implements Comparable < Road> {

	private String name;
	private Town destination;
	private Town source;
	private int degrees;
	
	/**
	 * constructs Road object using three attributes
	 * @param name name of the Road
	 * @param destination destination town
	 * @param source source town
	 */
	public Road( Town destination, Town source, String name) {
		super();
		this.name = name;
		this.destination = destination;
		this.source = source;
		this.degrees = 0;
	}

	/**
	 * constructs Road object using every attributes
	 * @param name name of the Road
	 * @param destination destination town
	 * @param source source town
	 * @param degrees the weight of the road
	 */
	public Road( Town destination, Town source, int degrees, String name) {
		super();
		this.name = name;
		this.destination = destination;
		this.source = source;
		this.degrees = degrees;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	public Town getSource() {
		return source;
	}

	public void setSource(Town source) {
		this.source = source;
	}

	public int getDegrees() {
		return degrees;
	}

	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}

	@Override
	public int compareTo(Road o) {
		if (this.name.equals(o.name))
			return 0;
		else 
			return -1;
	}
	/**
	 * checks if the road is connected to the Town
	 * @param town the town to be checked against the Road
	 * @return the computed boolean value
	 */
	public boolean contains(Town town) {
		return this.source.equals(town)  || this.destination.equals(town);
	}

	@Override
	public String toString() {
		return "Road [name= " + name + ", destination= " + destination + ", source= " + source + ", degrees= " + degrees
				+ "]";
	}
	
	@Override
	public boolean equals( Object o) {
		Road road = (Road) o;
		return (this.source.equals(road.source) && this.destination.equals(road.destination)) || (this.source.equals(road.destination ) && this.destination.equals(road.source) );
	}
	
	

	
}
