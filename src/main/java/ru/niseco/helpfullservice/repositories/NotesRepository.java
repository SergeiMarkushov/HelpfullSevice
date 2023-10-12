package ru.niseco.helpfullservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.niseco.helpfullservice.entities.Notes;
@Repository
public interface NotesRepository extends JpaRepository<Notes,Long> {

}
