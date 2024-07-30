public class TaskManagementSystem {
    // Node class to represent a node in the linked list
    private static class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Task class to represent a task
    private static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    // Linked list to manage tasks
    private Node head;

    public TaskManagementSystem() {
        head = null;
    }

    // Add task to the end of the list
    public void addTask(int taskId, String taskName, String status) {
        Task task = new Task(taskId, taskName, status);
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Search for a task by task ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }

    // Traverse the list and print all tasks
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.getTask().getTaskId() + ", Task Name: " + current.getTask().getTaskName() + ", Status: " + current.getTask().getStatus());
            current = current.getNext();
        }
    }

    // Delete a task by task ID
    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTask().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem taskList = new TaskManagementSystem();

        // Add tasks
        taskList.addTask(1, "Task 1", "In Progress");
        taskList.addTask(2, "Task 2", "Not Started");
        taskList.addTask(3, "Task 3", "Completed");

        // Traverse and print tasks
        System.out.println("Tasks:");
        taskList.traverse();

        // Search for a task
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Task found: " + task.getTaskName());
        } else {
            System.out.println("Task not found");
        }

        // Delete a task
        taskList.deleteTask(2);

        // Traverse and print tasks again
        System.out.println("Tasks after deletion:");
        taskList.traverse();
    }
}