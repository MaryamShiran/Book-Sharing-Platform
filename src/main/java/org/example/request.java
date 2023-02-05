package org.example;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;
/**
 * each request is an object of this class
 * this  class has functions to help us managing requests
 */

public class request {


    private String requestedbookname;

    private int karbaridrequesting;


    public static 	ArrayList<request> requests = new ArrayList<>();

    /**
     * this method checks the reuests and determines wether each user get the book she/he wants or not
     */



    public static void requestcheker(){
        int y =requests.size();

        for(int r =0;r<y;++r) {
            request q =requests.get(r);
            String bookname=q.getRequestedbookname();
            int memberid=q.getKarbaridrequesting();

            boolean doesget=Library.doesgoet(bookname);
            if (doesget==true) {
                System.out.println("member id "+memberid+" gets the book "+bookname);

            }
            else {
                System.out.println("sorry we cant give memberid"+memberid+" the book she/he wants");
            }




        }




        FileManagement.requestnewer();




    }
    /**
     *
     * @param bookname
     * @param memberid
     * this method makes new obj of requests wirh the given parameters and add this request to list of requests
     */

    public static void makereq(String bookname ,int memberid) {




        request nreq = new request();
        nreq.setRequestedbookname(bookname);
        nreq.setKarbaridrequesting(memberid);


        requests.add(nreq);




    }
    /**
     *
     * @param karbarid
     *
     * @return whether this id has requsted recently or not
     */

    public static boolean doeshavereq(int karbarid) {



        for (request req:requests) {
            if (req.getKarbaridrequesting()==karbarid) {
                return true;}

        }


        return false;




    }

    /**
     * this method is getter of bookname
     * @return
     */





    public String getRequestedbookname() {
        return requestedbookname;
    }
    /**
     *
     * @param requestedbookname
     * this method is setter of bookname
     */


    public void setRequestedbookname(String requestedbookname) {
        this.requestedbookname = requestedbookname;
    }
    /**
     * this method is getter of getKarbaridrequesting
     * @return
     */

    public int getKarbaridrequesting() {
        return karbaridrequesting;
    }
    /**
     *
     * @param karbaridrequesting
     * this method is setter of karbaridrequesting
     */


    public void setKarbaridrequesting(int karbaridrequesting) {
        this.karbaridrequesting = karbaridrequesting;
    }



}
