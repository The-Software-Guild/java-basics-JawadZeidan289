package com.assessment.dvdlib.model;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    // entries are title,dvd pairs
    private final Map<String, Dvd> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "dvdcollection.txt";
    public static final String DELIMITER = "::";

    @Override
    public boolean addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadLibrary();
        if(dvds.get(title) == null) {
            dvds.put(title, dvd);
            writeToFile();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeToFile();
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd newDvd) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd replacedDvd = dvds.replace(title, newDvd);
        writeToFile();
        return replacedDvd;
    }

    @Override
    public List<Dvd> listAllDvds() throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd listSingleDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    private Dvd unmarshallDvd(String inputLine) {
        // convert line from file into DVD object
        String[] partitions = inputLine.split(DELIMITER);

        System.out.println(partitions.length);

        String title = partitions[0];
        String releaseDate = partitions[1];
        String MPAA = partitions[2];
        String director = partitions[3];
        String studio = partitions[4];
        int rating = Integer.parseInt(partitions[5]);
        String sideNote = partitions[6];


        Dvd newDvd = new Dvd(title, releaseDate, MPAA, director, studio, rating, sideNote);
        return newDvd;
    }

    private String marshallDvd(Dvd dvdToConvert) {
        // convert DVD object into string to save to file
        String output = dvdToConvert.getTitle() + DELIMITER;
        output+= dvdToConvert.getReleaseDate() + DELIMITER;
        output+= dvdToConvert.getMpaaRating() + DELIMITER;
        output+= dvdToConvert.getDirectorName() + DELIMITER;
        output+= dvdToConvert.getStudio() + DELIMITER;
        output+= dvdToConvert.getUserRating() + "" + DELIMITER;
        output+= dvdToConvert.getSideNote();

        return output;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "Could not load DVD library into memory.", e);
        }

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Dvd newDvd = unmarshallDvd(line);

            dvds.put(newDvd.getTitle(), newDvd);

        }
        scanner.close();
    }

    private void writeToFile() throws DvdLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        List<Dvd> dvds = listAllDvds();

        for(Dvd d : dvds) {

            String line = marshallDvd(d);

            out.println(line);

            out.flush();
        }
        out.close();
    }
}
