package br.com.gustavodiniz.clientsapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {

    @NotEmpty(message = "The description field is required.")
    private String description;

    @NotEmpty(message = "The price field is required.")
    private String serviceValue;

    @NotNull(message = "The date field is required.")
    private String serviceDate;

    @NotEmpty(message = "The client field is required.")
    private Integer clientId;



}
