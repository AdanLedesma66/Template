package py.com.template.application.engine.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateException extends RuntimeException {

    // ::: vars
    //
    private int code = 1;
    private String name = "unknown";
    private Map<String, ?> extra;

    // ::: constructors
    //

    public TemplateException(Throwable cause) {
        this(null, null, cause);
    }

    public TemplateException(TemplatePrototype proto, String msg) {
        this(proto, msg, null);
    }

    public TemplateException(TemplatePrototype proto, String msg, Throwable cause) {
        super(msg);
        if(proto != null) {
            this.code = proto.getCode();
            this.name = proto.getName();
        }
        if(cause != null) {
            initCause(cause);
        }
    }

    public TemplateException(int code, String name, String msg) {
        this(code, name, msg, null);
    }

    public TemplateException(int code, String name, String msg, Throwable cause) {
        super(msg);

        if(code > 0) {
            this.code = code;
        }

        if(name != null) {
            this.name = name;
        }

        if(cause != null) {
            initCause(cause);
        }

    }

}
