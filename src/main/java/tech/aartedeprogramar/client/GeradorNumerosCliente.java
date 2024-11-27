package tech.aartedeprogramar.client;

import com.gerador.grpc.GeradorNumerosGrpc;
import com.gerador.grpc.IntervaloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GeradorNumerosCliente {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GeradorNumerosGrpc.GeradorNumerosBlockingStub stub = GeradorNumerosGrpc.newBlockingStub(managedChannel);

        IntervaloRequest request = IntervaloRequest.newBuilder()
                .setInicio(1)
                .setFim(50)
                .build();

        System.out.println("Números ímpares recebidos:");
        stub.gerarImpares(request)
                .forEachRemaining(response -> System.out.println(response.getNumero()));

        managedChannel.shutdown();

    }
}
