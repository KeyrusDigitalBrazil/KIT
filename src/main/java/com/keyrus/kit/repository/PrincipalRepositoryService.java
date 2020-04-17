package com.keyrus.kit.repository;

import com.keyrus.kit.models.PrincipalType;

import java.util.List;

public interface PrincipalRepositoryService {

   Boolean save(PrincipalType o);
   Boolean delete(Long id);
   Boolean update(PrincipalType o, Long id);
   Object select(Long id);
   List<Object> selectAll(PrincipalType o);
}
