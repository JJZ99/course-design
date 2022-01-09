package com.zhaojunjie;


public class NetParam {
    private int maxTotal=200;

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(int maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public int getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(int connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public int getConnReqTimeOut() {
        return connReqTimeOut;
    }

    public void setConnReqTimeOut(int connReqTimeOut) {
        this.connReqTimeOut = connReqTimeOut;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getInactivity() {
        return inactivity;
    }

    public void setInactivity(int inactivity) {
        this.inactivity = inactivity;
    }

    private int maxPerRoute=100;

    private int connTimeOut=5000;

    private int connReqTimeOut=1000;

    private int socketTimeout=65000;

    private int inactivity = 2000;
}
