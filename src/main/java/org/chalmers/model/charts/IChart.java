package org.chalmers.model.charts;

import org.chalmers.model.IBudgetPostsObserver;

import java.util.Map;

/**
 * Interface for charts that allows for polymorphism between different chart types.
 * Depends on IBudgetPostObserver.
 *
 * @param <K> Key type in data map
 * @param <V> Value type in data map
 * @deprecated
 */
public interface IChart<K, V> extends IBudgetPostsObserver {

    Map<K, V> getDataMap();
}
