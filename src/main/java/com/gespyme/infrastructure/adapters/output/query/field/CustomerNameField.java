package com.gespyme.infrastructure.adapters.output.query.field;

import com.gespyme.domain.model.criteria.SearchCriteria;
import com.gespyme.infrastructure.adapters.output.model.entities.QCustomerEntity;
import com.gespyme.infrastructure.adapters.output.query.PredicateBuilder;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerNameField implements QueryField {

    private final PredicateBuilder<String> predicateBuilder;

    @Override
    public String getFieldName() {
        return "name";
    }

    @Override
    public void addToQuery(BooleanBuilder booleanBuilder, SearchCriteria searchCriteria) {
        booleanBuilder.and(predicateBuilder.getBooleanBuilder(QCustomerEntity.customerEntity.name, searchCriteria));
    }
}