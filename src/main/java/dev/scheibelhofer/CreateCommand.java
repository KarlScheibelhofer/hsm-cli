package dev.scheibelhofer;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import picocli.CommandLine;

@CommandLine.Command(name = "create", 
                     mixinStandardHelpOptions = true,
                     description = "Create a new key")
public class CreateCommand implements Runnable {

    @Inject
    @RestClient
    HsmApiClient hsmApi;

    @CommandLine.Option(names = { "-n", "--name" }, description = "key name")
    String name;

    @CommandLine.Option(names = { "-a", "--algorithm" }, description = "key algorithm")
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
