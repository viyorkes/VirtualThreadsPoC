package virtualthreads.examples;


import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.stream.Collectors;


public class VirtualThreadsFunctionalExample {


    public static void main(String[] args) {
        // Create a list of asynchronous tasks that simulate operations
        List<CompletableFuture<String>> tasks = List.of("Task 1", "Task 2", "Task 3","Task 4")
                .stream()
                .map(taskName -> CompletableFuture.supplyAsync(() -> executeTask(taskName)))
                .collect(Collectors.toList());


        // Combine all tasks and wait for their completion
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[0])
        );


        // Process the result of each task after all tasks are completed
        allTasks.thenRun(() -> {
            List<String> results = tasks.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

            results.forEach(System.out::println);
        }).join(); // Wait until all tasks are completed before finishing
    }



    // Function that simulates the execution of a task using a virtual thread
    private static String executeTask(String taskName) {
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            try {
                System.out.println(taskName + " running on " + Thread.currentThread().getName());
                Thread.sleep(1000);  // Simulate a long-running operation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        try {
            virtualThread.join();  // Wait for the virtual thread to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return taskName + " completed";
    }
}



