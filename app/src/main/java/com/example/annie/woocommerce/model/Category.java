package com.example.annie.woocommerce.model;

/**
 * Created by SONY on 5/27/2016.
 */
public class Category {
    public String name;
    public String description;
    public int quantity;
    public int photoID;

    public Category (String name,String description,int quantity,int photoID)
    {
        this.name=name;
        this.description=description;
        this.quantity=quantity;
        this.photoID=photoID;
    }
}
