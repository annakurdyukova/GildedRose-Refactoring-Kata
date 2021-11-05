package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String AgedBrie = "Aged Brie";
    public static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String BackstagePasses = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(Sulfuras)) {
                continue;
            }

            item.sellIn = item.sellIn - 1;

            if (item.name.equals(AgedBrie)) {
                handleAgedBrie(item);
            } else if (item.name.equals(BackstagePasses)) {
                handleBackstagePasses(item);
            } else {
                handleGeneralItem(item);
            }
        }
    }

    private void handleGeneralItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void handleBackstagePasses(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 10 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 5 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
