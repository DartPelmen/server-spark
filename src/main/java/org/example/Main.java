package org.example;

import org.example.model.ToDo;
import org.example.service.ServiceExchanger;
import org.example.service.SimpleService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import static spark.Spark.get;

public class Main {
    private static SimpleService service = new SimpleService(new ArrayList<>());
    public static void main(String[] args) {


        get("/hello", (req, res) -> {
            service.addToDo(new ToDo("make something", "nope", LocalDateTime.now()));

            return ServiceExchanger.exchanger.exchange(true);
        });

    }
}