# 첫 스프링 부트 3 프로젝트
project(directory) name = springboot-developer

* Chapter 1: 개발 환경 구축하기
* Chatper 2: 스프링 부트 3 시작하기
* Chatper 3: 스프링 부트 3 구조
* Chapter 4: 테스트
* Chapter 5: ORM (DB 조작)

# Study Notes

## Chapter 2: 스프링 부트 3 시작하기

### 스프링 핵심

* **IoC** (Inversion of Control; 제어의 역전)
    * 외부에서 관리하는 객체를 가져와 사용한다. 즉, 객체가 필요한 곳에서 직접 객체를 생성하지 않는다.
* **DI** (Dependency Injection; 의존성 주입)
    * 제어의 역전을 구현하기 위한 방법.
    * 스프링 컨테이너에서 **빈(객체)**를 생성해서 요구하는 클래스한테 넘겨준다.
* **AOP** (Aspect Oriented Programming; 관점 지향)
    * 핵심 관점, 부가 관점으로 나누고 부가 관점은 모듈화한다. 즉, 부가 관점을 핵심 관점에서 분리하고 다른 로직에서 재사용할 수 있다.
* **PSA** (Portable Service Abstraction)
    * 스프링에서 제공하는 다양한 기술들을 추상화해서 개발자가 쉽게 사용하는 인터페이스

### 스프링부트 시작 코드

* `@SpringBootApplication` 어노테이션: 스프링 부트 사용에 필요한 기본 설정
* `SpringApplication.run(메인 클래스, 커멘드 라인 인수들)`: 애플리케이션 실행

```java
@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
```

### IntelliJ 사용법

#### 재시작

코드를 수정한 후 스프링 부트 서버를 재시작해야 한다.

`Ctrl + Shift + a` 로 액션 창을 열어서
`Restart IDE`를 실행한다.

그러면 IntelliJ가 꺼졌다가 다시 시작한다.

## Chapter 3: 스프링 부트 3 구조

### 스프링 부트 3 구조

* 프레젠테이션 계층
    * HTTP 요청을 받고 비즈니스 계층으로 전송한다.
    * 구현: **컨트롤러**
* 비즈니스 계층
    * 서비스를 만들기 위한 로직을 처리한다.
    * 구현: **로직**
* 퍼시스턴스 계층
    * 데이터베이스 관련 로직을 처리한다.
    * 구현: **리포지토리**

### 스프링 부트 프로젝트 디렉토리 구성

* main: 실제 코드 작성
    * java
    * resources
        * templates: HTML과 같은 뷰 관련 파일을 넣을 디렉토리
        * static: JS, CSS, 이미지와 같은 정적 파일을 넣을 디렉토리
        * application.yml: 스프링 부트 설정 파일. 스프링 부트 서버가 실행되면 자동으로 로딩된다. DB 설정 정보, 로깅 설정 정보 등이 들어간다.
* test: 프로젝트 소스 코드를 테스트할 목적
* build.gradle: 빌드 설정 파일
    * 의존성을 추가한 후 *새로고침 버튼*을 눌러서 추가한 의존성을 다운로드한다.
* settings.gradle: 프로젝트 정보 설정 파일

### 포스트맨-스프링 부트 요청-응답 과정

1. postman에서 tomcat에 /test GET 요청을 한다. 그 다음 이 요청은 스프링 부트 내로 이동한다.
2. 스프링 부트의 디스패처 서블릿이 URL을 분석하고, 이 요청을 처리할 수 있는 컨트롤러를 찾아 전달한다.
3. TestController - TestService - MemberRepository - DB 순서로 요청을 전달하고 데이터를 DB에서 가져온다.
4. 뷰 리졸버는 템플릿 엔진을 사용해 HTML 문서를 만들거나 JSON, XML 등의 데이터를 생성한다.
5. 결과를 포스트맨에서 볼 수 있다.

## Chapter 5: DB 조작이 편해지는 ORM

### 용어

#### OM (Object-Relational Mapping)

자바의 객체와 DB를 연결하는 프로그래밍 기법. SQL을 사용하지 않고 DB 데이터를 자바 객체처럼 다룰 수 있다.

#### JPA (Java Persistence API)

자바에서 관계형 DB를 사용하는 방식을 정의한 이너페이스.

#### 하이버네이트 (Hibernate)

ORM 프레임워크로 JPA의 인터페이스를 구현한다. 내부적으로 JDBC API를 사용한다.

#### 엔티티

DB 테이블과 매핑되는 객체

#### 엔티티 매니저

엔티티를 관리해서 DB와 애플리케이션 사이에 객체를 생성, 수정, 삭제한다. **엔티티 매니저 팩토리**가 엔티티 매니저를 만든다.
스프링 부트는 빈을 하나만 생성해서 공유하므로 동시성 문제가 발생할 수 있다. 그래서 실제로는 프록시 텐티티 매니저를 사용해서 필요할 때만 실제 엔티티 매니저를 호출한다.

#### 영속성 컨텍스트

엔티티 매니저는 엔티티를 영속성 컨텍스트에 저장한다. 영속성 컨텍스트는 엔티티를 관리하는 가상의 공간이다.
1차 캐시, 쓰기 지연, 변경 감지, 지연 로딩 등의 특성이 있다.

#### 스프링 데이터 JPA

스프링 데이터는 DB 사용 기능을 클래스 레벨에서 추상화했다. JPA 기술을 사용하는 것을 스프링 데이터 JPA라 부른다. (cf. 스프링 데이터 몽고디비)
스프링 데이터 JPA는 스프링 데이터의 인터페이스인 PagingAndSortingRepository를 상속받아 JpaRepository 인터페이스를 만들었다. JpaRepository를 상속받아 우리 인터페이스를 만들어 CRUD 메서드를 사용하는 방법을 따른다.
