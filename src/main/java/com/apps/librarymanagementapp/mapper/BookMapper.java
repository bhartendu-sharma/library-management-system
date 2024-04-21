package com.apps.librarymanagementapp.mapper;
import com.apps.librarymanagementapp.dto.BookDTO;
import com.apps.librarymanagementapp.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    void updateBookFromDto(BookDTO bookDto, @MappingTarget Book book);

    @Mapping(source = "borrowedBy.id", target = "borrowedById")
    BookDTO toDto(Book book);
}

