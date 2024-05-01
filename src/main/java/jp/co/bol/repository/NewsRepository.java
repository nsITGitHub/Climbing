package jp.co.bol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.bol.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
	
}