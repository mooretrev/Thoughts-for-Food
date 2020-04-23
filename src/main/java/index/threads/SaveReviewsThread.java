package index.threads;

import java.util.List;

import containers.Review;
import index.FileObject;
import index.IndexReviews;

public class SaveReviewsThread extends Thread{
	
	private FileObject fileReviewsById = new FileObject();
	private String fileNameReviewsById = "ReviewById";
	
	@Override
	public void run() {
		IndexReviews indexReviews = new IndexReviews();
		fileReviewsById.save(indexReviews.index(), fileNameReviewsById);
	}

}
