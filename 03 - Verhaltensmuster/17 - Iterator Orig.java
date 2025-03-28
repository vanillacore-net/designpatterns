class BookCollection {
    private Book[] books;
    private int numberOfBooks;
    
    public BookCollection(int size) {
        books = new Book[size];
        numberOfBooks = 0;
    }
    
    public void addBook(Book book) {
        if (numberOfBooks < books.length) {
            books[numberOfBooks] = book;
            numberOfBooks++;
        }
    }
    
    public Book[] getBooks() {
        return books;
    }
    
    public int getNumberOfBooks() {
        return numberOfBooks;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Before - Without Iterator:");
        BookCollection oldCollection = new BookCollection(3);
        oldCollection.addBook(new Book("The Hobbit"));
        oldCollection.addBook(new Book("1984"));
        oldCollection.addBook(new Book("Pride and Prejudice"));
        
        Book[] books = oldCollection.getBooks();
        int size = oldCollection.getNumberOfBooks();
        for (int i = 0; i < size; i++) {
            System.out.println(books[i].getTitle());
        }
    }
}