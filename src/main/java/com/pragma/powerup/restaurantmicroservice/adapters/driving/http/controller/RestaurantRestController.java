package com.pragma.powerup.restaurantmicroservice.adapters.driving.http.controller;

import com.pragma.powerup.restaurantmicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.restaurantmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.restaurantmicroservice.adapters.driving.http.dto.response.EmployeeResponseDto;
import com.pragma.powerup.restaurantmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.restaurantmicroservice.adapters.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.restaurantmicroservice.configuration.Constants;
import com.pragma.powerup.restaurantmicroservice.configuration.response.SuccessfulApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
@Tag(name = "Restaurant Controller", description = "Controller for managing restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "[ADMIN] Add a new Restaurant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Restaurant created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "400", description = "Restaurant not created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping()
    @SecurityRequirement(name = "jwt")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SuccessfulApiResponse<Void>> saveRestaurant(@Valid @RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessfulApiResponse<>(Constants.RESTAURANT_CREATED_MESSAGE));
    }

    @Operation(summary = "[CLIENT] Get all Restaurants")
    @GetMapping("")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<SuccessfulApiResponse<List<RestaurantResponseDto>>> getRestaurants(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNumber) {
        List<RestaurantResponseDto> restaurantList = restaurantHandler.listRestaurants(pageSize, pageNumber);

        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessfulApiResponse<>(restaurantList));
    }

    @Operation(summary = "[OWNER] Register a new Employee in a Restaurant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Employee registered",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "400", description = "Employee not registered",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/{idRestaurant}/employee")
    @SecurityRequirement(name = "jwt")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<SuccessfulApiResponse<EmployeeResponseDto>> registerEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto,
                                                                                       @PathVariable("idRestaurant") Long restaurantId) {
        EmployeeResponseDto employeeResponseDto = restaurantHandler.registerEmployee(employeeRequestDto, restaurantId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessfulApiResponse<>( "Empleado creado correctamente", employeeResponseDto));
    }
}
