package roomescape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping
    public String adminHome() {
        return "/admin/index";
    }

    @GetMapping("/reservation")
    public String adminReservationPage() {
        return "/admin/reservation-legacy";
    }
}