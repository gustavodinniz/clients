package br.com.gustavodiniz.clientsapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_SERVICES_PROVIDED")
public class ServiceProvidedModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientModel client;

    @Column
    private BigDecimal serviceValue;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate serviceDate;
}
