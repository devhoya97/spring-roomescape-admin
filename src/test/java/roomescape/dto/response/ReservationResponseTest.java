package roomescape.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import roomescape.domain.Reservation;

class ReservationResponseTest {

    @Test
    @DisplayName("id와 Reservation 객체로 ReservationResponse를 만든다.")
    void createReservationResponse() {
        Long id = 1L;
        String name = "브라운";
        LocalDate date = LocalDate.parse("2024-04-01");
        LocalTime time = LocalTime.parse("07:00");
        Reservation reservation = new Reservation(name, date, time);
        ReservationResponse expected = new ReservationResponse(id, name, date, time);

        ReservationResponse reservationResponse = ReservationResponse.of(id, reservation);

        assertThat(reservationResponse).isEqualTo(expected);
    }
}
