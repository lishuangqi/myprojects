package com.lishuangqi.gpdb.jdbc;

public class PageRankRecord {

    private Long id;
    private String label;
    private Double rank;

    public PageRankRecord(Long id, String label, Double rank) {
        super();
        this.id = id;
        this.label = label;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

}
