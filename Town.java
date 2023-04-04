import java.util.ArrayList;

public class Town implements Comparable<Town>{

	private String name;
	private ArrayList <Town> list;
	public Town(String name, ArrayList <Town>list) {
		this.name = name;
		this.list = list;
	}
	public Town (String name) {
		this(name, null);
	}
	
	/**
	 * returns the name of the town
	 * @return String containing the name of the town
	 */
	public String getName () {
		return name;
	}
	@Override
	public int compareTo(Town o) {

		if (this.name.equals(o.name))
			return 0;
		else 
			return -1;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override 
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override 
	public boolean equals (Object o) {
		return this.name.equals(((Town) o).getName());
	}
}
