package by.epam.movierating.service.impl;

import by.epam.movierating.bean.Country;
import by.epam.movierating.dao.CountryDAO;
import by.epam.movierating.dao.exception.DAOException;
import by.epam.movierating.dao.factory.DAOFactory;
import by.epam.movierating.service.CountryService;
import by.epam.movierating.service.exception.ServiceException;

import java.util.List;

/**
 * @author serge
 *         30.06.2017.
 */
public class CountryServiceImpl implements CountryService {

    @Override
    public List<Country> getCountriesByMovieId(int idMovie, String language) throws ServiceException {
        List<Country> countryList;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            CountryDAO countryDAO = daoFactory.getCountryDAO();
            countryList = countryDAO.getCountriesByMovieId(idMovie, language);
        } catch (DAOException e) {
            throw new ServiceException("Error during getting countries by movieId", e);
        }
        return countryList;
    }

    @Override
    public List<Country> getAllCountries(String language) throws ServiceException {
        List<Country> countryList;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            CountryDAO countryDAO = daoFactory.getCountryDAO();
            countryList = countryDAO.getAllCountries(language);
        } catch (DAOException e) {
            throw new ServiceException("Error during getting all countries", e);
        }
        return countryList;
    }

    @Override
    public Country getCountryByCode(String countryCode, String currentLanguage)
            throws ServiceException {
        Country country;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            CountryDAO countryDAO = daoFactory.getCountryDAO();
            country = countryDAO.getCountryByCode(countryCode, currentLanguage);
        } catch (DAOException e) {
            throw new ServiceException("Error during getting country by code", e);
        }
        return country;
    }
}
