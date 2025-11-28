package com.example.prog_14615.domain.wise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WiseRepository extends JpaRepository<Wise, Long> {

}
