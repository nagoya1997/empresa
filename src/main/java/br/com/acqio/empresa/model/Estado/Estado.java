package br.com.acqio.empresa.model.Estado;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String nome;
    @Column(length = 2, nullable = false)
    private String abreviacao;

    public Estado() {
    }
}