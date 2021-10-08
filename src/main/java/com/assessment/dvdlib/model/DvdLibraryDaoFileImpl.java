package com.assessment.dvdlib.model;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    // entries are title,dvd pairs
    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "dvdcollection.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        Dvd oldDvd = dvds.put(title, dvd);
        return oldDvd;
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException { return null; }

    @Override
    public Dvd editDvd(String title) throws DvdLibraryDaoException { return null; }

    @Override
    public List<Dvd> listAllDvds() throws DvdLibraryDaoException {
        return new ArrayList<>(dvds.values());
    }

    @Override
    public Dvd listSingleDvd(String title) throws DvdLibraryDaoException { return null; }
}
