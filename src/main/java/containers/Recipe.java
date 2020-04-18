package containers;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5766345690757889424L;
	private int id;
	private String name;
	private String description;
	private int cookTime;
	private List<String> tags;
	private int numIngredients;
	private List<String> ingredients;
	private int numInstructions;
	private List<String> instructions;
	
	public Boolean hasIngredent(String ingred) {
		for(String i: ingredients) {
			if(i.equals(ingred)) {
				return true;
			}
		}
		return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCookTime() {
		return cookTime;
	}
	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public int getNumIngredients() {
		return numIngredients;
	}
	public void setNumIngredients(int numIngredients) {
		this.numIngredients = numIngredients;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public int getNumInstructions() {
		return numInstructions;
	}
	public void setNumInstructions(int numInstructions) {
		this.numInstructions = numInstructions;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	@Override
	public String toString() {
//		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", cookTime=" + cookTime
//				+ ", tags=" + tags + ", numIngredients=" + numIngredients + ", ingredients=" + ingredients
//				+ ", numInstructions=" + numInstructions + ", instructions=" + instructions + "]";
		return "Recipe [ingredients=" + ingredients + "]" ;
	}

}
