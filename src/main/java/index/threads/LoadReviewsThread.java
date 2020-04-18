package index.threads;

import java.util.HashMap;
import java.util.List;

import containers.Review;
import index.FileHashMap;

public class LoadReviewsThread extends Thread {

	public HashMap<Integer, List<Review>> reviewsById;
	private FileHashMap<Integer, List<Review>> fileReviewsById = new FileHashMap<Integer, List<Review>>();
	private String fileNameReviewsById = "ReviewById";

	@Override
	public void run() {
		System.out.println("review thread");
		reviewsById = fileReviewsById.load(fileNameReviewsById);

	}

	public HashMap<Integer, List<Review>> getReviewsById() {
		return reviewsById;
	}
}
