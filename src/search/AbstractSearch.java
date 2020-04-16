package search;

import java.util.List;

import containers.Data;
import containers.Recipe;

public abstract class AbstractSearch {
	
	private Data data;
	
	public AbstractSearch(Data data) {
		this.data = data;
	}
	
	public abstract List<Recipe> search(String query);

}
