package dhu.sun.vege.service;

import dhu.sun.vege.entity.Type;

import java.util.List;

/**
 * Created by think on 2018/4/8.
 */
public interface TypeService {
    Type addType(Type type);
    List<Type> getAlltype();
}
