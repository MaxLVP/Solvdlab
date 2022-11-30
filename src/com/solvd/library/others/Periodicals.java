package com.solvd.library.others;

public abstract class Periodicals implements IReading{
    private String topic;
    private String name;

    public Periodicals(String topic, String name) {
        this.topic = topic;
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void returnPeriodicals() {}
}
