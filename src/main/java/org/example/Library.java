package org.example;

import java.io.File;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * this class consists of array list of books and has methods for adding and deleting books and ...
 */

public class Library {

    private static ArrayList<Book> books = new ArrayList<>();
    /**
     * this is a constructor method which calls library loader once library is created
     */


    public Library(){
        books= FileManagement.libraryloader();


    }

    /**
     * this method shows all books in Library
     */



    public static void showAllBooks() {

        for(Book j:books) {
            System.out.print(j.getName()+" "+j.getpublishyear()+'\n');
        }

    }
    /**
     *
     * @param bookname
     * @param publishyear
     *
     * this method takes a book attributes to add it in library
     */


    public static void addBook(String bookname,int publishyear) {

        //TODO write in file of libarary
        Book newbook=new Book();
        newbook.setName(bookname);
        newbook.setpublishyear(publishyear);


        books.add(newbook);





    }

    /**
     *
     * @param bookname
     * @return whether this book exist to be given or not and it exists deletes it
     */
    public static boolean doesgoet(String bookname) {

        boolean flag= false ;

        Iterator <Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book bookn = iterator.next();
            if (bookn.getName().equals(bookname)) {
                books.remove(bookn);
                flag =true;
                break;

            }
        }

        if(flag==true) {
            return true;
        }


        return false;



    }



    /**
     * this method rewrites the libraryfile
     */



    public static void rewritefile() {



        FileManagement.LibraryReWrite(books);


    }


}
