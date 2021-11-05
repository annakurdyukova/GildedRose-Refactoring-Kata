package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String AgedBrie = "Aged Brie";
    public static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String BackstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    public static final String Conjured = "Conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn = item.sellIn - 1;
            item.updateQuality();
        }
    }

}
