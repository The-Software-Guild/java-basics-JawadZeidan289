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

    public void editDvd() {
        view.displayEditDvdBanner();
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
        view.printDvdDetails(dvd);
    }
}
