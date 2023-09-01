package com.contentstack.sdk;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * The interface Base implementation.
 *
 * @param <T> the type parameter
 */
// The `BaseImplementation` interface defines a set of methods that can be implemented by classes. It
// is a generic interface, where `T` represents the type of the implementing class.
public interface BaseImplementation<T> {

    /**
     * The addParam function adds a parameter to a collection using a key-value
     * pair.
     *
     * @param key   A non-null String representing the key for the parameter.
     * @param value The value parameter is of type Object, which means it can accept              any type of object              as its value.
     * @return The addParam method does not have a return type specified, so it does         not return         anything.
     */
    T addParam(@NotNull String key, @NotNull Object value);

    /**
     * The addHeader function adds a header with a specified key and value to a
     * request.
     *
     * @param key   A non-null String representing the header key.
     * @param value The value parameter is a string that represents the value of the              header.
     * @return The addHeader method does not have a return type specified, so it         does not return         anything.
     */
    T addHeader(@NotNull String key, @NotNull String value);

    /**
     * The function "addParams" takes a HashMap of parameters and returns a generic
     * type T.
     *
     * @param parameters A HashMap object that stores key-value pairs, where the key                   is of type String                   and the value is of type Object. The HashMap is annotated                   with @NotNull, indicating that it                   cannot be null.
     * @return The method is not returning anything. It is a void method, which         means it does not have         a return type.
     */
    T addParams(@NotNull HashMap<String, Object> parameters);

    /**
     * The function "addHeaders" takes a HashMap of headers and adds them to the
     * request.
     *
     * @param headers A HashMap object that contains key-value pairs representing                the headers to be                added. The keys represent the header names, and the values                represent the header values.
     * @return The method is not returning anything. It is just adding headers to         the given HashMap.
     */
    T addHeaders(@NotNull HashMap<String, String> headers);
}
