package factory;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class SamsungPhone implements Phone {
    @Override
    public void show() {
        System.out.println("Hiiiii.....I'm Samsung");
    }
}
