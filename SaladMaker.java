package org.example;

import java.util.Arrays;
import java.util.Comparator;

// Базовий клас для овочів
abstract class Vegetable {
    private String name;
    private int caloriesPer100g;

    public Vegetable(String name, int caloriesPer100g) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
    }

    public String getName() {
        return name;
    }

    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public abstract String getDescription();
}

// Клас-нащадок для моркви
class Carrot extends Vegetable {
    public Carrot() {
        super("Carrot", 41);
    }

    @Override
    public String getDescription() {
        return "A crunchy orange vegetable.";
    }
}

// Клас-нащадок для помідора
class Tomato extends Vegetable {
    public Tomato() {
        super("Tomato", 18);
    }

    @Override
    public String getDescription() {
        return "A juicy red fruit.";
    }
}

// Клас-нащадок для огірка
class Cucumber extends Vegetable {
    public Cucumber() {
        super("Cucumber", 16);
    }

    @Override
    public String getDescription() {
        return "A refreshing green vegetable.";
    }
}

// Клас для салату
class Salad {
    private Vegetable[] vegetables;
    private int count;

    public Salad(int size) {
        vegetables = new Vegetable[size];
        count = 0;
    }

    public void addVegetable(Vegetable vegetable) {
        if (count < vegetables.length) {
            vegetables[count++] = vegetable;
        } else {
            System.out.println("Salad is full!");
        }
    }

    public int calculateCalories() {
        int totalCalories = 0;
        for (int i = 0; i < count; i++) {
            totalCalories += vegetables[i].getCaloriesPer100g();
        }
        return totalCalories;
    }

    public void sortVegetablesByCalories() {
        Arrays.sort(vegetables, 0, count, Comparator.comparingInt(Vegetable::getCaloriesPer100g));
    }

    public Vegetable findVegetableInRange(int minCalories, int maxCalories) {
        for (int i = 0; i < count; i++) {
            if (vegetables[i].getCaloriesPer100g() >= minCalories && vegetables[i].getCaloriesPer100g() <= maxCalories) {
                return vegetables[i];
            }
        }
        return null; // Якщо овоч не знайдено
    }

    public void displayVegetables() {
        for (int i = 0; i < count; i++) {
            System.out.println(vegetables[i].getName() + ": " + vegetables[i].getDescription());
        }
    }
}

// Головний клас для запуску програми
public class SaladMaker {
    public static void main(String[] args) {
        Salad salad = new Salad(5);
        salad.addVegetable(new Carrot());
        salad.addVegetable(new Tomato());
        salad.addVegetable(new Cucumber());

        System.out.println("Vegetables in salad:");
        salad.displayVegetables();

        System.out.println("Total calories: " + salad.calculateCalories());

        salad.sortVegetablesByCalories();
        System.out.println("Vegetables sorted by calories:");
        salad.displayVegetables();

        Vegetable found = salad.findVegetableInRange(15, 40);
        if (found != null) {
            System.out.println("Found vegetable in range: " + found.getName());
        } else {
            System.out.println("No vegetable found in the specified range.");
        }
    }
}