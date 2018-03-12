package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
//컨트롤러를 /reservationQuery URL에 바인딩합니다.
//초기에는 기본 GET 메서드가 반환한 이름으로 뷰를 해석합니다.
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    // 애플리케이션 컨텍스트에서 사용 가능한 서비스를 생성자에 연결합니다.
    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 컨트롤러는 이름과 무관하게 항상 최초 호출할 기본 GET 메서드를 찾습니다.
    // 이 예제서는 알아보기 쉽게 하고자 setupForm이라고 메서드를 명명했습니다.
    @GetMapping
    public void setupForm() {
        // 메서드 반환 타입이 없으므로(void) 뷰 이름은 URL(reservationQuery)과 같다고 간주됩니다.
        // (클래스에 @RequestMapping(/reservationQuery)를 붙였기 때문입니다)
        // reservationQuery 뷰 해석기 설정에 따라 뷰는
        // /WEB-INF/jsp/reservationQuery.jsp라는 JSP 파일로 매핑됩니다.
    }

    // URL(즉, @RequestMapping(/reservationQuery))로 폼 전송을 하면
    // 컨트롤러는 이름과 무관하게 항상 기본 POST 메서드를 찾습니다.
    // 이 예제서는 알아보기 쉽게 하고자 submitForm이라고 메서드를 명명했습니다.
    @PostMapping
    // 전송된 폼에는 courtName라는 필드가 있고, 예약 정보를 Model 객체에 추가한 후 뷰를 반환합니다.
    public String sumbitForm(@RequestParam("courtName") String courtName, Model model) {
        // 예약 리스트를 생성합니다.
        List<Reservation> reservations = java.util.Collections.emptyList();
        // courtName 매개변수가 null이 아니면 쿼리합니다.
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        // 예약 정보를 model에 추가합니다.
        model.addAttribute("reservations", reservations);
        // 문자열 "reservationQuery"를 반환하면
        // reservationQuery 뷰 해석기 설정에 따라 뷰는
        // /WEB-INF/jsp/reservationQuery.jsp라는 JSP 파일로 매핑됩니다.
        return "reservationQuery";
    }
}