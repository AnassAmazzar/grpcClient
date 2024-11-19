package ma.emsi;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ma.emsi.stubs.Bank;
import ma.emsi.stubs.BankServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5555)
                .usePlaintext().build();

        BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
        Bank.ConvertCurrencyRequest request = Bank.ConvertCurrencyRequest.newBuilder().setCurrencyFrom("MAD")
                .setCurrencyTo("Euro")
                .setAmount(15425)
                .build();
        Bank.ConvertCurrencyResponse response = bankServiceBlockingStub.convert(request);
        System.out.println(response);
    }
}