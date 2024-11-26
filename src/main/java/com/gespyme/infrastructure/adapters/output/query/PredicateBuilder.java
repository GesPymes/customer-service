package com.gespyme.infrastructure.adapters.output.query;

import com.gespyme.domain.model.criteria.SearchCriteria;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.stereotype.Component;

@Component
public class PredicateBuilder<T> {
    public BooleanExpression getBooleanBuilder(SimpleExpression<T> path, SearchCriteria searchCriteria) {
        switch (searchCriteria.getOperation()){
            case EQUAL:
                return  path.eq((T) searchCriteria.getValue());
            case LIKE:
                return  ((StringPath) path).contains((String) searchCriteria.getValue());
        }

        return null;
    }


}
