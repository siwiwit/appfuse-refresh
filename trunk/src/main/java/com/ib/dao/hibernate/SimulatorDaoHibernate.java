package com.ib.dao.hibernate;

import com.ib.dao.SimulatorDao;
import com.ib.model.Simulator;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 12/17/14.
 */
@Repository("simulatorDao")

public class SimulatorDaoHibernate extends GenericDaoHibernate<Simulator, Long> implements SimulatorDao {


    public SimulatorDaoHibernate() {
        super(Simulator.class);
    }
    public SimulatorDaoHibernate(String test) {
        super(Simulator.class);
    }

    public Simulator findByType(String type) {
        List<Simulator> simulators = getSession().createCriteria(Simulator.class).add(Restrictions.eq("type", type)).list();
        if (simulators != null && simulators.size() > 0) {
            return simulators.get(0);
        }
        return null;
    }
}
