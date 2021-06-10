package com.udemy.projeto.spring.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError  implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> lista = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return lista;
    }

    public void addError(String fieldName, String mensagem) {
        lista.add(new FieldMessage(fieldName, mensagem));
    }
}
