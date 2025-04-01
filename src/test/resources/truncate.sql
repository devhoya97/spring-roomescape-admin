-- 외래 키 제약 조건 비활성화
SET FOREIGN_KEY_CHECKS = 0;

-- 테이블 데이터 삭제 및 AUTO_INCREMENT 초기화
TRUNCATE TABLE reservation;
ALTER TABLE reservation AUTO_INCREMENT = 1;

TRUNCATE TABLE reservation_slot;
ALTER TABLE reservation_slot AUTO_INCREMENT = 1;

TRUNCATE TABLE reservation_time;
ALTER TABLE reservation_time AUTO_INCREMENT = 1;

TRUNCATE TABLE theme;
ALTER TABLE theme AUTO_INCREMENT = 1;

TRUNCATE TABLE member;
ALTER TABLE member AUTO_INCREMENT = 1;

-- 외래 키 제약 조건 활성화
SET FOREIGN_KEY_CHECKS = 1;
