package org.example;

import java.util.Scanner;

import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * this is a member class once a member sign up or sign in
 * we will have obj of this class
 *
 */
public class Member {

    private int memberid;


    private  Library Library = new Library();


    /**
     * this is a constructor method which calls the request loader
     */



    public Member() {



        FileManagement.requestloader();



    }
    /**
     * this the first method that when a member sign in or sign up will be called
     */

    public void run() {


        views.memberinitilizerview(memberid);




    }

    /**
     * setter method for memberid
     * @param id
     */

    public void memberidSetter(int id) {
        this.memberid=id;
    }
}
