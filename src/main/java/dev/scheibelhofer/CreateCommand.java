package dev.scheibelhofer;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import picocli.CommandLine;

@CommandLine.Command(name = "create", 
                     mixinStandardHelpOptions = true,
                     description = "Create a new key")
public class CreateCommand implements Runnable {

    static class AlgorithmCandidates extends ArrayList<String> {
        AlgorithmCandidates() { super(Arrays.asList("EC_P256","EC_P384","EC_P521","RSA_PSS_2048","EC_ED25519","EC_ED448")); }
    }

    @Inject
    @RestClient
    HsmApiClient hsmApi;

    @CommandLine.Option(names = { "-n", "--name" }, description = "key name")
    String name;

    @CommandLine.Option(names = { "-a", "--algorithm" }, description = "key algorithm, one of ${COMPLETION-CANDIDATES}",
                        completionCandidates = AlgorithmCandidates.class)
    String algorithm;

    @Override
    public void run() {
        HsmApiClient.Key templateKey = new HsmApiClient.Key();
        templateKey.name = name;
        templateKey.algorithm = algorithm;

        HsmApiClient.Key key = hsmApi.createKey(templateKey);

        System.out.println(Mapper.toJson(key));
    }

}
