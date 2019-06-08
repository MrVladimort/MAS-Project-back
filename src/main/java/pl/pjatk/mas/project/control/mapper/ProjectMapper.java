package pl.pjatk.mas.project.control.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.pjatk.mas.project.boundary.dto.AdminDTO;
import pl.pjatk.mas.project.boundary.dto.ClientDTO;
import pl.pjatk.mas.project.boundary.dto.RegisterDTO;
import pl.pjatk.mas.project.boundary.dto.UserDTO;
import pl.pjatk.mas.project.control.entity.AdminEntity;
import pl.pjatk.mas.project.control.entity.ClientEntity;
import pl.pjatk.mas.project.control.entity.UserEntity;
import pl.pjatk.mas.project.control.security.UserPrincipal;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ProjectMapper {
    public abstract ClientEntity clientEntityFromDto(ClientDTO dto);
    public abstract ClientEntity clientEntityFromDto(RegisterDTO dto);
    public abstract ClientDTO clientDtoFromEntity(ClientEntity dto);

    public abstract AdminEntity adminEntityFromDto(AdminDTO dto);
    public abstract AdminEntity adminEntityFromDto(RegisterDTO dto);
    public abstract AdminDTO adminDtoFromEntity(AdminEntity dto);

    public abstract UserDTO userDtoFromPrincipal(UserPrincipal entity);
    public abstract UserPrincipal principalFromEntity(UserEntity entity);
    public abstract UserDTO userDtoFromEntity(UserEntity entity);
}
