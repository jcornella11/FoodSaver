package com.example.foodsaver;

import java.util.Date;

public class Item {
    public String itemName;
    public String UniversalProductCode;
    public String itemPrice;

    public String expirationYear;

    public String expirationMonth;

    public String expirationDay;
    public Item(String name, String UPC, String price, String year,
                String month, String day)
    {
        this.itemName = name;
        this.UniversalProductCode = UPC;
        this.itemPrice = price;
        this.expirationYear = year;
        this.expirationMonth = month;
        this.expirationDay = day;
    }
}
