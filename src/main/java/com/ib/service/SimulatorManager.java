package com.ib.service;

import com.ib.model.Simulator;

/**
 * Created by IMAM on 12/17/14.
 */
public interface SimulatorManager extends GenericManager<Simulator, Long> {
    public Simulator findByType(String type);
}
