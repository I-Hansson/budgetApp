package org.chalmers.model.charts;

import org.chalmers.model.IBudgetPostsObserver;

import java.util.Map;

public interface IChart<K, V> extends IBudgetPostsObserver {

    Map<K, V> getDataMap();
}
