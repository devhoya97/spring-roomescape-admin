package roomescape.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import roomescape.domain.ReservationTime;
import roomescape.dto.request.ReservationTimeAddRequest;
import roomescape.dto.response.ReservationTimeResponse;
import roomescape.repository.reservationtime.ReservationTimeRepository;

@Service
public class ReservationTimeService {

    private final ReservationTimeRepository reservationTimeRepository;

    public ReservationTimeService(ReservationTimeRepository reservationTimeRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
    }

    public ReservationTimeResponse addTime(ReservationTimeAddRequest reservationTimeAddRequest) {
        ReservationTime reservationTime = reservationTimeRepository.save(reservationTimeAddRequest.toReservationTime());
        return ReservationTimeResponse.from(reservationTime);
    }

    public List<ReservationTimeResponse> getTimes() {
        return reservationTimeRepository.findAll()
                .stream()
                .map(ReservationTimeResponse::from)
                .toList();
    }

    public ReservationTimeResponse getTime(Long id) {
        return ReservationTimeResponse.from(getValidReservationTime(id));
    }

    private ReservationTime getValidReservationTime(Long id) {
        Optional<ReservationTime> reservationTime = reservationTimeRepository.findById(id);

        if (reservationTime.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 예약 시간입니다. time_id = " + id);
        }

        return reservationTime.get();
    }

    public void deleteTime(Long id) {
        reservationTimeRepository.delete(id);
    }
}
