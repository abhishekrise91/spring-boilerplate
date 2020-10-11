package com.mockup.register.sdk.converter;

import com.mockup.register.sdk.model.AbstractDto;
import com.mockup.register.sdk.model.BaseModel;
import com.mockup.register.sdk.util.ListUtil;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface GenericConverter<D extends AbstractDto, E extends BaseModel> {

    E createFrom(D dto);

    D createFrom(E entity);

    E updateEntity(E entity, D dto);

    default List<D> createFromEntities(final Collection<E> entities) {
        if(ListUtil.isEmpty(entities)) return null;
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default List<E> createFromDtos(final Collection<D> dtos) {
        if(ListUtil.isEmpty(dtos)) return null;
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

}

