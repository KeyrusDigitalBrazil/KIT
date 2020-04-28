package com.keyrus.kit.controllers;

import com.keyrus.kit.convert.DnaConvert;
import com.keyrus.kit.data.DnaData;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.repository.KitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value = "/dna")
public class DnaController {

    @Resource(name = "dnaRepository")
    private KitRepository dnaRepository;

    @Resource
    private DnaConvert dnaConvert;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public DnaData getPatient(@PathVariable Long id) {
        Optional<Dna> optDna = Optional.ofNullable((Dna) dnaRepository.get(id));

        return optDna.map(dna -> dnaConvert.convertModel(dna)).orElse(null);
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public Set<DnaData> getAll() {
        Optional<List<Dna>> optDna = Optional.ofNullable((List<Dna>) dnaRepository.getAll());
        Set<DnaData> dnaData = new TreeSet<>();

        optDna.ifPresent(dnas -> dnas.stream()
                .filter(Objects::nonNull)
                .forEach(dna -> dnaData.add(dnaConvert.convertModel(dna))));

        return dnaData;
    }

    @PostMapping
    public HttpStatus savePatient(@RequestBody DnaData dnaData) {
        try {
            dnaRepository.add(dnaConvert.convertData(dnaData));

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PutMapping
    public HttpStatus updatePatient(@RequestBody DnaData dnaData) {
        try {
            dnaRepository.update(dnaConvert.convertData(dnaData));

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deletePatient(@PathVariable Long id) {
        try {
            dnaRepository.remove(id);

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

}
