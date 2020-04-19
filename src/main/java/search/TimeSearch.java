package search;

import java.util.List;
import java.util.Set;

import containers.Data;
import containers.Recipe;

public class TimeSearch extends AbstractSearch {

	public TimeSearch(Data data) {
		super(data);
	}

	@Override
	public List<Recipe> search(String query) {
		Integer time = null;
		try {
			time = Integer.parseInt(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Set<Integer> keys = data.recipeByTime.keySet();

		return data.recipeByTime.get(time);
	}

}
