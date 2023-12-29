package org.example.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class UMarket {
    private final Collection<Thing> things;


    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }

    private void initializeThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new DumplingBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());

        things.add(new ChocolateBar());
        things.add(new BalykCheese());
        things.add(new Crisps());
    }

    public <T extends Thing> void printThings(Class<T> clazz) {
        int index = 1;
        for (var thing : things) {
            if (clazz.isInstance(thing)) {
                if(Food.class.isAssignableFrom(thing.getClass())) {
                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, thing.getName(),
                            ((Food)thing).getProteins() ? "Да" : "Нет", ((Food)thing).getFats() ? "Да" : "Нет",
                            ((Food)thing).getCarbohydrates() ? "Да" : "Нет");
                }
                else {
                    System.out.printf("[%d] %s\n", index++, thing.getName());
                }
            }
        }
    }

    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
        int counter = 1;
        for (var thing : things) {
            if (clazz.isAssignableFrom(thing.getClass())) {
                if(index == counter++)
                    return (T)thing;
            }
        }
        return null;
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {
        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }
}
