package com.assessment.dvdlib.model;

import java.util.List;

public interface DvdLibraryDao {

    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    Dvd editDvd(String title) throws DvdLibraryDaoException;

    List<Dvd> listAllDvds() throws DvdLibraryDaoException;

    Dvd listSingleDvd(String title) throws DvdLibraryDaoException;

}
