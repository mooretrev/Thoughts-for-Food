package search;

import java.util.Set;

import containers.Data;
import results.Results;

public class TimeSearch extends AbstractSearch {

	public TimeSearch(Data data) {
		super(data);
	}

	@Override
	public Results search(String query) {
		Integer time = null;
		try {
			time = Integer.parseInt(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Set<Integer> keys = data.recipeByTime.keySet();

		return new Results(data.recipeByTime.get(time));
	}

}
