package aTemp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Question4 {
    public static void main(String[] args) {

    }
    public boolean wait(int seconds) {
        Calendar calWhenFinish = Calendar.getInstance(), calCurrent = new GregorianCalendar();
        calWhenFinish.setTime(new Date());
        calCurrent.setTime(new Date());

        seconds = (calCurrent.get(Calendar.SECOND) + seconds) % 60;
        int minutes = (calCurrent.get(Calendar.SECOND) + seconds) / 60 + calCurrent.get(Calendar.MINUTE);

        calWhenFinish.set(Calendar.SECOND, seconds);
        calWhenFinish.set(Calendar.MINUTE, minutes);

        System.out.println(calWhenFinish.get(Calendar.MINUTE) + " vs " + calCurrent.get(Calendar.MINUTE));
        System.out.println(calWhenFinish.get(Calendar.SECOND) + " vs " + calCurrent.get(Calendar.SECOND));
        System.out.println();

        while (calWhenFinish.get(Calendar.MINUTE) >= calCurrent.get(Calendar.MINUTE) &&
                calWhenFinish.get(Calendar.SECOND) >= calCurrent.get(Calendar.SECOND)) {
            calCurrent.setTime(new Date());
        }
        return true;
        //in loop need to condition for hour and days
    }
}
