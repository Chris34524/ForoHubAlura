package alura.forohub.Api.ForoHub.domain.topico;

import java.time.LocalDate;

public record DatosRespuestaTopico (
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechacreacion,
        Boolean status,
        String autor,
        String curso,
        String respuestas
){
}
