package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    ArrayList<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
        programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
        programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        ProgrammingLanguage programmingLanguage = null;
        for(ProgrammingLanguage pl : programmingLanguages){
            programmingLanguage = (id == pl.getId()) ? pl : null;
        }
        return programmingLanguage;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage){
        this.programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage){
        for(ProgrammingLanguage pl : programmingLanguages){
            if(programmingLanguage.getId() == pl.getId())
                pl.setName(programmingLanguage.getName());
        }
    }

    @Override
    public void delete(int id) {
        ProgrammingLanguage programmingLanguage = null;
        for(ProgrammingLanguage pl : programmingLanguages){
            programmingLanguage = (id == pl.getId()) ? pl : null;
        }
        this.programmingLanguages.remove(programmingLanguage);
    }

}
