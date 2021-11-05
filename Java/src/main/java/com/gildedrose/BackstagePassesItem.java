package com.gildedrose;

public class BackstagePassesItem extends Item {
    public static final String BackstagePasses = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassesItem(int sellIn, int quality) {
        super(BackstagePasses, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn < 0) {
            quality = 0;
            return;
        }
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 10 && quality < 50) {
                quality = quality + 1;
            }

            if (sellIn < 5 && quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
