package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void QualityDecreaseBy1WhenSellInMoreThan0() {
        Item[] items = new Item[] { new Item("foo", 2, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void QualityDecreaseBy2WhenSellInLessThan0() {
        Item[] items = new Item[] { new Item("foo", -2, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void qualityNeverLessThanZero() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ConjuredQualityDecreaseBy2WhenSellInMoreThan0() {
        Item[] items = new Item[] { new ConjuredItem(Conjured, 2, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void ConjuredQualityDecreaseBy4WhenSellInLessThan0() {
        Item[] items = new Item[] { new ConjuredItem(Conjured, -2, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void ConjuredQualityNeverLessThanZero() {
        Item[] items = new Item[] { new ConjuredItem(Conjured, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityNeverMoreThanFifty() {
        Item[] items = new Item[] { new AgedBrieItem(AgedBrie, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityIncreaseBy2WhenSellInLessThan0() {
        Item[] items = new Item[] { new AgedBrieItem(AgedBrie, -1, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void AgedBrieQualityIncreaseBy1WhenSellInMoreThan0() {
        Item[] items = new Item[] { new AgedBrieItem(AgedBrie, 1, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityNeverMoreThanFifty() {
        Item[] items = new Item[] { new BackstagePassesItem(BackstagePasses, 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityZeroAfterConcert() {
        Item[] items = new Item[] { new BackstagePassesItem(BackstagePasses, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityIncreaseBy2WhenLessThan10DaysLeft() {
        Item[] items = new Item[] { new BackstagePassesItem(BackstagePasses, 10, 40),
            new BackstagePassesItem(BackstagePasses, 6, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
        assertEquals(22, app.items[1].quality);
    }

    @Test
    void BackstagePassesQualityIncreaseBy3WhenLessThan5DaysLeft() {
        Item[] items = new Item[] { new BackstagePassesItem(BackstagePasses, 5, 40),
            new BackstagePassesItem(BackstagePasses, 1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
        assertEquals(33, app.items[1].quality);
    }

    @Test
    void SulfurasIs80Always() {
        Item[] items = new Item[] { new SulfurasItem(Sulfuras, 1, 80),
            new SulfurasItem(Sulfuras, -1, 80),
            new SulfurasItem(Sulfuras, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
        assertEquals(80, app.items[2].quality);
    }
}
