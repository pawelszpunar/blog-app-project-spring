package com.pawelszpunar.myblogapp.repository;

import com.pawelszpunar.myblogapp.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {

    PostEntity getOneByUuid(String uuid);

    Page<PostEntity> findAllByOrderByCreatedDesc(Pageable pageable);
}
