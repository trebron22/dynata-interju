package com.dynata.cars.dao.repository;

import com.dynata.cars.dao.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplateEntity, Integer> {
}
