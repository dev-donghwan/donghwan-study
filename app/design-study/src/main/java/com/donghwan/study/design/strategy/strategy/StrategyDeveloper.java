package com.donghwan.study.design.strategy.strategy;

import com.donghwan.study.design.strategy.strategy.strategy.CodingBehavior;

public class StrategyDeveloper {

    private CodingBehavior codingBehavior;

    StrategyDeveloper(CodingBehavior codingBehavior) {
        this.codingBehavior = codingBehavior;
    }

    public void coding() {
        this.codingBehavior.coding();
    }

    public void setCodingBehavior(CodingBehavior behavior) {
        this.codingBehavior = behavior;
    }
}
