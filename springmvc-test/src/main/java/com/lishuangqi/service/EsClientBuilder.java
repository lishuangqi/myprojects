package com.lishuangqi.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
/**
 * Created by michael on 2017/11/9.
 */
public class EsClientBuilder {
    private String clusterName;
    private String nodeIpInfo;
    private TransportClient client;

    public Client init(){
        //设置集群的名字
        Settings settings = Settings.settingsBuilder()
                .put("client.transport.sniff", false)
                .put("cluster.name", clusterName)
                .build();
        //创建集群client并添加集群节点地址
        client = TransportClient.builder().settings(settings).build();
        Map<String, Integer> nodeMap = parseNodeIpInfo();
        for (Map.Entry<String,Integer> entry : nodeMap.entrySet()){
            try {
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(entry.getKey()), entry.getValue()));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return client;
    }

    /**
     * 解析节点IP信息,多个节点用逗号隔开,IP和端口用冒号隔开
     *
     * @return
     */
    private Map<String, Integer> parseNodeIpInfo(){
        String[] nodeIpInfoArr = nodeIpInfo.split(",");
        Map<String, Integer> map = new HashMap<String, Integer>(nodeIpInfoArr.length);
        for (String ipInfo : nodeIpInfoArr){
            String[] ipInfoArr = ipInfo.split(":");
            map.put(ipInfoArr[0], Integer.parseInt(ipInfoArr[1]));
        }
        return map;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getNodeIpInfo() {
        return nodeIpInfo;
    }

    public void setNodeIpInfo(String nodeIpInfo) {
        this.nodeIpInfo = nodeIpInfo;
    }
}
