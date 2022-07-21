package dev.scheibelhofer;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import picocli.CommandLine;

@CommandLine.Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Inject
    @RestClient
    HsmApiClient hsmApi;

    @CommandLine.Option(names = { "-i", "--id" }, description = "key ID")
    String id;

    @Override
    public void run() {
        if (id == null) {
            Collection<HsmApiClient.Key> keys = hsmApi.getKeys();
            System.out.println(Mapper.toJson(keys));
        } else {
            HsmApiClient.Key key = hsmApi.getKeyById(id);
            System.out.println(Mapper.toJson(key));
        }
    }

}
