package com.laamware.ejercito.doc.web.docwebservice.repo;

import com.laamware.ejercito.doc.web.docwebservice.entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableRepository extends
JpaRepository<Variable, Integer> {

}
