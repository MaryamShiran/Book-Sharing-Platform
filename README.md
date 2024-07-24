# Book-Sharing Platform

## Overview
This Java-based project is a comprehensive solution for managing a library online. It provides distinct interfaces for both members and controllers of the library, enabling them to interact with the system efficiently.

## Features

### For Members
- **View Books:** Members can view the list of books along with their publication years.
- **Add Books:** Members have the ability to contribute new books to the library's collection.
- **Request Books:** Members can make requests for books they wish to borrow.

### For Controllers
- **Add Books:** Controllers can add new books to the library's inventory.
- **Manage Requests:** Controllers can review and process book requests made by members. The system ensures that requests are fulfilled in the order they were received, provided the requested books are available.

## User Workflow

### Initial Menu
Upon launching the application, users are greeted with a menu asking whether they are a controller or a member.

### Controller Access
- **Authentication:** Controllers must enter a password. Upon successful authentication, they gain access to the controller menu.

### Member Access
- **Sign Up:** New members can sign up by providing a password, after which they receive a unique member ID. They then gain access to the member menu.
- **Sign In:** Existing members can sign in using their member ID and password to access the member menu.

## Menus and Options

### Member Menu
1. **Show All Books:** Displays the entire collection of books in the library.
2. **Make a Request:** Allows members to request books for borrowing.
3. **Add Book to Library:** Enables members to add new books to the library's collection.
4. **Exit:** Saves all persistent data and terminates the program.

### Controller Menu
1. **Check Requests:** Allows controllers to review and process member requests.
2. **Add Book to Library:** Enables controllers to add new books to the library's collection.
3. **Exit:** Saves all persistent data and terminates the program.

## Data Persistence
All data is saved when the program exits and is reloaded upon the next run, ensuring that no information is lost between sessions.
