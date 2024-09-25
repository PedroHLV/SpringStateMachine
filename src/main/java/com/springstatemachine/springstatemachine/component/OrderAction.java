package com.springstatemachine.springstatemachine.component;

import com.springstatemachine.springstatemachine.events.OrderEvents;
import com.springstatemachine.springstatemachine.states.OrderStates;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class OrderAction {

    public Action<OrderStates, OrderEvents> validateOrderAction() {
        return context -> {
            System.out.println("Validating order");
        };
    }

    public Action<OrderStates, OrderEvents> payOrderAction() {
        return context -> {
            System.out.println("Paying order");
        };
    }

    public Action<OrderStates, OrderEvents> shipOrderAction() {
        return context -> {
            System.out.println("Shipping order");
        };
    }

    public Action<OrderStates, OrderEvents> completeOrderAction() {
        return context -> {
            System.out.println("Completing order");
        };
    }

    public Action<OrderStates, OrderEvents> cancelOrderAction() {
        return context -> {
            System.out.println("Cancelling order");
        };
    }

    public StateMachineListener<OrderStates, OrderEvents> stateMachineListener() {
        return new StateMachineListenerAdapter<OrderStates, OrderEvents>() {
            @Override
            public void transition(Transition<OrderStates, OrderEvents> transition) {

                if(transition.getTarget().getId() != null)
                    System.out.println("Transitioning from " +
                            (transition.getSource() != null ? transition.getSource().getId() : "none") + " to " + transition.getTarget().getId());
            }
        };
    }

}
