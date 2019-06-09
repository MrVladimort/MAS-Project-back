package pl.pjatk.mas.project.boundary;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.mas.project.boundary.dto.EventDTO;
import pl.pjatk.mas.project.boundary.dto.OrderDTO;
import pl.pjatk.mas.project.control.security.CurrentUser;
import pl.pjatk.mas.project.control.security.UserPrincipal;
import pl.pjatk.mas.project.control.service.EventService;
import pl.pjatk.mas.project.control.service.OrderService;

import java.util.List;

@RestController
@RequestMapping({"/api/orders"})
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    @NonNull OrderService orderService;

    @GetMapping("/client")
    public ResponseEntity<List<OrderDTO>> getAllClientOrders(@CurrentUser UserPrincipal client) {
        return ResponseEntity.ok(orderService.getAllClientOrders(client.getId()));
    }

}
