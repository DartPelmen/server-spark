package org.example.service;

import org.example.model.ToDo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleService {
    private final List<ToDo> toDoList;
    private final ExecutorService service = Executors.newWorkStealingPool();
    public SimpleService(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }
    public List<ToDo> getToDoList(){
        return toDoList;
    }
    public void addToDo(ToDo toDo){
         CompletableFuture.runAsync(()-> {
                     toDoList.add(toDo);
                     System.out.println("ADDING IN "+Thread.currentThread().getName());
                     try {
                         ServiceExchanger.exchanger.exchange(true);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     } finally {
                         System.out.println("END");
                     }
                 },service);

    }
}
