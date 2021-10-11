package com.assessment.dvdlib.model;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    // entries are title,dvd pairs
    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "dvdcollection.txt";
    public static final String DELIMITER = "::";

    @Override
    public boolean addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        if(dvds.get(title) == null) {
            Dvd oldDvd = dvds.put(title, dvd);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        Dvd removedDvd = dvds.remove(title);
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd newDvd) throws DvdLibraryDaoException {
        Dvd replacedDvd = dvds.replace(title, newDvd);
        return replacedDvd;
    }

    @Override
    public List<Dvd> listAllDvds() throws DvdLibraryDaoException {
        return new ArrayList<>(dvds.values());
    }

    @Override
    public Dvd listSingleDvd(String title) throws DvdLibraryDaoException {
        return dvds.get(title);
    }
}
