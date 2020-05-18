package com.qpm.marketdata.services;
import javax.enterprise.context.ApplicationScoped;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.annotations.Broadcast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class TestVwapGenerator {
    @Outgoing("test-vwap-stream")
    @Broadcast
    public Flowable<Double> process() {
        //Double newVwap = new Random().nextDouble();
        //return newVwap;
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> new Random().nextDouble());
    }
}
