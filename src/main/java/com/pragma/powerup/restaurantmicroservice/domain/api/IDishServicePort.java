package com.pragma.powerup.restaurantmicroservice.domain.api;

import com.pragma.powerup.restaurantmicroservice.domain.model.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish);
    void updateDish(Long id, Double price, String description);
}
