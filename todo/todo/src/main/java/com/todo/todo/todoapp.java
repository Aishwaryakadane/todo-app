package com.todo.todo;

    public class todoapp extends Object {
        public Integer todoId;
        public String todoName;
        public  boolean status;

        public todoapp(Integer todoId, String todoName, boolean status) {
            this.todoId = todoId;
            this.todoName = todoName;
            this.status = status;
        }


        public Integer getTodoId() {
            return todoId;
        }

        public void setTodoId(Integer todoId) {
            this.todoId = todoId;
        }

        public String getTodoName() {
            return todoName;
        }

        public void setTodoName(String todoName) {
            this.todoName = todoName;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "todoapp{" +
                    "todoId=" + todoId +
                    ", todoName='" + todoName + '\'' +
                    ", status=" + status +
                    '}';
        }
    }


