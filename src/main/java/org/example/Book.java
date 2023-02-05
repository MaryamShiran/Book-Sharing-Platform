package org.example;

public class Book {



    private String bookname;
    private int publishyear;

    /**
     * it is a getter method bookname
     * @return
     */




    public String getName() {
        return this.bookname;
    }
    /**
     * this is a getter method for publishyear
     * @return
     */


    public int getpublishyear() {
        return this.publishyear;
    }
    /**
     * this is a setter method for bookname
     * @param name
     */

    public void setName(String name) {
        this.bookname=name;
    }
    /**
     * this is a setter method for publishyear
     * @param publishyear
     */


    public void setpublishyear(int publishyear) {
        this.publishyear=publishyear;
    }

}
