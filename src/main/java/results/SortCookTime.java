package results;

import java.util.Comparator;

import containers.Recipe;

public class SortCookTime implements Comparator<Recipe>{

	@Override
	public int compare(Recipe o1, Recipe o2) {
		if(o1.getCookTime() < o2.getCookTime()) {
			return -1;
		}else if(o1.getCookTime() > o2.getCookTime()) {
			return 1;
		}else {
			return o1.compare(o1, o2);
		}
	}

}
