package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdj.entity.Guide;
import sdj.service.GuideService;

@Component
public class User2Client implements Runnable{
    @Autowired
    GuideService guideService;
    @Override
    public void run() {
        // Client logic here
        Guide guide = guideService.findGuideById(2L);
        guide.setSalary(3000);
        guideService.saveGuide(guide);
    }
}
