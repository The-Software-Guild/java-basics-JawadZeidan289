package com.assessment.dvdlib.view;

import com.assessment.dvdlib.model.Dvd;

import java.util.List;

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuandGetInput() {
        io.print("");
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove Existing DVD");
        io.print("3. Edit Existing DVD");
        io.print("4. List all DVDs");
        io.print("5. Search for particular DVD");
        io.print("6. Exit");

        return io.readInt("What would you like to do?", 1,6);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter DVD release date");
        String mpaaRating = io.readString("Please enter MPAA Rating (e.g. PG, 16+ etc)");
        String directorsName = io.readString("Please enter Director's name");
        String studio = io.readString("Please enter Studio name");
        int userRating = io.readInt("Please enter User Rating", 1, 10);
        String sideNote = io.readString("Please enter any additional comments");
        Dvd newDvd = new Dvd(title, releaseDate, mpaaRating,
                directorsName, studio, userRating, sideNote);
        return newDvd;
    }

    public void showAllDvds(List<Dvd> list) {
        if(list.isEmpty()) { io.print("No DVD records"); } else {
            for(Dvd d : list) {
                io.print("Title: " + d.getTitle() + " - " +
                        "Release date: " + d.getReleaseDate() + " - " +
                        "MPAA Rating: " + d.getMpaaRating() + " - " +
                        "Director: " + d.getDirectorName() + " - " +
                        "Studio: " + d.getStudio() + " - " + d.getUserRating() + " - " +
                        "Note: " + d.getSideNote());
            }
        }
    }

    public void printGoodbyeMessage() {
        io.print("Goodbye!");
    }

    public void displayAddDvdBanner() {
        io.print("=== Add new DVD ===");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove existing DVD ===");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit existing DVD ===");
    }

    public void displayListDvdsBanner() {
        io.print("=== List all DVDs ===");
    }

    public void displaySearchDvdBanner() {
        io.print("=== Search for existing DVD ===");
    }

    public void displayErrorMessage(String msg) {
        io.print("=== ERROR ===");
        io.print(msg);
    }
}
