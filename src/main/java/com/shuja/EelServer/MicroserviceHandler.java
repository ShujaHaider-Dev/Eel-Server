package com.shuja.EelServer;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MicroserviceHandler {
    private List<Microservice> services;

    @PostConstruct
    public void init() {
        System.out.println("This is MicroserviceHandler! We are ready for handling microservices");
        services = new ArrayList<Microservice>();
    }

    public void add(Microservice microservice) {
        if (services.contains(microservice)) {
            ;
        } else {
            services.add(microservice);
        }
    }

    public List<Microservice> registered() {
        return services;
    }

    public void deregister(int index) {
        try {
            services.remove(index);
        } finally {
            ;
        }
    }
}
