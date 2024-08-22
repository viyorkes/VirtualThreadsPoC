package virtualthreads.examples;



public class VirtualSimpleThreadsExample {

    public static void main(String[] args) {
        // Simula o processamento de 1000 solicitações HTTP simultâneas
        for (int i = 0; i < 1000; i++) {
            Thread.ofVirtual().start(() -> {
                processRequest();
            });
        }

        // Espera para garantir que todas as requisições sejam processadas
        try {
            Thread.sleep(5000); // Aguarda o tempo necessário para que todas as threads terminem
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void processRequest() {
        try {
            // Simula o tempo para ler dados do banco de dados
            Thread.sleep(100);
            System.out.println("Requisição processada por: " + Thread.currentThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

