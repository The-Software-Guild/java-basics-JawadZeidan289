package com.assessment.dvdlib.controller;

import com.assessment.dvdlib.model.DvdLibraryDao;
import com.assessment.dvdlib.view.DvdLibraryView;

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
        while (running) {

            menuSelection = getMenuSelection();

            switch(menuSelection) {
                case 1:
                    //
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    break;
            }
        }
        goodByeMessage();
    }

    public int getMenuSelection() {
        return view.printMenuandGetInput();
    }

    public void goodByeMessage() {
        view.printGoodbyeMessage();
    }
}
