package kr.sprouts.sandbox.kafka.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestRequest {
    @Getter
    private UUID id;
    @Getter
    private String code;
    @Getter
    private String name;
    @Getter
    private Float version;
    @Getter
    private LocalDateTime createdOn;
}
