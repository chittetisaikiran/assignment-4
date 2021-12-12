package com.lti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	/*
	 * Page<Comment> findByPostId(Long postId,Pageable pageable); Optional<Comment>
	 * findByIdAndPostId(Long id, Long postId);
	 */
	}