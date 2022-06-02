package br.com.gustavodiniz.clientsapi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Integer id;

    @NotEmpty(message = "{mandatory.name.field}")
    private String name;

    @NotNull(message = "{mandatory.cpf.field}")
    @CPF(message = "{invalid.cpf.field}")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate registrationDate;
}
