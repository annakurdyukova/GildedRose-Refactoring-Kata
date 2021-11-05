package com.gildedrose;

public class Item {

    String name;

    int sellIn;

    int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void updateQuality() {
        if (quality > 0) {
            quality--;
        }
        if (sellIn < 0 && quality > 0) {
            quality--;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateSellIn() {
        sellIn--;
    }
}
