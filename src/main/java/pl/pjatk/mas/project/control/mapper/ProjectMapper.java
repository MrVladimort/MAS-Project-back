package pl.pjatk.mas.project.control.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.core.annotation.Order;
import pl.pjatk.mas.project.boundary.dto.*;
import pl.pjatk.mas.project.control.entity.*;
import pl.pjatk.mas.project.control.entity.enums.ArtistType;
import pl.pjatk.mas.project.control.security.UserPrincipal;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ProjectMapper {
    LocalDateTime map(Instant value) {
        return LocalDateTime.ofInstant(value, ZoneOffset.UTC);
    }

    public abstract ClientEntity clientEntityFromDto(ClientDTO dto);
    public abstract ClientEntity clientEntityFromDto(RegisterDTO dto);
    public abstract ClientDTO clientDtoFromEntity(ClientEntity dto);

    public abstract AdminEntity adminEntityFromDto(AdminDTO dto);
    public abstract AdminEntity adminEntityFromDto(RegisterDTO dto);
    public abstract AdminDTO adminDtoFromEntity(AdminEntity dto);

    public abstract UserDTO userDtoFromPrincipal(UserPrincipal entity);
    public abstract UserPrincipal principalFromEntity(UserEntity entity);
    public abstract UserDTO userDtoFromEntity(UserEntity entity);

    public abstract EventDTO eventEntityToDto(EventEntity entity);

    @Mappings({
            @Mapping(source = "event.name", target = "eventName"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "user.name", target = "userName"),
            @Mapping(source = "user.surname", target = "userSurname"),
    })
    public abstract CommentDTO commentEntityToDto(CommentEntity entity);

    public abstract ArtistDTO artistEntityToDto(ArtistEntity entity);

    @Mappings({
            @Mapping(target = "id", source = "artist.id"),
            @Mapping(target = "name", source = "artist.name"),
            @Mapping(target = "style", source = "artist.style"),
            @Mapping(target = "type", source = "artist.type")
    })
    public abstract ArtistDTO artistEntityToDto(EventArtistEntity entity);

    @Mapping(source = "createdAt", target = "createdAt")
    public abstract OrderDTO orderEntityToDto(OrderEntity entity);

    @Mappings({
            @Mapping(source = "event.name", target = "eventName"),
            @Mapping(source = "event.id", target = "eventId"),
            @Mapping(source = "event.dateTime", target = "eventDate")
    })
    public abstract TicketDTO ticketEntityToDto(TicketEntity entity);
}
