package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdj.entity.Guide;
import sdj.repository.GuideRepository;

import java.util.List;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Transactional(readOnly = true)
    public Guide findGuideById(Long id) {
        return guideRepository.findById(id).get();
    }
    @Transactional
    public Guide saveGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    @Transactional
    public void prepareNameAndSalaryReportOfAllGuides(){
        List<Object[]> resultList = guideRepository.getNameAndSalaryOfAll();
        for(Object[] obj : resultList){
            System.out.println("Name: "+obj[0]+" Salary: "+obj[1]);
        }
        System.out.println(guideRepository.calculateSumOfAllSalaries());
    }
    @Transactional
    public void raiseSalaryOfGuide(Long id, Integer newSalary){

        Guide guide = guideRepository.findById(id).get();
        guide.setSalary(newSalary);
    }
}
