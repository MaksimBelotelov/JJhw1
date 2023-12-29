package org.example.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.foodstuffs = new ArrayList<>();
        this.market = market;
        this.clazz = clazz;
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    public void cardBalancing() {
        boolean[] flags = new boolean[3]; // Для обхода ограничения на final в лямбде
        flags[0] = foodstuffs.stream().anyMatch(food -> food.getProteins()); // Белки
        flags[1] = foodstuffs.stream().anyMatch(food -> food.getFats()); // Жиры
        flags[2] = foodstuffs.stream().anyMatch(food -> food.getCarbohydrates()); // Углеводы

        if (flags[0] && flags[1] && flags[2]) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(clazz).stream()
                .filter(thing -> !flags[0] && thing.getProteins() ||
                        !flags[1] && thing.getFats() ||
                        !flags[2] && thing.getCarbohydrates())
                .forEach(thing -> {
                    if(!flags[0] && thing.getProteins())
                        flags[0] = true;
                    else if(!flags[1] && thing.getFats())
                        flags[1] = true;
                    else if(!flags[2] && thing.getCarbohydrates())
                        flags[2] = true;
                    foodstuffs.add(thing);
                });

        if (flags[0] && flags[1] && flags[2])
            System.out.println("Стрим сбалансировал корзину по БЖУ");
        else
            System.out.println("У Стрима не получилось сбалансировать корзину");
    }


       /* for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(clazz))
        {
            if (!proteins && thing.getProteins())
            {
                proteins = true;
                foodstuffs.add(thing);
            }
            else if (!fats && thing.getFats())
            {
                fats = true;
                foodstuffs.add(thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

 */

    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }

}
