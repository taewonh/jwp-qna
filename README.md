# 우아한 테크캠프 Pro 5기 - 2주차

## JPA

### 실습 환경 구축

- [QnA 저장소](https://github.com/next-step/jwp-qna)를 기반으로 미션을 진행</br>
- [온라인 코드 리뷰 요청 1단계 문서](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)를 참고해 실습 환경을
  구축

1. 미션 시작 버튼을 눌러 미션을 시작
2. 저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인
3. 저장소를 자신의 계정으로 Fork

### 요구사항

- Entity 클래스와 Repository 클래스 작성
  - [x] Answer
  - [x] Question
  - [x] User
  - [x] DeleteHistory
- `@DataJpaTest` 를 활용한 Repository 테스트 코드 작성
  - CRUD 및 Exception 테스트
  - [x] AnswerRepositoryTest
  - [x] QuestionRepositoryTest
  - [x] UserRepositoryTest
  - [x] DeleteHistoryRepositoryTest

### DDL
```SQL
create table answer
(
    id          bigint generated by default as identity,
    contents    clob,
    created_at  timestamp not null,
    deleted     boolean   not null,
    question_id bigint,
    updated_at  timestamp,
    writer_id   bigint,
    primary key (id)
);
```

```SQL
create table delete_history
(
    id            bigint generated by default as identity,
    content_id    bigint,
    content_type  varchar(255),
    create_date   timestamp,
    deleted_by_id bigint,
    primary key (id)
)
```

```SQL
create table question
(
    id         bigint generated by default as identity,
    contents   clob,
    created_at timestamp    not null,
    deleted    boolean      not null,
    title      varchar(100) not null,
    updated_at timestamp,
    writer_id  bigint,
    primary key (id)
)
```

```SQL
create table user
(
    id         bigint generated by default as identity,
    created_at timestamp   not null,
    email      varchar(50),
    name       varchar(20) not null,
    password   varchar(20) not null,
    updated_at timestamp,
    user_id    varchar(20) not null,
    primary key (id)
)

alter table user
    add constraint UK_a3imlf41l37utmxiquukk8ajc unique (user_id)
```

### 