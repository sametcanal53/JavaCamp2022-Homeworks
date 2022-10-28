package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return this.programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        isExistsById(id,programmingLanguageRepository);
        return this.programmingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        checkAdd(programmingLanguage,programmingLanguageRepository);
        this.programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {
        checkUpdate(programmingLanguage,programmingLanguageRepository);
        isExistsById(programmingLanguage,programmingLanguageRepository);
        this.programmingLanguageRepository.update(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        isExistsById(id,programmingLanguageRepository);
        this.programmingLanguageRepository.delete(id);
    }

    public static void checkUpdate(ProgrammingLanguage programmingLanguage,ProgrammingLanguageRepository programmingLanguageRepository) throws Exception {
        for(ProgrammingLanguage pl : programmingLanguageRepository.getAll())
        {
            if(pl.getName().equals(programmingLanguage.getName())){
                throw new Exception("Programming language already exists.");
            }
        }
        checkRequiredName(programmingLanguage);
    }

    public static void checkAdd(ProgrammingLanguage programmingLanguage,ProgrammingLanguageRepository programmingLanguageRepository) throws Exception {
        for(ProgrammingLanguage pl : programmingLanguageRepository.getAll())
        {
            if(pl.getId() == programmingLanguage.getId()){
                throw new Exception("Programming language id already exists.");
            }
            if(pl.getName().equals(programmingLanguage.getName())){
                throw new Exception("Programming language already exists.");
            }
        }
        checkRequiredName(programmingLanguage);
    }

    public static void isExistsById(ProgrammingLanguage programmingLanguage,ProgrammingLanguageRepository programmingLanguageRepository) throws Exception{
        if(programmingLanguageRepository.getById(programmingLanguage.getId()) == null){
            throw new Exception("Programming language id not found.");
        }
    }

    public static void isExistsById(int id,ProgrammingLanguageRepository programmingLanguageRepository) throws Exception{
        if(programmingLanguageRepository.getById(id) == null){
            throw new Exception("Programming language id not found.");
        }
    }

    public static void checkRequiredName(ProgrammingLanguage programmingLanguage) throws Exception {
        if(programmingLanguage.getName().isEmpty() || programmingLanguage.getName().isBlank()){
            throw new Exception("Programming language is required.");
        }
    }

}
