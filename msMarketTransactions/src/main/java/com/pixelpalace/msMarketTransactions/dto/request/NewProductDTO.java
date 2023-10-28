package com.pixelpalace.msMarketTransactions.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class NewProductDTO {
    
    @NotNull(message = "Ingrese un nombre valido.")
    private String name;

    @NotNull(message = "Ingrese una descripcion valida.")
    private String description;

    @NotNull(message = "Ingrese una categoria valida.")
    private List<Long> categoriesId;

    @NotNull(message = "Ingrese una plataforma valida.")
    private List<Long> platformsId;

    @Positive(message = "Ingrese un precio valido.")
    @NotNull(message = "Ingrese un precio valido.")
    @Digits(fraction = 2, message = "El precio solo puede tener 2 decimales", integer = 100)
    private Double price;
}
