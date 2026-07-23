package com.devrodrigo;

import com.devrodrigo.model.Person;
import com.devrodrigo.model.User;
import com.devrodrigo.processor.SerializerProcessor;

import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InvocationTargetException, IllegalAccessException {

        var processor = new SerializerProcessor();
        System.out.println(processor.serializer(new Person(1, "Rodrigo Medeiros Grassioto", 43)));
        System.out.println(processor.serializer(new User(2, "Carla Thais Meneghini Grassioto", 42, 1450.33 )));

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        IO.println(String.format("Hello and welcome!"));
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            IO.println("i = " + i);
//        }
    }
}
