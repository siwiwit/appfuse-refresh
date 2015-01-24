package com.ib.dao;

import com.ib.model.Simulator;

/**
 * Created by IMAM on 12/17/14.
 */
public interface SimulatorDao extends GenericDao<Simulator, Long> {
    public Simulator findByType(String type);
}
