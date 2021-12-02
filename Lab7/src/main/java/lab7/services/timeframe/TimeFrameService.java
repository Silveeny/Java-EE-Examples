package lab7.services.timeframe;

import lab7.utils.time.DateUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimeFrameService implements Timeframe {

    public boolean isTimeToUpload() {
      String now = DateUtils.getCurrentHour();
      String start = "00:00"; // hardcoded unfortunately
      String end   = "10:00";

      return DateUtils.isHourInInterval(now, start, end);
    }

    @Override
    public boolean isTimeToLogin() {
      String now = DateUtils.getCurrentHour();
      String start = "00:00"; // hardcoded unfortunately, again
      String end   = "10:00";

      return DateUtils.isHourInInterval(now, start, end);
    }
}
