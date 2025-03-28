// Step 1: Define the Iterator interface
interface BookIterator {
    boolean hasNext();
    Book next();
}

// Step 2: Define the Collection interface
interface BookCollectionInterface {
    BookIterator getIterator();
}

// Step 3: Implement the Collection
class BetterBookCollection implements BookCollectionInterface {
    private Book[] books;
    private int numberOfBooks;
    
    public BetterBookCollection(int size) {
        books = new Book[size];
        numberOfBooks = 0;
    }
    
    public void addBook(Book book) {
        if (numberOfBooks < books.length) {
            books[numberOfBooks] = book;
            numberOfBooks++;
        }
    }
    
    // Provide iterator instead of exposing internal structure
    public BookIterator getIterator() {
        return new BookArrayIterator();
    }
    
    // Step 4: Implement the Iterator
    private class BookArrayIterator implements BookIterator {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < numberOfBooks;
        }
        
        @Override
        public Book next() {
            if (!hasNext()) {
                throw new RuntimeException("No more books!");
            }
            return books[currentIndex++];
        }
    }
}

// Simple Book class
class Book {
    private String title;
    
    public Book(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}

// Usage example
class Main {
    public static void main(String[] args) {
        System.out.println("\nAfter - With Iterator:");
        BetterBookCollection newCollection = new BetterBookCollection(3);
        newCollection.addBook(new Book("The Hobbit"));
        newCollection.addBook(new Book("1984"));
        newCollection.addBook(new Book("Pride and Prejudice"));
        
        showBooks(newCollection);
    }

    public void showBooks(BetterBookCollection books) {
        BookIterator iterator = books.getIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getTitle());
        }
    }
}