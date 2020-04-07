package com.home.ex;

import java.util.*;

public class LoadBalancer {

    private static class Task {

        /*
        * написать программу, которая эмулирует работу балансировщика нагрузки:
        * задачи помещются в одну из двух очередей выполнения в соответствии с ее макс.
        * коэффициентом нагрузки. задача помещается в ту очередь, индекс нагрузки которой
        * меньше. индек нагрузки очереди есть суммарный индекс нагрузки всех задач
        * в данной очереди. индекс нагрузки отдельной задачи -- коэффициент, заданный
        * натуральным числом
        * https://stepik.org/lesson/77929/step/8?unit=547        *
        *
         */

        private final int id;
        private final int loadFactor;

        public Task(int id, int loadFactor) {
            this.id = id;
            this.loadFactor = loadFactor;
        }

        public int getLoadFactor() {
            return loadFactor;
        }

        public int getId() {
            return id;
        }
    }

    private static class TaskQueue {

        int id;
        int totalLoad;
        ArrayDeque<Task> taskQueue = new ArrayDeque<>();

        public void addTask(Task task) {
            this.taskQueue.offer(task);
            totalLoad += task.getLoadFactor();
        }

        public Task pickNextTaskFromQueue() {
            if (!taskQueue.isEmpty()) {
                Task task = taskQueue.pop();
                totalLoad -= task.getLoadFactor();
                return task;
            } else return null;
        }

        public TaskQueue(int id) {
            this.id = id;
            this.totalLoad = 0;
        }

        public int getTotalLoad() {
            return totalLoad;
        }

        public ArrayDeque<Task> getTaskQueue() {
            return taskQueue;
        }
    }

    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);
        int amountOfTasks = myScanner.nextInt();

        TaskQueue first = new TaskQueue(1);
        TaskQueue second = new TaskQueue(2);

        for (int i = 0; i < amountOfTasks; i++) {
            int taskId = myScanner.nextInt();
            int taskLoad = myScanner.nextInt();
            Task task = new Task(taskId, taskLoad);

            if (first.getTotalLoad() > second.getTotalLoad()) {
                second.addTask(task);
            } else {
                first.addTask(task);
            }
        }

        first.getTaskQueue().forEach((x) -> System.out.print(x.getId() + " "));
        System.out.println();
        second.getTaskQueue().forEach((x) -> System.out.print(x.getId() + " "));

    }

}
