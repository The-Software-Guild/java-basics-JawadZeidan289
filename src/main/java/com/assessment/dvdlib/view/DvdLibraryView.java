package com.assessment.dvdlib.view;

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuandGetInput() {
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove Existing DVD");
        io.print("3. Edit Existing DVD");
        io.print("4. List all DVDs");
        io.print("5. Search for particular DVD");
        io.print("6. Exit");

        return io.readInt("What would you like to do?", 1,6);
    }

    public void printGoodbyeMessage() {
        io.print("Goodbye!");
    }
}
