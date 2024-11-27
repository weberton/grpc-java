package tech.aartedeprogramar.services;

import com.gerador.grpc.GeradorNumerosGrpc;
import com.gerador.grpc.IntervaloRequest;
import com.gerador.grpc.NumeroImparResponse;
import io.grpc.stub.StreamObserver;

public class GeradorNumerosServiceImpl extends GeradorNumerosGrpc.GeradorNumerosImplBase {

    @Override
    public void gerarImpares(IntervaloRequest request, StreamObserver<NumeroImparResponse> responseObserver) {
        int inicio = request.getInicio();
        int fim = request.getFim();

        if (inicio > fim) {
            responseObserver.onError(new IllegalArgumentException("O valor inicial deve ser menor ou igual ao valor final."));
            return;
        }

        while (inicio <= fim) {
            if (isImpar(inicio)) {
                NumeroImparResponse response = NumeroImparResponse.newBuilder()
                        .setNumero(inicio)
                        .build();
                responseObserver.onNext(response);
                sleep(500);
            }
            inicio++;
        }
        responseObserver.onCompleted();
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isImpar(int inicio) {
        return inicio % 2 != 0;
    }
}
