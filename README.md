# Case Study for OOP - Library Automation

## Requirements
The library system should keep track of books as they are checked out, returned, put on reserve and renewed. It should enforce checkout rules (the "business logic" of the application) based on the borrowing privileges of the person checking out the library book.

The library offers books to two different types of library patrons: community patrons and patron scholars. Community patrons may check books out for 3 weeks and can have as many as 5 books checked out at a time. Patron scholars may check books out for 6 weeks and can have as many as 10 books checked out at a time. Community patrons may renew a book once for an additional 3 weeks as long as no one else has placed the book on reserve. Patron scholars may renew a book once for an additional 6 weeks as long as no one else has placed the book on reserve. Both community patrons and patron scholars may place a book on reserve.

The library may have more than one copy of the same book. The first use of the term refers to a specific copy of a book. The second use of the term refers to any one of possible several copies of a book with a specific title and author

The principle user of the system will be the librarian. The system should automate the manual functions performed today which are: check out, return, place a book on reserve, and renew a book. The system should also allow a patron or a librarian to search for a book based on title, author or key words.

http://sce2.umkc.edu/BIT/burrise/pl/case-studies/old-library/

## Use cases

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/use-cases.gif "use-cases")

### 1. Case Title:	Check Out Book
Actors:	Librarian

Description:	
   1. This use case begins when a patron presents a book to the librarian for check out.
   2. First the librarian indicates which patron wishes to check out a book. The system verifies the patron hasn't reached his or her checkout limit. Community patrons may check out a maximum of 5 books at a time and patron scholars may check out 10 at a time. If the patron has reached his or her limit the librarian is notified and the use case ends without the book being checked out.
   3. If the patron hasn't reached his or her limit the system prompts the librarian for the book identity. The librarian provides the book identity and the system calculates the due date based on the privileges of the borrower. The system provides due date information to the librarian and records information about the transaction including patron identity, book identity and due date. Community patrons may check out a book for 3 weeks at a time and patron scholars may check out a book for 6 weeks at a time.
   
### 2. Use Case Title:	Return Book
Actors:	Librarian

Description:	
   1. This use case begins when a book is returned.
   2. The librarian identifies the book to the system for check in.
   3. The system records that the book has been returned. This includes making the book available for checkout and reducing by one the number of books the patron has checked out.
   4. If the book had been placed on reserve the patron is notified the book is available and the librarian is instructed to place the book on the reserved stacks.
   
### 3. Use Case Title:	Renew Book
Actors:	Librarian

Description:	
   1. This use case begins when a patron presents a book to the librarian for renewal.
   2. The librarian identifies the book to the system for renewal. The system checks to make sure the book hasn't been placed on reserve.
   3. If the book hasn't been placed on reserve the system updates the due date of the book according to the borrowing privileges of the patron. Community patrons may renew a book for 3 additional weeks and patron scholars may renew a book for 6 additional weeks from the date of renewal.
   
### 4. Use Case Title:	Reserve Book
Actors:	Librarian

Description:
   1. This use case begins when a patron makes a request to a librarian to reserve a book.
   2. The librarian identifies to the system the book to be placed on reserve. The system prompts the librarian for patron information. The librarian provides the information and the system records this information. When the book placed on reserve is returned, the patron will be notified. (Note, notifying the patron when a reserved book has arrived is part of the Return Book use case.)
   
## Analysis

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/analysis-abstractions.gif "analysis-abstractions")

* In the above diagram the class Book represents the generic concept of a book. Associated with Book are author, title, ISBN, etc. The class CopyOfBook represents a specific instance of a book. 
* A patron would renew a CopyOfBook and place on reserve a Book. The class Patron generalizes CommunityPatron and PatronScholar. Behavior and data shared by both types of patrons can be represented once in the class Patron.

## Design

To identify what data and behavior needs to be distributed among design modules. To determine this we can use the noun/verb analysis technique. Rereading the requirements and use cases we can identify the following data items that need to be recorded:

* number of books each patron has checked out
* which books a patron has checked out
* maximum number of books a patron is allowed to check out
* duration patron is allowed to check out a book
* the status of a book (checked out, checked in, on reserve)
* title and other identifying information on a book
* contact information about each patron.

Distributing that data among the analysis classes identified above:

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/class-diagram-design.png "class-diagram-design")

The next step is to assign behaviors. (Note, in practice it may be easier to add attribute and behavior at the same time.) The use case names suggest major procedures or behaviors we will expect from the system:
* reserve book
* checkout book
* return book
* renew book

Now we add the procedures. Guidelines for deciding where to add a procedure:
1. Add procedures to the class that has most of the data the procedure needs to operate.
2. The operation should also make sense for the class where the procedure is added

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/class-diagram-design-with-operations.png "class-diagram-design-with-operations")

Patron attributes for maxBooks and checkoutDuration are calculated values. They depend on the type of patron. This suggests a better way to implement these attributes is via operations and inheritance.

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/patron-inheritance.gif "patron-inheritance")

## Class Diagram

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/ClassDiagram.png "Class Diagram")

## Sequence Diagram

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/seq-check-out-book.png "seq-check-out-book")

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/seq-renew-book.png "seq-renew-book")

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/seq-reserve-book.png "seq-reserve-book")

![alt text](https://github.com/vudph/LibraryAutomationSystem/blob/master/resources/seq-return-book.png "seq-return-book")
