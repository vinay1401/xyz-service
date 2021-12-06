package com.xyz.specification;

import java.util.stream.Stream;

public interface Filter<T> {
	Stream<T> filter(Stream<T> items, Specification<T> specification);
}
