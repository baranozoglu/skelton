package com.github.baranozoglu.converter;

import com.github.baranozoglu.converter.factory.ConverterFactory;
import com.github.baranozoglu.dto.UserDTO;
import com.github.baranozoglu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
