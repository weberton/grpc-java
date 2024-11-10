package tech.aartedeprogramar.client;

import calculadora.CalculadoraServiceGrpc;
import calculadora.SomaRequest;
import calculadora.SomaResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculadoraCliente {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        CalculadoraServiceGrpc.CalculadoraServiceBlockingStub cliente = CalculadoraServiceGrpc.newBlockingStub(managedChannel);

        SomaRequest somaRequest = SomaRequest.newBuilder()
                .setNumero1(10)
                .setNumero2(5)
                .build();

        SomaResponse response = cliente.soma(somaRequest);

        System.out.println(response.getResultado());
        managedChannel.shutdown();
    }
}
