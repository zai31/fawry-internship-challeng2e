package org.quantumbookstore;

import model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestingQuantumBookstore {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Book paper1 = new PaperBook("001", "Clean Code", 2018, 250, "Robert C. Martin", 3);
        Book paper2 = new PaperBook("002", "Java Puzzlers", 2016, 200, "Joshua Bloch", 2);
        Book ebook1 = new Ebook("003", "Effective Java", 2021, 300, "Joshua Bloch", "pdf");
        Book demo = new DemoBook("004", "Design Patterns", 1994, 400, "gang of 4");

        inventory.addBook(paper1);
        inventory.addBook(paper2);
        inventory.addBook(ebook1);
        inventory.addBook(demo);

        System.out.println("\nInventory After Adding");
       inventory.printInventory();
        System.out.println("\nRemoving Outdated Books (>10 years old)");
     inventory.removeOutdatedBooks(10);
        System.out.println("\nInventory After Cleanup");
     inventory.printInventory();
        System.out.println("\nBuying PaperBook (success)");
        Book b1 = inventory.getBook("001");
        if (b1 instanceof ForSale) {
            try {
       ((ForSale) b1).buy("001", 3, "", "123 Main Street");


      } catch (Exception e) {
          System.out.println( e.getMessage());
        }
        }

        System.out.println("\nBuying PaperBook (should be out of stock)");
  try {
            ((ForSale) b1).buy("002", 3, "", "123 Main Street");

        } catch (Exception e) {
       System.out.println(e.getMessage());
        }

        // Buying EBook with invalid quantity
        System.out.println("\nBuying EBook (2 copies, should fail)");
   Book b2 = inventory.getBook("003");
        if (b2 instanceof ForSale) {
            try {
                double paid = ((ForSale) b2).buy("003", 2, "reader@example.com", "");
       System.out.println("Paid = " + paid);
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
        }
        // Buying EBook with no email
        System.out.println("\nBuying EBook (no email, should fail)");
        try {
       ((ForSale) b2).buy("003", 1, "", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Buying EBook correctly
        System.out.println("\nBuying EBook (success)");
        try {
            double paid = ((ForSale) b2).buy("003", 1, "reader@example.com", "");
            System.out.println( "paid : "+paid);
   } catch (Exception e) {
         System.out.println( e.getMessage());
        }

        // Attempt to buy showcase book
        System.out.println("\nAttempting to Buy demoBook");
        Book demoBook = inventory.getBook("004");
    if (demoBook instanceof ForSale) {
            try {
                ((ForSale) demoBook).buy("004", 1, "", "");
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
        } else {
            System.out.println("Showcase books are not for sale.");
        }

    }


}