package py.com.template.application.engine.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TemplateException extends RuntimeException {

    // ::: vars

    private String errorCode;
    private String userMessage;
    private Boolean useApiMessage;
    private Integer httpStatus;

    // ::: constructors

    public TemplateException(Throwable cause) {
        super(cause);
    }

    public TemplateException(String codeError, String detailedMessage, Integer httpStatus) {
        super(detailedMessage);
        this.errorCode = codeError;
        this.httpStatus = httpStatus;
        this.userMessage = detailedMessage;
        this.useApiMessage = false;
    }

    public TemplateException(String codigoError, String mensajeDetallado, Integer httpStatus, Boolean useApiMessage) {
        super(mensajeDetallado);
        this.errorCode = codigoError;
        this.httpStatus = httpStatus;
        this.userMessage = mensajeDetallado;
        this.useApiMessage = useApiMessage;
    }

    public TemplateException(String codigoError, String mensajeDetallado, String mensajeUsuario, Integer httpStatus) {
        super(mensajeDetallado);
        this.errorCode = codigoError;
        this.httpStatus = httpStatus;
        this.userMessage = mensajeUsuario;
        this.useApiMessage = false;
    }

    public TemplateException(String codigoError, String mensajeDetallado, String mensajeUsuario, Integer httpStatus, Boolean useApiMessage) {
        super(mensajeDetallado);
        this.errorCode = codigoError;
        this.httpStatus = httpStatus;
        this.userMessage = mensajeUsuario;
        this.useApiMessage = useApiMessage;
    }


}
