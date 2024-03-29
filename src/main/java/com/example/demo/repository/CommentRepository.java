package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Comment;
@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long>{

	public List<Comment> findByThreadId(int threadId);
}
