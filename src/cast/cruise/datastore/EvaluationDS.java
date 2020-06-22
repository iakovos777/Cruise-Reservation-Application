package cast.cruise.datastore;

import java.util.List;

import cast.cruise.domain.Evaluation;

public interface EvaluationDS {
	Evaluation find(int evalNo);
    
    
    void save(Evaluation entity);
    
    
    void delete(Evaluation entity);
    
   
    List<Evaluation> findAll();

}
