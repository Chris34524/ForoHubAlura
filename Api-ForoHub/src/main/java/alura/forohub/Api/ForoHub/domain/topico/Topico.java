package alura.forohub.Api.ForoHub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechacreacion;
    private Boolean status;
    private String autor;
    private String curso;
    private String respuestas;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechacreacion = datosRegistroTopico.fechacreacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.respuestas = datosRegistroTopico.respuestas();
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if(datosActualizarTopico.fechacreacion() != null){
            this.fechacreacion = datosActualizarTopico.fechacreacion();
        }

        if(datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }

        if(datosActualizarTopico.autor() != null){
            this.autor = datosActualizarTopico.autor();
        }

        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }

        if(datosActualizarTopico.respuestas() != null){
            this.respuestas = datosActualizarTopico.respuestas();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
