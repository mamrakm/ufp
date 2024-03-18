package cz.ememsoft.ufp.mapper;

import cz.ememsoft.ufp.dto.ThreadEntityDto;
import cz.ememsoft.ufp.entity.ThreadEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ThreadMapper {
    
    ThreadEntityDto toDto(ThreadEntity threadEntity);

    ThreadEntity toEntity(ThreadEntityDto threadEntityDTO);
}
