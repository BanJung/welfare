package com.study.welfare.groupfundingproduct.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Builder
public class ParticipantCount {
    private final int targetParticipants; // 목표 참여 인원
    private AtomicInteger currentParticipants; // 현재 참여 인원 (멀티스레드 안전)


    public static ParticipantCount applyParticipantCount(int targetParticipants) {
        if (targetParticipants <= 0) {
            throw new IllegalArgumentException("목표 인원은 0보다 커야 합니다.");
        }
        return ParticipantCount.builder()
                .targetParticipants(targetParticipants)
                .currentParticipants(new AtomicInteger(0))
                .build();
    }

    public static ParticipantCount applyParticipantCount(int targetParticipants, int currentParticipants) {
        if (targetParticipants <= 0) {
            throw new IllegalArgumentException("목표 인원은 0보다 커야 합니다.");
        }

        if (currentParticipants < 0) {
            throw new IllegalArgumentException("현재 참여 인원은 0 이상이어야 합니다.");
        }
        return ParticipantCount.builder()
                .targetParticipants(targetParticipants)
                .currentParticipants(new AtomicInteger(currentParticipants))
                .build();
    }

    public void increase() {
        if (currentParticipants.get() >= targetParticipants) {
            throw new IllegalStateException("참여 인원이 이미 목표 인원에 도달했습니다.");
        }
        currentParticipants.incrementAndGet();
    }

    public void decrease() {
        if (currentParticipants.get() <= 0) {
            throw new IllegalStateException("현재 참여 인원이 없습니다.");
        }
        currentParticipants.decrementAndGet();
    }

    public int getCurrentParticipants() {
        return currentParticipants.get();
    }

    // 공동구매 성공 여부 체크
    public boolean isTargetReached() {
        return currentParticipants.get() >= targetParticipants;
    }
}
