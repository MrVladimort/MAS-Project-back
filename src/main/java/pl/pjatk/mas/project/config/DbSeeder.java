package pl.pjatk.mas.project.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.pjatk.mas.project.control.dao.*;
import pl.pjatk.mas.project.control.entity.*;
import pl.pjatk.mas.project.control.entity.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DbSeeder {
    @NonNull PasswordEncoder passwordEncoder;

    @NonNull
    private RoleDAO roleDao;
    @NonNull
    private AdminDAO adminDao;
    @NonNull
    private ClientDAO clientDao;

    @NonNull
    private PromotionDAO promotionDao;
    @NonNull
    private AttenderDAO attenderDao;

    @NonNull
    private LocalizationDAO localizationDao;
    @NonNull
    private EventDAO eventDao;
    @NonNull
    private ArtistDAO artistDao;
    @NonNull
    private CommentDAO commentDao;

    @NonNull
    private OrderDAO orderDao;


    @Bean
    public void loadData() {
        var adminRole = roleDao.save(new RoleEntity(Role.ADMIN));
        var clientRole = roleDao.save(new RoleEntity(Role.CLIENT));

        AdminEntity admin = AdminEntity.builder()
                .email("admin@mail.com")
                .name("Admin")
                .surname("Kowalski")
                .password(passwordEncoder.encode("pass"))
                .identifier(UUID.randomUUID().toString())
                .build();

        admin.setRoles(Set.of(adminRole));
        admin = adminDao.save(admin);

        ClientEntity client = ClientEntity.builder()
                .email("client@mail.com")
                .name("Client")
                .surname("Kowalski")
                .password(passwordEncoder.encode("pass"))
                .phone("+41")
                .build();

        client.setRoles(Set.of(clientRole));

        PromotionEntity promotion = PromotionEntity.builder().discountPercent(15).type(EventType.CONCERT).build();

        client.addPromotion(promotion);

        client = clientDao.save(client);

        AttenderEntity attender = AttenderEntity.builder()
                .documentNumber("12345")
                .documentType(DocumentType.ID_CARD)
                .name("Vlad")
                .surname("Vladovich")
                .birthdate(LocalDate.of(1997, 2, 14))
                .client(client)
                .build();

        AttenderEntity attender2 = AttenderEntity.builder()
                .documentNumber("098765")
                .documentType(DocumentType.DRIVER_LICENCE)
                .name("Another")
                .surname("Vladovich")
                .birthdate(LocalDate.of(2000, 11, 7))
                .client(client)
                .build();

        attenderDao.saveAll(List.of(attender, attender2));

        LocalizationEntity localization = localizationDao.save(LocalizationEntity.builder()
                .name("Localization 1")
                .city("Warszawa")
                .street("ul. Koszykowa")
                .buildingNumber("86")
                .build()
        );

        LocalizationEntity localization2 = localizationDao.save(LocalizationEntity.builder()
                .name("Localization 2")
                .city("Warszawa")
                .street("ul. Marszalkowska")
                .buildingNumber("136A")
                .build()
        );

        ArtistEntity musician = artistDao.save(ArtistEntity.builder().name("Metallica").style("Rock").type(ArtistType.MUSICIAN).build());
        ArtistEntity musician2 = artistDao.save(ArtistEntity.builder().name("Lana Del Rey").style("Pop").type(ArtistType.MUSICIAN).build());

        ArtistEntity speaker = artistDao.save(ArtistEntity.builder().name("Valera").style("Books").type(ArtistType.SPEAKER).build());

        EventEntity event = eventDao.save(EventEntity.builder().name("Summer festival").type(EventType.CONCERT).dateTime(LocalDateTime.of(2019, 7, 18, 15, 0)).placeCount(10000).price(100.).localization(localization).build());

        log.info("Event data: {}", event);

        event.addArtist(musician, 60);
        event.addArtist(musician2, 90);

        log.info("Event data: {}", event);

        event = eventDao.save(event);

        log.info("Event data: {}", event);


        EventEntity event2 = eventDao.save(EventEntity.builder().name("Book forum").type(EventType.TRAINING).dateTime(LocalDateTime.of(2019, 5, 9, 18, 30)).placeCount(200).price(200.).localization(localization2).build());

        log.info("Event data: {}", event2);

        event2.addArtist(speaker, 120);

        log.info("Event data: {}", event2);

        event2 = eventDao.save(event2);

        log.info("Event data: {}", event2);

        CommentEntity comment = CommentEntity.builder().text("Keks").grade(4).event(event).user(client).build();
        CommentEntity comment2 = CommentEntity.builder().text("Keksik").grade(3).event(event2).user(client).build();
        CommentEntity comment3 = CommentEntity.builder().text("Keksikulok").grade(5).event(event2).user(admin).build();

        commentDao.saveAll(List.of(comment, comment2, comment3));

        TicketEntity ticket = TicketEntity.builder().attender(attender).event(event).placeNumber(1).price(100.).type(TicketType.REGULAR).build();
        TicketEntity ticket2 = TicketEntity.builder().attender(attender2).event(event).placeNumber(2).price(100.).type(TicketType.REGULAR).build();

        OrderEntity order = OrderEntity.builder().status(OrderStatus.PAID).client(client).totalPrice(170.).build();
        order.addTicket(ticket);
        order.addTicket(ticket2);

        log.info("Order data: {}", order);
        orderDao.save(order);
        log.info("Order data: {}", order);


        TicketEntity ticket3 = TicketEntity.builder().attender(attender).event(event2).placeNumber(1).price(200.).type(TicketType.REGULAR).build();

        OrderEntity order2 = OrderEntity.builder().status(OrderStatus.PAID).client(client).totalPrice(200.).build();
        order2.addTicket(ticket3);
        log.info("Order data: {}", order2);
        orderDao.save(order2);
        log.info("Order data: {}", order2);
    }
}
