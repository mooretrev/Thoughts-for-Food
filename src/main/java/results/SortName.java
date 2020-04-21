package results;

import java.util.Comparator;

import containers.Recipe;

public class SortName implements Comparator<Recipe> {

	@Override
	public int compare(Recipe o1, Recipe o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
