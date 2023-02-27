package fact.it.oefeningjpa.repository;


import fact.it.oefeningjpa.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query("select t from Training t order by t.theme asc")
    List<Training> giveListOfAllTrainingsSortedByTheme();




    @Query("select distinct(t.theme) from Training t order by t.theme ASC ")
    List<String> giveListOfAllThemes();

    List<Training> findTrainingByNumber(long id);
    List<Training> findAllByTheme(String theme);


    List<Training> findAllByTitleContaining(String search);

}
