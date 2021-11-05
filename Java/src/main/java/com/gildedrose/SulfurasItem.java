package com.gildedrose;

public class SulfurasItem extends Item {
    public static final String Sulfuras = "Sulfuras, Hand of Ragnaros";

    public SulfurasItem(int sellIn, int quality) {
        super(Sulfuras, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // do nothing
    }
}
