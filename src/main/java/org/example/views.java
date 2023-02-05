package org.example;

import java.util.Scanner;
/**
 * in this class we have all the menus in the program
 */
public class views {
    static Member Member ;
    static Controller controller ;

    /**
     * this method shows the usual menu the member see after sign up or sign in
     */


    public static void memberView(int memberid){




        while(true) {
            System.out.println("what do you want me to do");
            System.out.print("1.show all books\n2.make a request\n3.add book to library\n4.exit\n");

            Scanner scanner=new Scanner(System.in);

            String l1 = scanner.nextLine();
            int l=Integer.parseInt(l1);


            if(l==1) {
                Library.showAllBooks();
            }
            else if (l==2) {




                if(!(request.doeshavereq(memberid))==true) {






                    String pl = scanner.nextLine();




                    request.makereq(pl,memberid);




                }
                else {
                    System.out.print("you have had your request recently \n you can not have any more\n");
                }


            }
            else if (l==3) {

                System.out.print("pleas enter the book name");

                String bookname = scanner.nextLine();



                System.out.print("pleas enter its pubishyear");

                String bookpublishyear = scanner.nextLine();
                int publishyear=Integer.parseInt(bookpublishyear);



                Library.addBook( bookname, publishyear);


            }
            else if(l==4) {

                Library.rewritefile();
                FileManagement.requestfilerewrite();

                System.out.println("goodbuy:)");

                break;

            }
            else {
                System.out.println("invalid");

            }


        }



    }

    /**
     * this method shows the menu the controller sees after signing in
     */

    public static void programControllerView(){


        while(true) {



            Scanner scanner = new Scanner(System.in);


            System.out.println("what do you want me to do");
            System.out.print("1.check the requests\n2.add book to library \n3.exit\n");


            String command = scanner.nextLine();
            int c=Integer.parseInt(command);




            if(c==1) {




                request.requestcheker();




            }
            else if(c==2) {



                System.out.print("pleas enter the book name");

                String bookname = scanner.nextLine();



                System.out.print("pleas enter its publishyear");

                String bookpublishyear1 = scanner.nextLine();
                int bookpublishyear=Integer.parseInt(bookpublishyear1);



                Library.addBook( bookname, bookpublishyear);



            }
            else if (c==3) {

                Library.rewritefile();
                System.out.println("goodbuy:)");

                break;

            }
            else {
                System.out.println("invalid");

            }




        }





    }
    /**
     * this method shows the initial menu after running program that asks weather you are a controller oe a member
     */

    public static void firstView() {

        System.out.println("Are you a controler or a member ?");
        System.out.println("Press 1 if you are a controler and 0 if you are a member");


        Scanner scanner = new Scanner(System.in);
        String t1 = scanner.nextLine();
        int t=Integer.parseInt(t1);




        if(t==0) {



            Member = new Member();

            Member.run();


        }
        else if(t==1) {

            Controller Controller = new Controller();

            Controller.run();


        }
        else {
            System.out.println("invalid");


        }


    }
    /**
     * this method shows the menu for member in order to sighing in
     * @param memberid
     */



    public static void MemberSighnin(int memberid) {

        System.out.println("Enter your ID");


        Scanner scanner=new Scanner(System.in);
        String cid1 = scanner.nextLine();
        memberid=Integer.parseInt(cid1);
        Member.memberidSetter(memberid);



        System.out.println("Enter password");

        String	password = scanner.nextLine();



        String p=FileManagement.passwordOfuser(memberid);


        if (p==null) {
            System.out.println("invalid");

        }

        else if(p.equals(password)) {


            views.memberView(memberid);



        }
        else {
            System.out.println("invalid");

        }




    }
    /**
     * this method shows the menu for member in order to sighing up
     */


    public static void Membersighnup(int memberid) {


        System.out.println("Enter password");

        Scanner scanner=new Scanner(System.in);
        String np = scanner.nextLine();

        np=np+"\n";




        memberid =	FileManagement.fileNewUserAdder(np);
        Member.memberidSetter(memberid);


        System.out.println("your member-id is "+memberid+" keep it to use library next time");


        views.memberView(memberid);

    }
    /**
     * this method shows the menu that asks member whether is new or not
     */

    public static void memberinitilizerview(int memberid) {




        System.out.println("Are you new ?");
        System.out.println("Press 1 if you are new and 0 otherwise");
        Scanner scanner = new Scanner(System.in);
        String e1 = scanner.nextLine();
        int e=Integer.parseInt(e1);

        if(e==1) {


            views.Membersighnup(memberid);





        }
        else if (e==0) {

            views.MemberSighnin(memberid);


        }
        else {
            System.out.println("invalid");

        }









    }

    /**
     * this method shows the menu for controller sighn in
     */


    public static void controllersighnin(String pcpass) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("enter password");

        String pc = scanner.nextLine();


        if(pc.equals(pcpass)) {
            System.out.println("welcom\n");

            views.programControllerView();
        }

        else {
            System.out.println("Wrong password");


        }







    }




}