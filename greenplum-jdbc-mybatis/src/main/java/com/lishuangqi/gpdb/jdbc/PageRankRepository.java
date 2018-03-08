package com.lishuangqi.gpdb.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PageRankRepository {

    private JdbcTemplate jdbcTemplate;

    public PageRankRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PageRankRecord> getTopNRanked(Integer topN) {
        String query = "SELECT dest_address, pagerank FROM pagerank_out ORDER BY 2 DESC ";

        if (topN > 0) {
            query = query + " LIMIT " + topN.toString();
        }

        List<PageRankRecord> results = new ArrayList<PageRankRecord>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Long uniqueId = Long.parseLong(((String) row.get("dest_address")).replace(".", ""));
            PageRankRecord r = new PageRankRecord(uniqueId,
                    (String) row.get("dest_address"),
                    (Double) row.get("pagerank"));
            results.add(r);
        }

        return results;
    }

    public List<Edge> getNEdges(Integer topN) {
        String query = "SELECT dest_address AS target, src_address AS source, count(*)"
                + " FROM nfint GROUP BY 1, 2";

        if (topN > 0) {
            query = query + " LIMIT " + topN.toString();
        }

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        List<Edge> results = new ArrayList<Edge>();

        for (Map<String, Object> row : rows) {
            Long t = Long.parseLong(((String) row.get("target")).replace(".", ""));
            Long s = Long.parseLong(((String) row.get("source")).replace(".", ""));
            Long w = (Long) row.get("count");
            Edge r = new Edge(t, s, w);

            results.add(r);
        }

        return results;
    }

}
