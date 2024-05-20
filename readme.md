# Project Name

## 개요
이 프로젝트는 Java 21, Spring Boot 3.2.5, PostgreSQL, 그리고 AWS를 사용하여 구축되었습니다. 주요 기능으로는 회원가입, 로그인, 그리고 다양한 결제 옵션을 제공하는 결제 시스템이 포함됩니다.

## 기술 스택
- Java 21
- Spring Boot 3.2.5
- PostgreSQL
- AWS

## 주요 기능

### 회원가입
웹사이트의 회원가입 페이지에서 필요한 정보를 입력하고 계정을 생성할 수 있습니다.

### 로그인
등록된 이메일과 비밀번호를 사용하여 로그인할 수 있습니다.

### 결제
다양한 결제 옵션을 선택하고 결제를 진행할 수 있습니다.

## API Endpoints

### 회원가입
- **Endpoint:** `POST /api/auth/signup`
- **Request Body:**
  ```json
  {
    "username": "user",
    "email": "user@example.com",
    "password": "password"
  }
