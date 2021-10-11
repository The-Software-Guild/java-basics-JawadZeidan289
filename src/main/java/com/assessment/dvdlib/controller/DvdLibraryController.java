package com.assessment.dvdlib.controller;

import com.assessment.dvdlib.model.Dvd;
import com.assessment.dvdlib.model.DvdLibraryDao;
import com.assessment.dvdlib.model.DvdLibraryDaoException;
import com.assessment.dvdlib.view.DvdLibraryView;

import java.util.List;

public class DvdLibraryController {

    private DvdLibraryDao dao;
    private DvdLibraryView view;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        int menuSelection = 0;
        try {
            while (running) {

                menuSelection = getMenuSelection();

                switch(menuSelection) {
                    case 1:
                        //
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        searchForDvd();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        break;
                }
            }
            goodByeMessage();
        } catch(DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public int getMenuSelection() {
        return view.printMenuandGetInput();
    }

    public void goodByeMessage() {
        view.printGoodbyeMessage();
    }

    public void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
    }

    public void removeDvd() throws DvdLibraryDaoException  {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitle();
        dao.removeDvd(title);
        view.displayRemovalSuccessMessage();
    }

    public void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitle();
        Dvd dvd = dao.listSingleDvd(title);
        if(dvd != null) {
            view.printDvdDetails(dvd);
        } else {
            view.displayNoRecordMessage();
            return;
        }
        int option = view.printEditMenuAndGetInput();
        switch(option) {
            case 1:
                // change release date
                Dvd newDvdDate = view.editReleaseDate(dvd);
                dao.editDvd(newDvdDate.getTitle(), newDvdDate);
                break;
            case 2:
                // change MPAA Rating
                Dvd newDvdMPAA = view.editMPAA(dvd);
                dao.editDvd(newDvdMPAA.getTitle(), newDvdMPAA);
                break;
            case 3:
                // change Director
                Dvd newDvdDirector = view.editDirector(dvd);
                dao.editDvd(newDvdDirector.getTitle(), newDvdDirector);
                break;
            case 4:
                // change Studio
                Dvd newDvdStudio = view.editStudio(dvd);
                dao.editDvd(newDvdStudio.getTitle(), newDvdStudio);
                break;
            case 5:
                // change User Rating
                Dvd newDvdRating = view.editUserRating(dvd);
                dao.editDvd(newDvdRating.getTitle(), newDvdRating);
                break;
            case 6:
                // change Note
                Dvd newDvdNote = view.editNote(dvd);
                dao.editDvd(newDvdNote.getTitle(), newDvdNote);
                break;
            case 7:
                // go back
                return;
        }
    }

    public void listDvds() throws DvdLibraryDaoException {
        view.displayListDvdsBanner();
        List<Dvd> list = dao.listAllDvds();
        view.showAllDvds(list);
    }

    public void searchForDvd() throws DvdLibraryDaoException {
        view.displaySearchDvdBanner();
        String title = view.getDvdTitle();
        Dvd dvd = dao.listSingleDvd(title);
        if(dvd != null) {
            view.printDvdDetails(dvd);
        } else {
            view.displayNoRecordMessage();
        }
    }
}
