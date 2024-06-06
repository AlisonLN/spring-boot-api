package com.example.sbars.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name,@NotNull BigDecimal value) {
}
// com a criação do record nao é necessario criar os getters, equal's, hashCode, toString, ja é criado automaticamente
// no @notblank diz que o name nao podera ser em branco , e notnull diz que o value nao podera ser null