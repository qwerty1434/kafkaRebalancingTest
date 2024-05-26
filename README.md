## 설명
<a href="https://velog.io/@qwerty1434/%EC%B9%B4%ED%94%84%EC%B9%B4-%EB%A6%AC%EB%B0%B8%EB%9F%B0%EC%8B%B1">네이버페이 - 쿠버네티스에서 카프카 리밸런싱 방지하기</a>라는 글에서 소개한 카프카 리밸런싱과 스태틱 멤버십에 대한 예제코드를 만들어봤습니다.
- 해당 실습은 쿠버네티스 환경이 아닌 어플리케이션 레벨의 카프카 리밸런싱과 스태틱 멤버십 예제입니다. `원 글에서 언급한 쿠버네티스를 활용한 실습은 진행하지 않습니다.`

## 프로젝트 소개
### docker-compose.yml
도커 환경으로 카프카를 실행합니다.
- 실행 : `docker-compose up -d`
- 종료 : `docker-compose down`

### Producer
토픽에 메시지를 발행합니다. 
- 세 개의 파티션에 각각 하나의 메시지를 보내려면 `localhost:8080`을 호출하면 됩니다.
- 각 파티션에 개별로 메시지를 보내볼 수도 있습니다.

### Consumer1/Consumer2
메시지를 소비합니다. 
- 현재는 스태틱 멤버십 상태입니다. `config.put(ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "cm");`값을 제거하면 일반 환경으로 테스트해볼 수 있습니다.
