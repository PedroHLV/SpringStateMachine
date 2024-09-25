package com.springstatemachine.springstatemachine.component;

import com.springstatemachine.springstatemachine.events.OrderEvents;
import com.springstatemachine.springstatemachine.states.OrderStates;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuxService {

    private StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory;
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    public AuxService(StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory) {
        this.stateMachineFactory = stateMachineFactory;
    }

    public void initOrderSaga(){
        System.out.println("Initializing Order Saga");
        stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.startReactively().subscribe();
        System.out.println("Final state: " + stateMachine.getState().getId());
    }

    public void stopOrderSaga(){
        System.out.println("Stopping Order Saga");
        stateMachine.stopReactively().subscribe();
    }

    public void validateOrder() {
        System.out.println("Validating Order");
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(OrderEvents.VALIDATED).build())).subscribe(result -> System.out.println(result.getMessage()));
        System.out.println("Final state: " + stateMachine.getState().getId());
    }

    public void payOrder() {
        System.out.println("Paying Order");
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(OrderEvents.PAY).build())).subscribe(result -> System.out.println(result.getResultType()));
        System.out.println("Final state: " + stateMachine.getState().getId());
    }

    public void shipOrder() {
        System.out.println("Shipping Order");
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(OrderEvents.SHIP).build())).subscribe(result -> System.out.println(result.getResultType()));
        System.out.println("Final state: " + stateMachine.getState().getId());
    }

    public void completeOrder() {
        System.out.println("Completing Order");
        stateMachine.sendEvent(Mono.just(
                MessageBuilder.withPayload(OrderEvents.COMPLETE).build())).subscribe(result -> System.out.println(result.getResultType()));
        System.out.println("Final state: " + stateMachine.getState().getId());

        stopOrderSaga();
    }
}
