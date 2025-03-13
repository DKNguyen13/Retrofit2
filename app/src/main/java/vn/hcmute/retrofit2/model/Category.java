package vn.hcmute.retrofit2.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {
    @SerializedName("categoryId")
    private int id;
    @SerializedName("categoryName")
    private String name;
    @SerializedName("icon")
    private String image;

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
