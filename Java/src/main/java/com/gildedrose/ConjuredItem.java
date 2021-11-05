package com.gildedrose;

public class ConjuredItem extends Item {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality > 0) {
            quality = quality - 2;
        }
        if (sellIn < 0 && quality > 0) {
            quality = quality - 2;
        }
    }
}
