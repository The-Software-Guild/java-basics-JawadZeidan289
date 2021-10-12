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
                printDvdDetails(d);
            }
        }
    }

    public void printDvdDetails(Dvd dvd) {
        io.print("Title: " + dvd.getTitle() + " - " +
                "Release date: " + dvd.getReleaseDate() + " - " +
                "MPAA Rating: " + dvd.getMpaaRating() + " - " +
                "Director: " + dvd.getDirectorName() + " - " +
                "Studio: " + dvd.getStudio() + " - " +
                "User Rating: " + dvd.getUserRating() + " - " +
                "Note: " + dvd.getSideNote());
    }

    public int printEditMenuAndGetInput() {
        io.print("");
        io.print("Edit Menu");
        io.print("1. Release Date");
        io.print("2. MPAA Rating");
        io.print("3. Director");
        io.print("4. Studio");
        io.print("5. User Rating");
        io.print("6. Note");
        io.print("7. Go Back");

        return io.readInt("What would you like to edit?", 1,7);
    }

    public Dvd editReleaseDate(Dvd dvdToEdit) {
        String newDate = io.readString("What would you like to change the release date to?");
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setReleaseDate(newDate);
        return newDvd;
    }

    public Dvd editMPAA(Dvd dvdToEdit) {
        String newMPAA = io.readString("What would you like to change the MPAA rating to?");
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setMpaaRating(newMPAA);
        return newDvd;
    }

    public Dvd editDirector(Dvd dvdToEdit) {
        String newDirector = io.readString("What would you like to change the director to?");
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setDirectorName(newDirector);
        return newDvd;
    }

    public Dvd editStudio(Dvd dvdToEdit) {
        String newStudio = io.readString("What would you like to change the studio to?");
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setStudio(newStudio);
        return newDvd;
    }

    public Dvd editUserRating(Dvd dvdToEdit) {
        int newRating = io.readInt("What would you like to change the user rating to?", 1, 5);
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setUserRating(newRating);
        return newDvd;
    }

    public Dvd editNote(Dvd dvdToEdit) {
        String newNote = io.readString("What would you like to change the side note to?");
        Dvd newDvd = copyContentsOver(dvdToEdit);
        newDvd.setSideNote(newNote);
        return newDvd;
    }

    public Dvd copyContentsOver(Dvd original) {
        Dvd newDvd = new Dvd(original.getTitle(), original.getReleaseDate(), original. getMpaaRating(),
                original.getDirectorName(), original.getStudio(), original.getUserRating(),
                original.getSideNote());
        return newDvd;
    }

    public String getDvdTitle() {
        return io.readString("Please enter DVD title");
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

    public void displayNoRecordMessage() {
        io.print("=== No such record ===");
    }

    public void displayRemovalSuccessMessage() {
        io.print("DVD Removed Successfully!");
    }

    public void displayAddSuccessMessage() {
        io.print("DVD Added Successfully!");
    }

    public void displayRecordAlreadyExistsMessage() {
        io.print("=== DVD already exists ===");
    }
}
