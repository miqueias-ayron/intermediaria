package com.avaliacao.intermediaria.reserva;

import com.avaliacao.intermediaria.common.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ReservaErrorHandler {

    @ExceptionHandler(ReservaNaoEncontradaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleRuntimeException(ReservaNaoEncontradaException re) {

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setDate(LocalDateTime.now());
        errorResponseDTO.setMessage(re.getMessage());
        errorResponseDTO.setStatusCode(404);
        return errorResponseDTO;

    }

}