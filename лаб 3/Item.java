package com.gildedrose;

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (sellIn < 0) {
            throw new IllegalArgumentException("SellIn cannot be negative");
        }
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("Quality must be between 0 and 50");
        }
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
