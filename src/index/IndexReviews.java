package index;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import parser.CSVParser;

import containers.Recipe;
import containers.Review;

public class IndexReviews {

	private String filePath = "data/RAW_interactions.csv";
	private int numRows = 5;

	public HashMap<Integer, List<Review>> index(){


		HashMap<Integer, List<Review>>  map = new HashMap<Integer, List<Review>>();
		ArrayList<String> data = null; 


		try {
			FileReader filereader = new FileReader(filePath); 
			CSVParser csvReader = new CSVParser(filereader); 

			csvReader.readLine(); // skip the title line
			while ((data = csvReader.readLine()) != null) { 
				
				if(data.size() == numRows) {
					Review review = new Review();
					
					review.setRecipeId(Integer.parseInt(data.get(C.recipe_id.ordinal())));
					review.setRating(Integer.parseInt(data.get(C.rating.ordinal())));
					review.setReview(data.get(C.reivew.ordinal()));
					review.setUserId(Integer.parseInt(data.get(C.user_id.ordinal())));
					review.setDate(data.get(C.date.ordinal()));
	
					if(map.containsKey(review.getRecipeId())) {
						List<Review> list = map.get(review.getRecipeId());
						list.add(review);
						map.put(review.getRecipeId(), list);
					}else {
						List<Review> list = new ArrayList<Review>();
						list.add(review);
						map.put(review.getRecipeId(), list);
					}
				}


			} 
			csvReader.close();
		} 
		catch (Exception e) { 
			e.printStackTrace();
		} 
		return map;
	}	
	
	enum C 
	{ 
		user_id, recipe_id, date, rating, reivew
	} 

	
}


