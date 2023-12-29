package org.example.task1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));

        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if("Лев Толстой".equals(book.getAuthor()))
                authorBooks.add(book);
        }

        System.out.println("Книги Льва Толстого:\n" + authorBooks);

        List<Book> booksAfter1866 = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1866) {
                booksAfter1866.add(book);
            }
        }

        System.out.println("Книги, опубликованные после 1866 года:\n" + booksAfter1866);

        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }

        System.out.println("\nУникальные названия книг: \n" + uniqueTitles);
    }
}
