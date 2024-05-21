package br.com.tabela.tabelafipe.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record GenericData(@JsonAlias("codigo") int code,
                          @JsonAlias("nome") String description) {
}
