package com.assessment.dvdlib.model;

import java.util.List;

public interface DvdLibraryDao {

    Dvd addDvd() throws DvdLibraryDaoException;

    Dvd removeDvd() throws DvdLibraryDaoException;

    Dvd editDvd() throws DvdLibraryDaoException;

    List<Dvd> listAllDvds() throws DvdLibraryDaoException;

    Dvd listSingleDvd() throws DvdLibraryDaoException;

    Dvd searchForDvd() throws DvdLibraryDaoException;

}
