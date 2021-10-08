package com.assessment.dvdlib.model;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    // entries are title,dvd pairs
    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "dvdcollection.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd() {
        return null;
    }

    @Override
    public Dvd removeDvd() {
        return null;
    }

    @Override
    public Dvd editDvd() {
        return null;
    }

    @Override
    public List<Dvd> listAllDvds() {
        return null;
    }

    @Override
    public Dvd listSingleDvd() {
        return null;
    }

    @Override
    public Dvd searchForDvd() {
        return null;
    }
}
