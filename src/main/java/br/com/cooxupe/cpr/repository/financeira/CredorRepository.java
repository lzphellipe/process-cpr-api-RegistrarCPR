package br.com.cooxupe.cpr.repository.financeira;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cooxupe.cpr.model.financeira.CredorModel;

@Repository
public interface CredorRepository extends JpaRepository<CredorModel, String> {

}
