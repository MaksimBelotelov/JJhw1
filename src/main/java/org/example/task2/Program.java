package org.example.task2;

import java.util.Scanner;

public class Program {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UMarket market = new UMarket();
        System.out.println("Добро пожаловать в магазин U-Market");

        while (true) {
            System.out.println("============================================");
            System.out.println("0 - Завершение работы");
            System.out.println("1 - Отобразить полный список товаров");
            System.out.println("2 - Сформировать онлайн корзину из снеков");
            System.out.println("3 - Сформировать онлайн корзину из полуфабрикатов");
            System.out.println("4 - Сформировать онлайн корзину из здоровых продуктов");
            System.out.println("5 - Сформировать онлайн корзину из любых продуктов");
            System.out.println("Выберите пункт меню: ");

            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                scanner.nextLine();

                switch (n) {
                    case 0 -> {
                        System.out.println("Завершение работы");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Список товаров:");
                        market.printThings(Thing.class);
                    }
                    case 2 -> createCart(Snack.class, market);
                    case 3 -> createCart(SemiFinishedFood.class, market);
                    case 4 -> createCart(HealthyFood.class, market);
                    case 5 -> createCart(Food.class, market);
                }
            }
            else {
                System.out.println("Некорректный пункт меню. \nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }

    static <T extends Food> void createCart(Class<T> clazz, UMarket market) {
        Cart<T> cart = new Cart<>(clazz, market);

        while(true) {
            System.out.println("Список доступных товаров: ");
            System.out.println("[0] Завершение формирования корзины + балансировка");
            market.printThings(clazz);
            System.out.println("Укажите номер товара для добавления: ");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                scanner.nextLine();
                if(n == 0) {
                    cart.cardBalancing();
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                    return;
                }
                else {
                    T thing = market.getThingByIndex(clazz, n);
                    if(thing == null) {
                        System.out.println("Некорректый номер товара");
                        continue;
                    }
                    cart.getFoodstuffs().add(thing);
                    System.out.println("Товар добавлен в корзину");
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                }
            }
            else {
                System.out.println("Некорректный пункт меню. \nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }
}
