package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdj.entity.Guide;
import sdj.repository.GuideRepository;

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
}
