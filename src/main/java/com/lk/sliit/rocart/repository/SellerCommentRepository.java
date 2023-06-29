package com.lk.sliit.rocart.repository;


import com.lk.sliit.rocart.model.SellerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerCommentRepository extends JpaRepository<SellerComment, Integer> {
}
