package com.conciliacaocob.conciliacaoConciliador.model;

import javax.persistence.*;

/**
 * Classe do objeto Emissor
 *
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name = "T_EMISSOR")
public class Emissor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String nome;

    @ManyToOne
    @JoinColumn
    public Base base;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
