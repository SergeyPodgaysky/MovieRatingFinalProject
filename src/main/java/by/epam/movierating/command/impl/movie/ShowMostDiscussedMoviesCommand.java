package by.epam.movierating.command.impl.movie;

import by.epam.movierating.bean.Movie;
import by.epam.movierating.command.Command;
import by.epam.movierating.command.constant.AttributeName;
import by.epam.movierating.command.constant.PageName;
import by.epam.movierating.command.util.CookieUtil;
import by.epam.movierating.service.MovieService;
import by.epam.movierating.service.exception.ServiceException;
import by.epam.movierating.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author serge
 *         25.06.2017.
 */
public class ShowMostDiscussedMoviesCommand implements Command {
    private static final Logger logger = Logger.getLogger(ShowMostDiscussedMoviesCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String currentLanguage = CookieUtil.getCurrentLanguage(request);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MovieService movieService = serviceFactory.getMovieService();
        try {
            List<Movie> movieList = movieService.getMostDiscussedMovies(currentLanguage);
            request.setAttribute(AttributeName.MOVIES, movieList);
            request.getRequestDispatcher(PageName.MOST_DISCUSSED_MOVIES_PAGE).forward(request, response);
        } catch (ServiceException e) {
            logger.error("Error during executing ShowMostDiscussedMoviesCommand",e);
            response.sendRedirect(PageName.ERROR_500_PAGE);
        }
    }
}
