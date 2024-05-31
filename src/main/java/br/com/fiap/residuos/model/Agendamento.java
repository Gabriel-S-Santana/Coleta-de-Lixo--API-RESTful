package br.com.fiap.residuos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tbl_agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agendamento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RESIDUOS_SEQ"
    )
    @SequenceGenerator(
            name = "RESIDUOS_SEQ",
            sequenceName = "RESIDUOS_SEQ",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "dia_coleta")
    private LocalDate diaColeta;
    private String endereco;
    private Long numero;
    private Long token;
}
