# kafka-poc

spring boot with confluence kafka/schema registry POC

## kafka/schema-registry deploy
```bash
$ docker-compose up -d
```

## schema class generate
```bash
$ mvn install
```

## publish kafka message / request
* Url: http://127.0.0.1:8080
* Method: POST
* Body
  ```json
  {
      "id": "a3b0f912-b72a-4cd4-8280-0db2740a644b",
      "code": "code",
      "name": "name",
      "version": 1.0,
      "createOn": "2023-01-25T10:57:58.241280700"
  }
  ```

## consume kafka message
```bash
2023-01-26 11:41:54.248  INFO 33632 --- [ntainer#0-0-C-1] k.s.s.kafka.service.ConsumerService      : {"id": a3b0f912-b72a-4cd4-8280-0db2740a644b, "code": "code", "name": "name", "version": 1.0, "createOn": "2023-01-25T10:57:58.241"}
```