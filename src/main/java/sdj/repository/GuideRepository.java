package sdj.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import sdj.entity.Guide;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query(" select guide.name, guide.salary from Guide guide ")
    List<Object[]> getNameAndSalaryOfAll();
    @Query(" select sum(guide.salary) from Guide guide")
    Long calculateSumOfAllSalaries();
}
