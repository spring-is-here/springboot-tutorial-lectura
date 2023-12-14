# Chapter 2 메모

## 스프링 핵심

* **IoC** (Inversion of Control; 제어의 역전)
  * 외부에서 관리하는 객체를 가져와 사용한다. 즉, 객체가 필요한 곳에서 직접 객체를 생성하지 않는다.
* **DI** (Dependency Injection; 의존성 주입)
  * 제어의 역전을 구현하기 위한 방법.
  * 스프링 컨테이너에서 **빈(객체)**를 생성해서 요구하는 클래스한테 넘겨준다.
* **AOP** (Aspect Oriented Programming; 관점 지향)
  * 핵심 관점, 부가 관점으로 나누고 부가 관점은 모듈화한다. 즉, 부가 관점을 핵심 관점에서 분리하고 다른 로직에서 재사용할 수 있다.
* **PSA** (Portable Service Abstraction)
  * 스프링에서 제공하는 다양한 기술들을 추상화해서 개발자가 쉽게 사용하는 인터페이스

## 스프링부트 시작 코드

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

## IntelliJ 사용법

### 재시작

코드를 수정한 후 스프링 부트 서버를 재시작해야 한다.

`Ctrl + Shift + a` 로 액션 창을 열어서
`Restart IDE`를 실행한다.

그러면 IntelliJ가 꺼졌다가 다시 시작한다.