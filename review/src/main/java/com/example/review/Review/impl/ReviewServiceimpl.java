package com.example.review.Review.impl;

import com.example.review.Review.Review;
import com.example.review.Review.ReviewRepository;
import com.example.review.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceimpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceimpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if(companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            Optional<Review> existingReview = reviewRepository.findById(reviewId);
            if (existingReview.isPresent()) {
                review.setTitle(updatedReview.getTitle());
                review.setDescription(updatedReview.getDescription());
                review.setRating(updatedReview.getRating());
                review.setCompanyId(updatedReview.getCompanyId());
                reviewRepository.save(review);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletedReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null) {
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
