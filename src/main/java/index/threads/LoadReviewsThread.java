package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Review;
import index.FileObject;

public class LoadReviewsThread extends Thread {

	public HashMap<Integer, List<Review>> reviewsById;
	private FileObject fileReviewsById = new FileObject();
	private String fileNameReviewsById = "ReviewById";

	@Override
	public void run() {
		System.out.println("review thread");
		reviewsById = (HashMap<Integer, List<Review>>) fileReviewsById.load(fileNameReviewsById);

	}

	public HashMap<Integer, List<Review>> getReviewsById() {
		return reviewsById;
	}
}
