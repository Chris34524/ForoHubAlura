package alura.forohub.Api.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.BeanProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDate fechacreacion,
        @NotNull
        Boolean status,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        @NotBlank
        String respuestas
) {
}
