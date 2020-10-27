package com.cjc.JavaBean;

public class Categories {
    private String CategoryID;
    private String CategoryName;
    private String Description;

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Categories(String categoryID, String categoryName, String description) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        Description = description;
    }

    public Categories() {
    }

    @Override
    public String toString() {

        return CategoryID + "," + CategoryName + "," + Description;
    }
}
