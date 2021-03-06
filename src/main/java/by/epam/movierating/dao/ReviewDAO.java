package by.epam.movierating.dao;

import by.epam.movierating.bean.Review;
import by.epam.movierating.bean.dto.ReviewDTO;
import by.epam.movierating.dao.exception.DAOException;
import by.epam.movierating.dao.util.ColumnExistable;
import by.epam.movierating.dao.util.DAODefaultFunctional;
import by.epam.movierating.dao.util.JDBCAutocloseable;

import java.util.List;

/**
 * @author serge
 *         02.06.2017.
 */
public interface ReviewDAO extends DAODefaultFunctional, JDBCAutocloseable, ColumnExistable {

    boolean reviewMovie(Review review) throws DAOException;

    List<Review> getAllReviewsOrderByDate() throws DAOException;

    List<ReviewDTO> getReviewsDTOByMovieId(int idMovie) throws DAOException;

    boolean deleteReview(int idMovie, int idUser) throws DAOException;

    boolean checkReviewOpportunity(int idMovie, int idUser) throws DAOException;

    boolean updateReview(Review review) throws DAOException;
}
