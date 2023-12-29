package org.example.task1;

import java.util.ArrayList;
import java.util.List;

public class LibraryV2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));

        // Поиск книг, написанных автором "Лев Толстой"
        books.stream()
                .filter(book -> book.getAuthor().equals("Лев Толстой"))
                .forEach(System.out::println);

        // Поиск книг, изданных после 1866 года
        books.stream()
                .filter(book -> book.getYear() > 1866)
                .forEach(System.out::println);

        //Поиск уникальных книг
        books.stream()
                .map(Book::getTitle)
                .distinct()
                .forEach(System.out::println);
    }
}
