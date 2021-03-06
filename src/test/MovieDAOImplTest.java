import by.epam.movierating.bean.Movie;
import by.epam.movierating.dao.MovieDAO;
import by.epam.movierating.dao.connectionpool.ConnectionPool;
import by.epam.movierating.dao.exception.ConnectionPoolException;
import by.epam.movierating.dao.exception.DAOException;
import by.epam.movierating.dao.factory.DAOFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author serge
 *         11.06.2017.
 */
public class MovieDAOImplTest {
    private static MovieDAO movieDAO;
    private static final String LANGUAGE_EN = "en";

    @BeforeClass
    public static void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        movieDAO = daoFactory.getMovieDAO();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.initializePool();
        } catch (ConnectionPoolException e) {
            throw new RuntimeException("Can not init a pool", e);
        }
    }

    @AfterClass
    public static void destroy() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.destroyPool();
        } catch (ConnectionPoolException e) {
            throw new RuntimeException("Can not dispose a pool", e);
        }
    }
    @Test
    public void getTopMoviesTest() {
        String language = "en_EN";
        List<Movie> movieList;
        try {
            movieList = movieDAO.getTopMovies(language);
            Assert.assertNotNull(movieList);
            for(Movie movie : movieList) {
                System.out.println(movie.toString());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMostDiscussedMovies() {
        String language = "en_EN";
        List<Movie> movieList;
        try {
            movieList = movieDAO.getMostDiscussedMovies(language);
            Assert.assertNotNull(movieList);
            for(Movie movie : movieList) {
                System.out.println(movie.toString());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCountryForMovie() {
        boolean isAdded;
        try {
            isAdded = movieDAO.addCountryForMovie(1, "FRA");
            Assert.assertTrue(isAdded);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
