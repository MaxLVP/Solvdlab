package com.solvd.library.others;

public abstract class Periodicals implements IReading{
    private final String TOPIC;
    private final String NAME;

    public Periodicals(String topic, String name) {
        this.TOPIC = topic;
        this.NAME = name;
    }

    public String getTopic() {
        return TOPIC;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public void returnPeriodicals(Periodicals periodicals) {}
}
