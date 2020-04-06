package containers;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7171788609782942666L;
	private Integer recipeId;
	private Date date;
	private Integer rating;
	private String review;
	
	public Review(Integer recipeId, Date date, Integer rating, String review) {
		super();
		this.recipeId = recipeId;
		this.date = date;
		this.rating = rating;
		this.review = review;
	}
	
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	@Override
	public String toString() {
		return "Review [recipeId=" + recipeId + ", date=" + date + ", rating=" + rating + ", review=" + review + "]";
	}
	

}
