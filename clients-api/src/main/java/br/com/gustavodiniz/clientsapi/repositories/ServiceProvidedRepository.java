package br.com.gustavodiniz.clientsapi.repositories;

import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvidedModel, Integer> {
    @Query("select s from ServiceProvidedModel s join s.client c " +
            "where upper(c.name) like upper(:name ) and MONTH(s.serviceDate) =:month")
    List<ServiceProvidedModel> findByClientNameAndMonth(@Param("name") String name, @Param("month") Integer month);
}
