package by.epam.movierating.command.constant;

/**
 * @author serge
 *         28.05.2017.
 */
public final class PageName {
    public static final String WELCOME_PAGE = "index.jsp";
    public static final String ADMIN_PAGE = "WEB-INF/jsp/admin/admin.jsp";
//    public static final String USER_PAGE = "WEB-INF/jsp/userMainPage.jsp";
    public static final String REGISTRATION_PAGE = "WEB-INF/jsp/registration.jsp";

    public static final String REDIRECT_TO_WELCOME_PAGE = "/Controller?command=show-welcome-page";
    public static final String REDIRECT_TO_ADMIN_PAGE ="/Controller?command=show-admin-page";

    public static final String ERROR_500_PAGE = "500.jsp";
    public static final String ERROR_404_PAGE = "404.jsp";

    public static final String TOP_MOVIES_PAGE = "WEB-INF/jsp/movie/top-movies.jsp";
    public static final String MOST_DISCUSSED_MOVIES_PAGE = "WEB-INF/jsp/movie/most-discussed-movies.jsp";
    public static final String MOVIE_NAVIGATOR_PAGE = "WEB-INF/jsp/movie/movie-navigator-page.jsp";
    public static final String MOVIE_INFO_PAGE = "WEB-INF/jsp/movie/movie-info.jsp";

    public static final String USERS_PAGE = "WEB-INF/jsp/admin/users.jsp";
    public static final String ADD_AND_EDIT_MOVIE_PAGE = "WEB-INF/jsp/admin/add-and-edit-movie.jsp";
    public static final String ADD_AND_EDIT_PARTICIPANT_PAGE = "WEB-INF/jsp/admin/add-and-edit-participant.jsp";
    public static final String ADD_AND_EDIT_GENRE_PAGE = "WEB-INF/jsp/admin/add-and-edit-genre.jsp";
    public static final String PARTICIPANT_INFO_PAGE = "WEB-INF/jsp/participant/participant-info.jsp";
    public static final String ACTORS_PAGE = "WEB-INF/jsp/participant/actors.jsp";
}
