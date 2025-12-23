# Java Inventory Management System

A console-based e-commerce inventory management system written in Java.  
This project builds on concepts from an earlier Playlist Manager project, applying the same core ideas in a cleaner, more structured way with additional functionality such as sorting.

## Project Overview
The system manages an inventory of products across multiple categories (Electronics, Clothing, Groceries). Users can add, remove, search, sort, and persist inventory data using a text file.

While this project shares similarities with my earlier Playlist Manager (menu-driven interface, file input/output, and collection management), it was written with a stronger focus on cleaner organization, extensibility, and additional features.

## Key Improvements Over Playlist Manager
- Cleaner separation of responsibilities across classes
- Use of inheritance via a `Product` base class and category-specific subclasses
- Added sorting functionality (by price)
- More flexible file parsing and saving
- Improved menu flow and input handling

## Features
- Add products by category
- Display all inventory items
- Search for products by name
- Sort products by price
- Update product quantities
- Remove products from inventory
- Save inventory to a file
- Load inventory from a file

## Technologies Used
- Java
- Object-Oriented Programming (inheritance and polymorphism)
- Collections (HashMap)
- Sorting algorithms
- File I/O (BufferedReader / FileWriter)

## File Format
Inventory items are stored using a delimiter-separated format. The program supports multiple delimiters when loading, and saves data using the pipe (`|`) delimiter:

Category|id|name|price|quantity|warranty

Example:
Electronics|E1001|Headphones|49.99|12|24

## How to Run

### Run in an IDE (Recommended)
1. Open the project as a Java application
2. Run `Main.java`
3. Follow the console menu prompts

### Run from Terminal
Compile:
```bash
javac src/*.java
