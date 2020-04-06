package br.com.acqio.empresa.controller;

import br.com.acqio.empresa.model.Empresa.Empresa;
import br.com.acqio.empresa.model.Empresa.dto.EmpresaDTO;
import br.com.acqio.empresa.model.Empresa.dto.EmpresaDetailsDTO;
import br.com.acqio.empresa.model.Empresa.form.EmpresaInsertForm;
import br.com.acqio.empresa.model.Empresa.form.EmpresaUpdateForm;
import br.com.acqio.empresa.repository.CidadeRepository;
import br.com.acqio.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequestMapping("/empresa")
@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public Page<EmpresaDTO> listAllCompanies(@RequestParam(required = false) String razaoSocial,
                                             @RequestParam(required = false) String nomeFantasia,
                                             @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        if (razaoSocial == null && nomeFantasia == null) {
            Page<Empresa> empresas = empresaRepository.findAll(paginacao);
            return EmpresaDTO.converter(empresas);
        } else if (nomeFantasia == null) {
            Page<Empresa> empresas = empresaRepository.findByRazaoSocial(razaoSocial, paginacao);
            return EmpresaDTO.converter(empresas);
        } else if (razaoSocial == null) {
            Page<Empresa> empresas = empresaRepository.findByNomeFantasia(nomeFantasia, paginacao);
            return EmpresaDTO.converter(empresas);
        } else {
            Page<Empresa> empresas = empresaRepository.findByRazaoSocialAndNomeFantasia(razaoSocial, nomeFantasia, paginacao);
            return EmpresaDTO.converter(empresas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDetailsDTO> detail(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            return ResponseEntity.ok(new EmpresaDetailsDTO(empresa.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaDTO> register(@RequestBody @Valid EmpresaInsertForm form, UriComponentsBuilder uriComponentsBuilder) {
        Empresa empresa = form.converter(cidadeRepository);
        empresaRepository.save(empresa);

        URI uri = uriComponentsBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDTO(empresa));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EmpresaDTO> update(@PathVariable(required = true) Long id, @RequestBody @Valid EmpresaUpdateForm form) {
        Optional<Empresa> optional = empresaRepository.findById(id);
        if (optional.isPresent()) {
            Empresa empresa = form.atualizar(id, empresaRepository);
            return ResponseEntity.ok(new EmpresaDTO(empresa));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<EmpresaDTO> delete(@PathVariable(required = true) Long id) {
        Optional<Empresa> optional = empresaRepository.findById(id);
        if (optional.isPresent()) {
            empresaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
