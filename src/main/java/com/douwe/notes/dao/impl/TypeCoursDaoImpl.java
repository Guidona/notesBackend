package com.douwe.notes.dao.impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.douwe.notes.dao.ITypeCoursDao;
import com.douwe.notes.entities.TypeCours;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vincent Douwe <douwevincent@yahoo.fr>
 */
@Repository
public class TypeCoursDaoImpl extends GenericDao<TypeCours, Long> implements ITypeCoursDao{

    @Override
    public List<TypeCours> findAllActive() throws DataAccessException {
        return getManager().createNamedQuery("TypeCours.findAllActive").getResultList();
    }
    
}
