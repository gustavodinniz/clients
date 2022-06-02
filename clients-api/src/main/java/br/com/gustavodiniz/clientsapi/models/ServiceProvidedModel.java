package br.com.gustavodiniz.clientsapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDateTime serviceDate;
}
