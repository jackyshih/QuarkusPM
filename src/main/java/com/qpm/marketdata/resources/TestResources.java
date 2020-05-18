package com.qpm.marketdata.resources;
import io.smallrye.reactive.messaging.annotations.Channel;
import org.reactivestreams.Publisher;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testmd")
public class TestResources {

    @Inject
    @Channel("test-vwap-stream") Publisher<Double> vwap;

    @GET
    @Path("/minVwap")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<Double> stream() {

        return vwap;
    }
}
