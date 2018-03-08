package com.lishuangqi.gpdb.jdbc;

public class Edge {

    Long source;
    Long target;
    Long weight;

    public Edge(Long source, Long target, Long weight) {
        super();
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

}
