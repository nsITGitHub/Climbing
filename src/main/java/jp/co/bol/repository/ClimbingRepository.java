package jp.co.bol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.bol.entity.Climbing;


@Repository
public interface ClimbingRepository extends JpaRepository<Climbing, Long> {
	
}
