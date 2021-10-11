package com.assessment.dvdlib.model;

import java.util.List;

public interface DvdLibraryDao {

    boolean addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    Dvd editDvd(String title, Dvd newDvd) throws DvdLibraryDaoException;

    List<Dvd> listAllDvds() throws DvdLibraryDaoException;

    Dvd listSingleDvd(String title) throws DvdLibraryDaoException;

}
