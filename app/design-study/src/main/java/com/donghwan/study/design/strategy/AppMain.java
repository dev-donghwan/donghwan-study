package com.donghwan.study.design.strategy;

import com.donghwan.study.design.strategy.not_strategy.NotStrategyAndroidDeveloper;
import com.donghwan.study.design.strategy.not_strategy.NotStrategyDeveloper;
import com.donghwan.study.design.strategy.not_strategy.NotStrategyIosDeveloper;
import com.donghwan.study.design.strategy.strategy.StrategyAndroidDeveloper;
import com.donghwan.study.design.strategy.strategy.StrategyDeveloper;
import com.donghwan.study.design.strategy.strategy.StrategyIosDeveloper;
import com.donghwan.study.design.strategy.strategy.strategy.AndroidWithJavaBehavior;
import com.donghwan.study.design.strategy.strategy.strategy.AndroidWithKotlinBehavior;
import com.donghwan.study.design.strategy.strategy.strategy.CodingBehavior;
import com.donghwan.study.design.strategy.strategy.strategy.IosWithObjectCBehavior;
import com.donghwan.study.design.strategy.strategy.strategy.IosWithSwiftBehavior;

public class AppMain {
    /*
     * 예제의 설정
     * Android와 Ios Mobile 개발자가 있는데 각각 프로젝트에서 2가지 언어를 사용한다는 가정입니다.
     * 인스턴스가 개발자의 숫자를 의미하도록 상황을 부여하고 객체는 각 상황에서 1명씩 존재한다는 가정입니다.
     */

    public static void main(String[] args) {
        /*
         * Not Strategy
         * 전략 패턴을 적용하지 않은 경우, 언어 변경에 따라서 각 클래스를 직접 수정해야 하는데 이러한 경우는 OCP 원칙에 위배됩니다.
         * 그리고 언어의 갯수가 2개가 아닌 N개가 될 경우 매번 수정을 해야하는 비효율이 발생합니다.
         */
        NotStrategyDeveloper notStrategyAndroidDeveloper = new NotStrategyAndroidDeveloper();
        notStrategyAndroidDeveloper.coding();

        NotStrategyDeveloper notStrategyIosDeveloper = new NotStrategyIosDeveloper();
        notStrategyIosDeveloper.coding();

        /*
         * Strategy
         * 전략 패턴을 적용한 경우, CodingBehavior라는 Interface로 개념을 캡슈화하였습니다.
         * 따라서 AndroidDeveloper와 IosDeveloper는 동일한 Instance에서 전략의 종류만 갈아끼워준다면 동적으로 Coding 전략을 변경할 수 있습니다.
         * 언어가 N개가 되더라도 Developer 클래스를 직접 수정하는 것이 아니라 전략의 확장을 통해 해결하기 때문에 OCP 원칙을 지킬 수 있습니다.
         */
        CodingBehavior androidWithJavaBehavior = new AndroidWithJavaBehavior();
        CodingBehavior androidWithKotlinBehavior = new AndroidWithKotlinBehavior();
        CodingBehavior iosWithObjectCBehavior = new IosWithObjectCBehavior();
        CodingBehavior iosWithSwiftBehavior = new IosWithSwiftBehavior();

        StrategyDeveloper androidDeveloper = new StrategyAndroidDeveloper(androidWithJavaBehavior);
        androidDeveloper.coding();
        androidDeveloper.setCodingBehavior(androidWithKotlinBehavior);
        androidDeveloper.coding();
        androidDeveloper.setCodingBehavior(androidWithJavaBehavior);
        androidDeveloper.coding();

        StrategyDeveloper iosDeveloper = new StrategyIosDeveloper(iosWithObjectCBehavior);
        iosDeveloper.coding();
        iosDeveloper.setCodingBehavior(iosWithSwiftBehavior);
        iosDeveloper.coding();
        iosDeveloper.setCodingBehavior(iosWithObjectCBehavior);
        iosDeveloper.coding();
    }
}
