package com.harium.suneidesis.repository;

import java.util.Iterator;

public interface RepositoryCursor<T> {

    Iterator<T> iterator();

}
