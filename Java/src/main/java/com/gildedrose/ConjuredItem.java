package com.gildedrose;

public class ConjuredItem extends Item {
    public static final String Conjured = "Conjured";

    public ConjuredItem(int sellIn, int quality) {
        super(Conjured, sellIn, quality);
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
