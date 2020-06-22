package cast.cruise.memory;

import java.util.ArrayList;
import java.util.List;

import cast.cruise.datastore.EvaluationDS;
import cast.cruise.domain.Evaluation;


public class EvaluationMemory implements EvaluationDS {
	
	protected static List<Evaluation> entities = new ArrayList<Evaluation>();
	
	@Override
	public Evaluation find(int evalNo) {
		for(Evaluation eval : entities) {
            if (eval.getEvalId() == evalNo ) {
                return eval;
            }
        }
		return null;
	}

	@Override
	public void save(Evaluation entity) {
		if (! entities.contains(entity)) {
            entities.add(entity);    
        } 

	}

	@Override
	public void delete(Evaluation entity) {
		entities.remove(entity);

	}

	@Override
	public List<Evaluation> findAll() {
		return new ArrayList<Evaluation>(entities);
	}

}
