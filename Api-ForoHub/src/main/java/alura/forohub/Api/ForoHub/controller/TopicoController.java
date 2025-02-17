package alura.forohub.Api.ForoHub.controller;

import alura.forohub.Api.ForoHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso(),topico.getRespuestas());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

//    @GetMapping
//    public Page<DatosListadoTopicos> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion){
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
//    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>>  listadoTopicos(Pageable paginacion){
        //return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso(),topico.getRespuestas()));
    }
//    Delete en BD
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarTopico(@PathVariable Long id){
//        Topico topico = topicoRepository.getReferenceById(id);
//        topicoRepository.delete(topico);
//    }

    // Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso(),topico.getRespuestas());
        return ResponseEntity.ok(datosTopico);
    }




}
