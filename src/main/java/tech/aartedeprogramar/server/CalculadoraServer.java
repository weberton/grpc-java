package tech.aartedeprogramar.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import tech.aartedeprogramar.services.CalculadoraServiceImpl;

public class CalculadoraServer {

    public static void main(String[] args) throws Exception {
        // Criando o servidor gRPC na porta 50051
        Server server = ServerBuilder.forPort(50051)
                .addService(new CalculadoraServiceImpl())
                .build();
        // Adicionando o Shutdown Hook para encerramento controlado
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Encerrando servidor gRPC.");
            server.shutdown();
            System.out.println("Serviddor gRPC encerrado com sucesso.");
        }));

        // Iniciando o servidor
        System.out.println("Servidor gRPC iniciado na porta 50051.");
        server.start();
        server.awaitTermination();
    }
}
