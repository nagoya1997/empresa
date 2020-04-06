package br.com.acqio.empresa.model.Cidade;

import br.com.acqio.empresa.model.Estado.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String nome;
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }
}