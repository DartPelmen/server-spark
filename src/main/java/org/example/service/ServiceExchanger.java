package org.example.service;

import java.util.concurrent.Exchanger;

public class ServiceExchanger {
    public final static Exchanger<Boolean> exchanger = new Exchanger<>();
}
