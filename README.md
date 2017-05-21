# LibraryAutomationSystem

http://sce2.umkc.edu/BIT/burrise/pl/case-studies/old-library/

## Requirements
The library system should keep track of books as they are checked out, returned, put on reserve and renewed. It should enforce checkout rules (the "business logic" of the application) based on the borrowing privileges of the person checking out the library book.

The library offers books to two different types of library patrons: community patrons and patron scholars. Community patrons may check books out for 3 weeks and can have as many as 5 books checked out at a time. Patron scholars may check books out for 6 weeks and can have as many as 10 books checked out at a time. Community patrons may renew a book once for an additional 3 weeks as long as no one else has placed the book on reserve. Patron scholars may renew a book once for an additional 6 weeks as long as no one else has placed the book on reserve. Both community patrons and patron scholars may place a book on reserve.

The library may have more than one copy of the same book. The first use of the term refers to a specific copy of a book. The second use of the term refers to any one of possible several copies of a book with a specific title and author

The principle user of the system will be the librarian. The system should automate the manual functions performed today which are: check out, return, place a book on reserve, and renew a book. The system should also allow a patron or a librarian to search for a book based on title, author or key words.

## Use cases
###1. Case Title:	Check Out Book
Actors:	Librarian
Description:	
   1. This use case begins when a patron presents a book to the librarian for check out.
   2. First the librarian indicates which patron wishes to check out a book. The system verifies the patron hasn't reached his or her checkout limit. Community patrons may check out a maximum of 5 books at a time and patron scholars may check out 10 at a time. If the patron has reached his or her limit the librarian is notified and the use case ends without the book being checked out.
   3. If the patron hasn't reached his or her limit the system prompts the librarian for the book identity. The librarian provides the book identity and the system calculates the due date based on the privileges of the borrower. The system provides due date information to the librarian and records information about the transaction including patron identity, book identity and due date. Community patrons may check out a book for 3 weeks at a time and patron scholars may check out a book for 6 weeks at a time.
   
###2. Use Case Title:	Return Book
Actors:	Librarian
Description:	
   1. This use case begins when a book is returned.
   2. The librarian identifies the book to the system for check in.
   3. The system records that the book has been returned. This includes making the book available for checkout and reducing by one the number of books the patron has checked out.
   4. If the book had been placed on reserve the patron is notified the book is available and the librarian is instructed to place the book on the reserved stacks.
   
###3. Use Case Title:	Renew Book
Actors:	Librarian
Description:	
   1. This use case begins when a patron presents a book to the librarian for renewal.
   2. The librarian identifies the book to the system for renewal. The system checks to make sure the book hasn't been placed on reserve.
   3. If the book hasn't been placed on reserve the system updates the due date of the book according to the borrowing privileges of the patron. Community patrons may renew a book for 3 additional weeks and patron scholars may renew a book for 6 additional weeks from the date of renewal.
   
###4. Use Case Title:	Reserve Book
Actors:	Librarian
Description:
   1. This use case begins when a patron makes a request to a librarian to reserve a book.
   2. The librarian identifies to the system the book to be placed on reserve. The system prompts the librarian for patron information. The librarian provides the information and the system records this information. When the book placed on reserve is returned, the patron will be notified. (Note, notifying the patron when a reserved book has arrived is part of the Return Book use case.)   