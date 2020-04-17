package index.threads;

import java.util.List;

import containers.Review;
import index.FileHashMap;
import index.IndexReviews;

public class IndexReviewsThread extends Thread{
	
	private FileHashMap<Integer, List<Review>> fileReviewsById = new FileHashMap<Integer, List<Review>>();
	private String fileNameReviewsById = "ReviewById";
	
	@Override
	public void run() {
		IndexReviews indexReviews = new IndexReviews();
		fileReviewsById.save(indexReviews.index(), fileNameReviewsById);
	}

}
