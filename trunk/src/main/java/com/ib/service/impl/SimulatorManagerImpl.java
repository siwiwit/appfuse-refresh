package com.ib.service.impl;

import com.ib.dao.SimulatorDao;
import com.ib.model.Simulator;
import com.ib.service.SimulatorManager;
import org.springframework.stereotype.Service;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("simulatorManager")
public class SimulatorManagerImpl extends GenericManagerImpl<Simulator, Long> implements SimulatorManager {
    private SimulatorDao simulatorDao;


    public SimulatorManagerImpl(SimulatorDao simulatorDao) {
        super(simulatorDao);
        this.simulatorDao = simulatorDao;
    }

    public Simulator findByType(String type) {
        return simulatorDao.findByType(type);
    }

}
