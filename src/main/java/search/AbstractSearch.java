package search;


import containers.Data;
import results.Results;

public abstract class AbstractSearch {
	
	protected Data data;
	
	public AbstractSearch(Data data) {
		this.data = data;
	}
	
	public abstract Results search(String query);

}
