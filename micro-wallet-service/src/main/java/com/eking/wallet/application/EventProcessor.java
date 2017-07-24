package com.eking.wallet.application;

import com.eking.micro.common.domain.model.DomainEvent;
import com.eking.micro.common.domain.model.DomainEventPublisher;
import com.eking.micro.common.domain.model.DomainEventSubscriber;
import com.eking.micro.common.event.EventStore;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 童春 on 2017/7/7.
 */

@Aspect
@Component
public class EventProcessor {
    @Autowired
    private EventStore eventStore;

    @Before("@annotation(com.eking.micro.common.annoation.DomainEventAspect)")
    public void listenapplication() {
        DomainEventPublisher.instance().reset();
        DomainEventPublisher
                .instance()
                .subscribe(new DomainEventSubscriber<DomainEvent>() {

                    public void handleEvent(DomainEvent DomainEvent) {
                        eventStore.append(DomainEvent);
                    }
                    public Class<DomainEvent> subscribedToEventType() {
                        return DomainEvent.class; // all domain events
                    }
                });
    }

//    @Before("execution(* com.eking.wallet.domain.wallet.service..*.*(..))")
//    public void listendomain() {
//        DomainEventPublisher
//                .instance()
//                .subscribe(new DomainEventSubscriber<DomainEvent>() {
//
//                    public void handleEvent(DomainEvent DomainEvent) {
//                        eventStore.append(DomainEvent);
//                    }
//                    public Class<DomainEvent> subscribedToEventType() {
//                        return DomainEvent.class; // all domain events
//                    }
//                });
//    }

}
