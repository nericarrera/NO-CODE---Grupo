package com.nocountry.conversafe.services;

public interface IDataType {
    <T> T getData(String json, Class<T> tClass);
}
