package com.pawelszpunar.myblogapp.repository;

import com.pawelszpunar.myblogapp.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long>, JpaSpecificationExecutor<CommentEntity> {

    CommentEntity getOneByUuid(String uuid);
}
