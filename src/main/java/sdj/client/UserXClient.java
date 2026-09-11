package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdj.service.GuideService;

@Component
public class UserXClient implements Runnable{

    @Autowired
    GuideService guideService;

    @Override
    public void run() {
        guideService.prepareNameAndSalaryReportOfAllGuides();
    }
}
