package com.ia.restfulstudentservices.service;

import java.util.List;

import com.ia.restfulstudentservices.model.ParentGuard;

public interface ParentGuardService {

	List<ParentGuard> getAllParentGuards();

	ParentGuard findById(Long id);

	void deleteById(Long id);

	ParentGuard saveParentGuard(ParentGuard parentGuard);

}
