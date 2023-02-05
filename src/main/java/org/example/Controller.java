package org.example;

public class Controller {

    String pcpass="approject";
    private  Library Library = new Library();
    /**
     * this is a constroctor method which  calls the request loader
     */


    public Controller() {



        FileManagement.requestloader();



    }
    /**
     * this is a run method which will be called once the karbar says that is a controller
     */

    public void run() {
        views.controllersighnin(pcpass);
    }


}
