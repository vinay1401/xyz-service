package com.xyz.specification;

public interface Specification<T> {
	public boolean isSatisfied(T item);
}
