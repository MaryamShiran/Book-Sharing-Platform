package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * this class manages all files in program it works like database
 */
public class FileManagement {

    /**
     * this method loads requests file in to an array of requests
     */


    public static void requestloader() {


        File file = new File("requests.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }




        File file2 = new File("requesters.txt");
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(file2);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }





        String name;
        String memberid1;
        int memberid;

        while(sc.hasNextLine()) {

            name=sc.nextLine();
            memberid1=sc2.nextLine();
            memberid=Integer.parseInt(memberid1);


            request nb=new request();
            nb.setKarbaridrequesting(memberid);
            nb.setRequestedbookname(name);

            request.requests.add(nb);

        }
        sc.close();
        sc2.close();

    }


    /**
     * this method gets member id as a parameter and checks the file to return password of this id
     */
    public static String passwordOfuser(int memberid){


        File file = new File("passwords.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        String p = null;
        for(int x=1;x<= memberid;++x) {
            if(sc.hasNext()) {
                p=sc.nextLine();}
            else {
                p=null;
            }

        }


        return p;


    }

    /**
     * this method takes a password and append it to passwords file , we use it when a user signs up
     */


    public static int fileNewUserAdder(String a){


        FileWriter fw = null;
        try {
            fw = new FileWriter("passwords.txt",true);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } //the true will append the new data
        try {
            fw.write(a);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }//appends the string to the file
        try {
            fw.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }




        File file = new File("passwords.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }


        int j=0;


        while(sc.hasNextLine()) {

            sc.nextLine();
            ++j;
        }
        sc.close();





        return j;

    }

    /**
     * this method delets all files related to requests when the requests are checked this will be used
     */


    public static void requestnewer(){

        File file = new File("requests.txt");
        file.delete();

        File file2 = new File("requesters.txt");
        file2.delete();


    }
    /**
     * this method writes requests to request file
     */



    public static void requestfilerewrite() {


        int x=request.requests.size();


        String requestsbooknames="";
        String requesterids="";



        for (int u=0;u<x;u++) {


            request y= request.requests.get(u);

            String bookname=y.getRequestedbookname();
            requestsbooknames=requestsbooknames+bookname+"\n";
            int id=y.getKarbaridrequesting();
            requesterids=requesterids+id+"\n";




        }



        BufferedWriter f_writer1 = null;
        try {
            f_writer1 = new BufferedWriter(new FileWriter("requests.txt"));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        BufferedWriter f_writer2 = null;
        try {
            f_writer2 = new BufferedWriter(new FileWriter("requesters.txt"));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try {
            f_writer1.write(requestsbooknames);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            f_writer2.write(requesterids);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        try {
            f_writer1.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            f_writer2.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    /**
     * this method loads booknames files and bookpublishyear files
     * makes objects for books
     * returns array of objects it has made
     */



    public static ArrayList<Book> libraryloader() {

        ArrayList<Book> books=new ArrayList<>();

        File file = new File("Booksnames.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }




        File file2 = new File("Bookspublishyear.txt");
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(file2);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }





        String name;
        String publishyear1;
        int publishyear;

        while(sc.hasNextLine()) {

            name=sc.nextLine();
            publishyear1=sc2.nextLine();
            publishyear=Integer.parseInt(publishyear1);



            Book nb=new Book();

            nb.setpublishyear(publishyear);
            nb.setName(name);


            books.add(nb);



        }
        sc.close();
        sc2.close();

        return books;




    }
    /**
     * this method takes array of Books as parameter and Write them in files booknames and bookpublishyears
     */


    public static void LibraryReWrite(ArrayList<Book> books) {



        String s="";
        String p="";
        for(Book y:books) {
            s=s+y.getName()+"\n";
            p=p+y.getpublishyear()+"\n";

        }





        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("Booksnames.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            myWriter.write(s);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        FileWriter myWriter2 = null;
        try {
            myWriter2 = new FileWriter("Bookspublishyear.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            myWriter2.write(p);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            myWriter2.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }





}
