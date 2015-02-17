package com.douwe.notes.dao.impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.douwe.notes.dao.IOptionDao;
import com.douwe.notes.entities.Departement;
import com.douwe.notes.entities.Option;

/**
 *
 * @author Vincent Douwe <douwevincent@yahoo.fr>
 */
public class OptionDaoImpl extends GenericDao<Option, Long> implements IOptionDao{

    public Departement findDepartement(Option option) throws DataAccessException {
       return (Departement) getManager().createNamedQuery("Option.findDepartement").setParameter("idParam", option.getDepartement().getId()).getSingleResult();
    }
    
}
