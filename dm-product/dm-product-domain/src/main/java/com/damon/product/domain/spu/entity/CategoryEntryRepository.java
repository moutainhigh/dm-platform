package com.damon.product.domain.spu.entity;

import com.damon.shared.model.EntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Damon S.
 */
@Repository
public interface CategoryEntryRepository extends EntryRepository<CategoryEntry, Long> {
}