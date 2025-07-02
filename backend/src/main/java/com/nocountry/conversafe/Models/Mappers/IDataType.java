package com.nocountry.conversafe.Models.Mappers;


public interface IDataType {
    <T> T getData(String json, Class<T> tClass);
}
