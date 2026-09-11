package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdj.entity.Guide;
import sdj.service.GuideService;

@Component
public class User1Client implements Runnable{
    @Autowired
    GuideService guideService;
    @Override
    public void run() {
        // Client logic here
        Guide guide = guideService.findGuideById(2L);
        guide.setSalary(4000);
        guideService.saveGuide(guide);
    }
}
