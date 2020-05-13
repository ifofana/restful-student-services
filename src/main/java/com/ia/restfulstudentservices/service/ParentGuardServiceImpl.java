package com.ia.restfulstudentservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.ParentGuard;
import com.ia.restfulstudentservices.repository.ParentGuardRepository;

@Service
@Transactional
public class ParentGuardServiceImpl implements ParentGuardService {
	
	@Autowired
	ParentGuardRepository pgRepo;

	@Override
	public List<ParentGuard> getAllParentGuards() {
		return pgRepo.findAll();
	}

	@Override
	public ParentGuard findById(Long id) {
		return pgRepo.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		pgRepo.deleteById(id);		
	}

	@Override
	public ParentGuard saveParentGuard(ParentGuard pg) {
		return pgRepo.save(pg);
	}

}
