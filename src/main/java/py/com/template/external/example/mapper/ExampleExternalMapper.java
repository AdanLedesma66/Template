package py.com.template.external.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExampleExternalMapper {

    ExampleExternalMapper INSTANCE = Mappers.getMapper(ExampleExternalMapper.class);

}
