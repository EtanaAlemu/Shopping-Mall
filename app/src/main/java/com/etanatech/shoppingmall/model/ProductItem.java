package com.etanatech.shoppingmall.model;

public class ProductItem {
    String itemName;
    String itemPrice;
    String itemThumbnailURL;
    boolean isFav;

    public ProductItem(String itemName, String itemPrice, String itemThumbnailURL, boolean isFav) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemThumbnailURL = itemThumbnailURL;
        this.isFav = isFav;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemThumbnailURL() {
        return itemThumbnailURL;
    }

    public void setItemThumbnailURL(String itemThumbnailURL) {
        this.itemThumbnailURL = itemThumbnailURL;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
