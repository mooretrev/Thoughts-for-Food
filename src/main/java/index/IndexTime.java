package index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import containers.Recipe;

public class IndexTime {

	private HashMap<Integer, Recipe> recipeById;

	public IndexTime(HashMap<Integer, Recipe> recipeById) {
		this.recipeById = recipeById;
	}

	public HashMap<Integer, List<Recipe>> index() {
		HashMap<Integer, List<Recipe>> res = new HashMap<Integer, List<Recipe>>();

		for(Integer key : recipeById.keySet()) {
			Integer cookTime = recipeById.get(key).getCookTime();
			System.out.println("t: " + key);
			if(res.containsKey(cookTime)) {
				List<Recipe> temp = res.get(cookTime);
				temp.add(recipeById.get(key));
				res.put(cookTime, temp);
			}
			else {
				List<Recipe> recipeList = new ArrayList<Recipe>();
				recipeList.add(recipeById.get(key));
				res.put(cookTime, recipeList);
			}
		}
		
		return res;
	}
}
