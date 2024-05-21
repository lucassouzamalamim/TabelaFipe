package br.com.tabela.tabelafipe.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Collection;
import java.util.List;

public class ConvertJson implements IConvertData{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String tJson, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(tJson, tClass);
    }

    @Override
    public <T> List<T> getList(String tJson, Class<T> tClass) throws JsonProcessingException {
        CollectionType list =  mapper.getTypeFactory().constructCollectionType(List.class, tClass);
        return mapper.readValue(tJson, list);
    }
}
