/**
 * 
 */
package com.lishuangqi.common;

/**处理前推送给MQ的消息
 * @author whsav
 *
 */
public class RawMessage {
	private boolean isFetch=false;
	private String data;
	private String path;
	private String method;
	private String ipAddr;
	public boolean isFetch() {
		return isFetch;
	}
	public void setFetch(boolean isFetch) {
		this.isFetch = isFetch;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPath() {
		return path;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * 主动获取，应填写serverpath
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
