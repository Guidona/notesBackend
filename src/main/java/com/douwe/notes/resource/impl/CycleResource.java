package com.douwe.notes.resource.impl;

import com.douwe.notes.entities.Cycle;
import com.douwe.notes.resource.ICycleResource;
import com.douwe.notes.service.IInsfrastructureService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Vincent Douwe <douwevincent@yahoo.fr>
 */
public class CycleResource implements ICycleResource{

    @EJB
    private IInsfrastructureService infranstructureService;
    
    public Cycle createCycle(Cycle cycle) {
        return infranstructureService.saveOrUpdateCycle(cycle);
    }

    public List<Cycle> getAllCycle() {
        return infranstructureService.getAllCycles();
    }

    public Cycle getCycle(long id) {
        return infranstructureService.findCycleById(id);
    }

    public Cycle updateCycle(long id, Cycle cycle) {
        return infranstructureService.saveOrUpdateCycle(cycle);
    }

    public void deleteCycle(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IInsfrastructureService getInfranstructureService() {
        return infranstructureService;
    }

    public void setInfranstructureService(IInsfrastructureService infranstructureService) {
        this.infranstructureService = infranstructureService;
    }
    
    
    
}
