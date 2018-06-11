package com.douwe.notes.service;

import com.douwe.notes.entities.EvaluationDetails;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IEvaluationDetailService {
    
    public EvaluationDetails saveOrUpdateEvaluationDetails(EvaluationDetails evaluationDetails) throws ServiceException;
    
    public void deleteEvaluationDetails(Long id) throws ServiceException;
    
    public EvaluationDetails findEvaluationDetailsById(long id) throws ServiceException;
    
    public List<EvaluationDetails> getAllEvaluationDetails() throws ServiceException;
    
    public List<EvaluationDetails> findEvaluationDetailsByTypeCours(Long typeId) throws ServiceException;
    
    void addEvaluation(Long typeId, Long evaluationId, int pourcentage) throws ServiceException;
    
    public List<EvaluationDetails> getAllActive() throws ServiceException;
    
    void modifierEvaluation(Long typeId, Long evaluationId, int pourcentage) throws ServiceException;
    
    void supprimerEvaluation(Long typeId, Long evaluationId) throws ServiceException;
}
