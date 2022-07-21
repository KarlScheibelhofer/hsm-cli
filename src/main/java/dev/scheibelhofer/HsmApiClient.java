package dev.scheibelhofer;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import lombok.Data;

@RegisterRestClient
public interface HsmApiClient {
    
    @Data
    static class Key {
        public Long id;
        public String name;
        public String algorithm;
        public String createdAt;
        public String encodedPrivateKey;
        public String encodedPublicKey;
    }
    
    @GET
    @Path("/keys")
    Collection<Key> getKeys();
    
    @GET
    @Path("/keys/{id}")
    Key getKeyById(@PathParam("id") String id);
    
    @POST
    @Path("/keys")
    Key createKey(Key templateKey);

}
