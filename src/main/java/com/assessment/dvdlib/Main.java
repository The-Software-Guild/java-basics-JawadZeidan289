package com.assessment.dvdlib;

import com.assessment.dvdlib.controller.DvdLibraryController;
import com.assessment.dvdlib.model.DvdLibraryDao;
import com.assessment.dvdlib.model.DvdLibraryDaoFileImpl;
import com.assessment.dvdlib.view.DvdLibraryView;
import com.assessment.dvdlib.view.UserIO;
import com.assessment.dvdlib.view.UserIOConsoleImpl;

public class Main {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        DvdLibraryView view = new DvdLibraryView(io);
        DvdLibraryController controller = new DvdLibraryController(dao, view);
        controller.run();
    }
}
