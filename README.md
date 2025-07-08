# Quantum Bookstore – Fawry Internship Challenge

This project is a solution for the Fawry N² Dev Slope #10 Full Stack Internship challenge.  
It simulates an online bookstore system that manages different types of books and supports adding, removing, and purchasing them.

---

## Features

- Add books of different types to the inventory:
    - `PaperBook`: Has stock and may be shipped
    - `EBook`: Has a filetype and may be emailed
    - `DemoBook`: Showcase book, not for sale

- Remove outdated books based on publication year

- Buy books by ISBN
    - For `PaperBook`: Reduces stock and sends to a shipping service
    - For `EBook`: Sends via email (only one copy per order)
    - For `DemoBook`: Cannot be purchased

## How to Test

Run the class `QuantumBookstoreFullTest.java`. It performs the following operations:

- Adds books to inventory
- Removes books published more than 10 years ago
- Buys books (paper and ebook)
- Handles and prints edge cases such as:
    - Out-of-stock errors
    - Buying more than one copy of an eBook
    - Buying an eBook without providing an email
    - Attempting to purchase a demo book
---


