package com.turtlesoup.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity {
    @CreatedDate //만들어질때 입력 되는 필드임을 정의하는 어노테이션
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate //마지막 수정때 입력 되는 필드임을 정의하는 어노테이션
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
