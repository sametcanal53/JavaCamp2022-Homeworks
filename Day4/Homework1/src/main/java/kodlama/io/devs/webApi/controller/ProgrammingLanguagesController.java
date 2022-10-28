package kodlama.io.devs.webApi.controller;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/")
    public List<ProgrammingLanguage> getAll() {
        return this.programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable int id) throws Exception {
        return this.programmingLanguageService.getById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        this.programmingLanguageService.add(programmingLanguage);
    }

    @PatchMapping("/")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        this.programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id) throws Exception {
        this.programmingLanguageService.delete(id);
    }

}
