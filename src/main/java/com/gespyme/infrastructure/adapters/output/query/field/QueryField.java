package com.gespyme.infrastructure.adapters.output.query.field;

import com.gespyme.domain.model.criteria.SearchCriteria;
import com.querydsl.core.BooleanBuilder;

public interface QueryField {

    String getFieldName();
    void addToQuery(BooleanBuilder booleanBuilder, SearchCriteria searchCriteria);
}
