package alura.forohub.Api.ForoHub.domain.topico;

import java.time.LocalDate;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechacreacion,
        Boolean status,
        String autor,
        String curso,
        String respuestas
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFechacreacion(),topico.getStatus(),
                topico.getAutor(),topico.getCurso(), topico.getRespuestas());
    }
}
