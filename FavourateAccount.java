package com.hcl.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.account.exception.RecordNotFoundException;
import com.hcl.account.model.FavourateAccountsEntity;
import com.hcl.account.repository.FavourateAccountRepository;

@Service
public class FavourateAccount {

	@Autowired
	FavourateAccountRepository repository;

	public List<FavourateAccountsEntity> getAllEmployees() {
		List<FavourateAccountsEntity> accountsList = repository.findAll();

		if (accountsList.size() > 0) {
			return accountsList;
		} else {
			return new ArrayList<FavourateAccountsEntity>();
		}
	}

	public FavourateAccountsEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<FavourateAccountsEntity> accounts = repository.findById(id);

		if (accounts.isPresent()) {
			return accounts.get();
		} else {
			throw new RecordNotFoundException("No favourate accounts exist for given id");
		}
	}

	public FavourateAccountsEntity createOrUpdateEmployee(FavourateAccountsEntity entity)
			throws RecordNotFoundException {
		Optional<FavourateAccountsEntity> accounts = repository.findById(entity.getId());

		if (accounts.isPresent()) {
			FavourateAccountsEntity newEntity = accounts.get();
			
			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<FavourateAccountsEntity> accounts = repository.findById(id);

		if (accounts.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No favourate accounts exist for given id");
		}
	}
}