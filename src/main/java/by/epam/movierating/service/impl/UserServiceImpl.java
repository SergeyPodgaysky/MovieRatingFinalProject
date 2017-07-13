package by.epam.movierating.service.impl;

import by.epam.movierating.bean.User;
import by.epam.movierating.dao.UserDAO;
import by.epam.movierating.dao.exception.DAOException;
import by.epam.movierating.dao.factory.DAOFactory;
import by.epam.movierating.service.UserService;
import by.epam.movierating.service.exception.ServiceException;
import by.epam.movierating.service.util.CryptographicUtil;
import by.epam.movierating.service.util.DataValidator;

import java.util.Date;
import java.util.List;

/**
 * @author serge
 *         09.05.2017.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User logIn(String login, byte[] password) throws ServiceException {
        //todo validation
        User user;
        String encodedPassword = CryptographicUtil.encodePassword(password);
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            user = userDAO.getUserByLogin(login);
            if (user == null) {
                throw new ServiceException("Wrong login");
            }
            if (!user.getPassword().equals(encodedPassword)) {
                throw new ServiceException("Wrong password");
            }
        } catch (DAOException e) {
            throw new ServiceException("Error during getting user by login", e);
        }
        return user;
    }

    @Override
    public User register(String login, byte[] password, byte[] confirmedPassword,
                         String fullName, String email) throws ServiceException {
        //todo validation
        DataValidator.validatePassword(password);
        DataValidator.validatePasswordsEquality(password, confirmedPassword);
        User user;
        String encodedPassword = CryptographicUtil.encodePassword(password);
        int userId;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            user = new User();
            user.setLogin(login);
            user.setPassword(encodedPassword);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setRegisterDate(new Date());
            userId = userDAO.register(user);
            user.setId(userId);
        } catch (DAOException e) {
            throw new ServiceException("Error during registration user", e);
        }
        return user;
    }

    @Override
    public List<User> getAllUser() throws ServiceException {
        //todo validation
        List<User> userList;

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            userList = userDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException("Error during getting All Users", e);
        }
        return userList;
    }
}
