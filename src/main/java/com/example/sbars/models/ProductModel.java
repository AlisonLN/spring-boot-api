package com.example.sbars.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity // para que seja uma entidade da base de dados, para fazer o mapeamento da classe java para o banco
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; //numero de controle de versao

    //inicio dos atributos dos nosso model que vai ser cada uma das colunas de nossa tabela

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // gera automaticamente o id do produto no banco de dados(auto geração de identificadores)
    private UUID idPoduct;   // id's unicos
    private String name;
    private BigDecimal value; // valor para o idprodut no caso do UUID

    public UUID getIdPoduct() {
        return idPoduct;
    }

    public void setIdPoduct(UUID idPoduct) {
        this.idPoduct = idPoduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

// classe product model com todo mapeamento jpa para que nossa tabela seja gerada no nosso banco de dados