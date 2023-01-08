package dev.scheibelhofer;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "create_complete_algorithm", 
                     hidden = true)
public class CreateCompleteAlgorithmCommand implements Runnable {

    @Inject
    @RestClient
    HsmApiClient hsmApi;

    @CommandLine.Parameters(defaultValue = Parameters.NULL_VALUE)
    List<String> partialInput;

    @Override
    public void run() {
        String keyAlgorithms = hsmApi.getKeyAlgorithms();

        System.out.println(keyAlgorithms);
    }

}
