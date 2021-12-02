package lab7.utils.decorators;

import lab7.services.timeframe.Timeframe;
import lab7.utils.time.DateUtils;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class TimeframeDecorator implements Timeframe {
    // the decorator logs the time when methods in time frame service are called - needs to be specified in beans.xml
    @Inject
    @Delegate
    @Any
    Timeframe timeframe;

    @Override
    public boolean isTimeToUpload() {
        System.out.println("Access" + DateUtils.getCurrentHour());
        return timeframe.isTimeToUpload();
    }

    @Override
    public boolean isTimeToLogin() {
        System.out.println("Access" + DateUtils.getCurrentHour());
        return timeframe.isTimeToUpload();
    }
}
