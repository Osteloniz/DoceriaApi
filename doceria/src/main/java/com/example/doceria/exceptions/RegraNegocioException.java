package com.example.doceria.exceptions;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String mensagemErro) {
        super(mensagemErro);
    }

}
