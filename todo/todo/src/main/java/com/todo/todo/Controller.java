package com.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class Controller {

        @Autowired
        List<todoapp> list;

        @PostMapping("posting")
        public String ss(@RequestBody todoapp tt) {
            list.add(tt);
            return "added";
        }

        @GetMapping("get")
        public List<todoapp> ll() {
            return list;
        }

        @PutMapping("todo/id/{id}/Id")
        public String setTodoStatusById(@PathVariable Integer id,@RequestParam Integer Id)
        {
            for(todoapp todo : list)

            {
                if(todo.getTodoId().equals(id))
                {
                    todo.setTodoId(Id);
                    return "todo: "   + id  + "updated to " +  id;
                }
            }

            return "Invalid id";
        }

        @PutMapping("todo/id/{id}")
        public String updateTodoById(@PathVariable Integer id, @RequestBody todoapp ii) {
            for (todoapp todo : list) {
                if (todo.getTodoId().equals(id)) {
                    todo.setTodoId(ii.getTodoId());
                    return "Todo with ID " + id + " updated to ID " + ii.getTodoId();
                }
            }

            return "Invalid id";
        }

        @DeleteMapping("deleting/{id}")
        public String deletemap(@PathVariable Integer id){
            for(todoapp todo : list){
                if(todo.getTodoId().equals(id)){
                    list.remove(todo);
                    return " deleted ";
                }
            }
            return "id not found";
        }

        @PostMapping("todolist")
        public String todolist(@RequestBody List<todoapp> tt){
            list.addAll(tt);
            return tt.size() + "todos added";
        }

        @GetMapping("getid/{id}")
        public String getbyid(@PathVariable Integer id){
            for(todoapp todo : list){
                if(todo.getTodoId().equals(id)){
                    return todo.toString();
                }
            }
            return "id not found";
        }

        @GetMapping("todos/unDone")
        public List<todoapp> getAllUndoneTodos()
        {
            // return list.stream().filter(todo -> !todo.isStatus()).collect(Collectors.toList());

            List<todoapp> unDoneTodos = new ArrayList<>();
            for(todoapp todo : list)
            {
                if(!todo.isStatus())
                {
                    unDoneTodos.add(todo);
                }
            }

            return unDoneTodos;

        }


        @DeleteMapping("dele")
        public List<todoapp> removeTodos(@RequestBody List<Integer> idList)
        {
            for(Integer id : idList)
            {
                for(int i=0;i<list.size();i++)
                {
                    if(id.equals(list.get(i).getTodoId()))
                    {
                        list.remove(list.get(i));
                        break;
                    }
                }
            }

            return list;
        }
    }

