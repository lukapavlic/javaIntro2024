package si.um.feri.osebe.dao;

import org.springframework.data.repository.CrudRepository;
import si.um.feri.osebe.vao.Transakcija;

public interface TransakcijaRepository extends CrudRepository<Transakcija, Integer> {
}
