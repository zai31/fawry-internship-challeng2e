package model;

import java.util.*;

public class Inventory {
    private Map<String, Book> inventory = new HashMap<>();


    public void addBook(Book book) {
        inventory.put(book.getId(), book);
        System.out.println(" Book added  " + book.getTitle());
    }


    public Book removeBook(String isbn) {
        return inventory.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int thresholdYears) {
        List<Book> outdated = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        int currentYear = java.time.Year.now().getValue();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > thresholdYears) {
                outdated.add(book);
                iterator.remove();
            }

        }
        return outdated;
    }


        public void printInventory () {
            System.out.println("Quantum bookstore: Inventory list");
            for (Book book : inventory.values()) {
                System.out.println("- " + book.getTitle() + " (" + book.getYear() + ")");
            }
        }

        public boolean contains (String isbn){
            return inventory.containsKey(isbn);
        }

        public Book getBook (String isbn){
            return inventory.get(isbn);
        }

}
