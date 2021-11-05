package com.gildedrose;

public class AgedBrieItem extends Item {
    public static final String AgedBrie = "Aged Brie";

    public AgedBrieItem(int sellIn, int quality) {
        super(AgedBrie, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        if (sellIn < 0 && quality < 50) {
            quality = quality + 1;
        }
    }
}
