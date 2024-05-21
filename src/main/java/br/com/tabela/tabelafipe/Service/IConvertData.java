package br.com.tabela.tabelafipe.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IConvertData {

    <T> T getData(String tJson, Class<T> tClass) throws JsonProcessingException;
    <T> List<T> getList(String tJson, Class<T> tClass) throws JsonProcessingException;
}
