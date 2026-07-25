package com.devrodrigo.processor;

import com.devrodrigo.annotation.SerializeMethod;
import com.devrodrigo.annotation.SerializerType;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class SerializerProcessor {
    public String serializer(final Object object) throws IllegalAccessException, InvocationTargetException {
        Objects.requireNonNull(object, "Objeto não pode ser vazio");

//        var clazz = object.getClass();
        var classIs = object.getClass();
        var typeAnnotation = Stream.of(classIs.getAnnotations())
                .flatMap(a-> (a instanceof SerializerType s) ? Stream.of(s):Stream.empty())
                /*.filter(SerializerType.class::isInstance)
                .map(SerializerType.class::cast)*/
                .findFirst()
                .orElseThrow(()->new NoSuchElementException("Só são aceitos objetos com anotaçao @SerializerType"));

        var fieldNameFormatter= typeAnnotation.fieldFormat().getFormat();
        var prettify = typeAnnotation.prettify();

        Map<String, Object> elements = new HashMap<>();
        for (var field : classIs.getDeclaredFields ()){
            field.setAccessible(true);
            elements.put(field.getName(), field.get(object));
        }
        var annotatedMethods = Stream.of(object.getClass().getMethods())
                .filter(m -> Stream.of(m.getAnnotations())
                        .anyMatch(a -> a.annotationType().equals(SerializeMethod.class))).toList();

        for (var method: annotatedMethods){
            method.setAccessible(true);
            var customName = method.getAnnotation(SerializeMethod.class).value();
            elements.put(customName.isBlank() ? method.getName() : customName, method.invoke(object));
        }

        var jsonFields = elements.entrySet().stream()
                .map(e-> String.format(
                        "    \"%s\":%s",
                        fieldNameFormatter.apply(e.getKey()),
                        formatValue(e.getValue())
                ))
                .collect(joining(String.format(",%s", System.lineSeparator())));

        var json = String.format("{%s%s%s}", System.lineSeparator(), jsonFields, System.lineSeparator());
        return prettify ?
                json:
                json.replaceAll(System.lineSeparator(), "")
                        .replaceAll(" {4}", "");

    }

    private String formatValue(final Object value){
        return value instanceof String s ?
                String.format("\"%s\"", s) :
                value.toString();
    }
}
