package com.pragma.powerup.restaurantmicroservice.domain.model;

public class Dish {
    private Long id;
    private String name;
    private Category category;
    private String description;
    private Double price;
    private Long idRestaurant;
    private String urlImage;
    private Boolean active;

    public Dish() {
    }

    public Dish(Long id, String name, Category category, Long idRestaurant, Boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.idRestaurant = idRestaurant;
        this.active = active;
    }

    public Dish(Long id, String name, Category category, String description, Double price, Long idRestaurant, String urlImage, Boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.idRestaurant = idRestaurant;
        this.urlImage = urlImage;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
