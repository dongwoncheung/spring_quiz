package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor// 파라미터가 모두 있는 생성자
@Builder(toBuilder = true) // setter + 수정이 가능한 객체
@NoArgsConstructor // 아무런 파라미터가 없는 생성자
@Entity
@Table(name = "company")
public class CompanyEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement가 들어가는 항목이라는 의미
private int id;

private String name;

private String business;


private String scale;

private int headcount;
	
@UpdateTimestamp// 시간을 넣지 않아도 현재시간으로 자동으로 들어감
@Column(name = "createdAt", updatable = false)// 카멜케이스 경우 이런 어노테이션을 추가해줌
private ZonedDateTime createdAt;

@UpdateTimestamp// 시간을 넣지 않아도 현재시간으로 자동으로 들어감
@Column(name = "updatedAt", updatable = false)
private ZonedDateTime updatedAt;

}
