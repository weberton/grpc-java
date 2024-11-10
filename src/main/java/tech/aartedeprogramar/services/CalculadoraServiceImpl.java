package tech.aartedeprogramar.services;

import calculadora.CalculadoraServiceGrpc;
import calculadora.SomaRequest;
import calculadora.SomaResponse;
import io.grpc.stub.StreamObserver;

public class CalculadoraServiceImpl extends CalculadoraServiceGrpc.CalculadoraServiceImplBase {

    @Override
    public void soma(SomaRequest request, StreamObserver<SomaResponse> responseObserver) {
        int numero1 = request.getNumero1();
        int numero2 = request.getNumero2();
        int soma = numero1 + numero2;

        SomaResponse response = SomaResponse.newBuilder()
                .setResultado(soma)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
