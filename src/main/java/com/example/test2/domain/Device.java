package com.example.test2.domain;

public class Device {
  /*  "ID": "31011500991320000172",
            "Name": "",
            "Manufacturer": "IP Camera",
            "Type": "GB",
            "Password": "",
            "MediaTransport": "UDP",
            "MediaTransportMode": "passive",
            "CommandTransport": "UDP",
            "RemoteIP": "182.138.136.245",
            "RemotePort": 20022,
            "Online": true,
            "ChannelCount": 1,
            "RecvStreamIP": "",
            "SMSID": "",
            "ContactIP": "",
            "Charset": "",
            "CatalogInterval": 3600,
            "SubscribeInterval": 0,
            "LastRegisterAt": "2020-09-25 20:18:56",
            "LastKeepaliveAt": "2020-09-25 20:23:56",
            "CreatedAt": "2020-09-24 16:07:51",
            "UpdatedAt": "2020-09-25 20:23:56"*/
    private String Manufacturer;
    private String Type;
    private String Password;
    private String MediaTransport;
    private String MediaTransportMode;
    private String CommandTransport;
    private String RecvStreamIP;
    private String ID;
    private String Name;
    private String RemoteIP;
    private boolean Online;

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMediaTransport() {
        return MediaTransport;
    }

    public void setMediaTransport(String mediaTransport) {
        MediaTransport = mediaTransport;
    }

    public String getMediaTransportMode() {
        return MediaTransportMode;
    }

    public void setMediaTransportMode(String mediaTransportMode) {
        MediaTransportMode = mediaTransportMode;
    }

    public String getCommandTransport() {
        return CommandTransport;
    }

    public void setCommandTransport(String commandTransport) {
        CommandTransport = commandTransport;
    }

    public String getRecvStreamIP() {
        return RecvStreamIP;
    }

    public void setRecvStreamIP(String recvStreamIP) {
        RecvStreamIP = recvStreamIP;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRemoteIP() {
        return RemoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        RemoteIP = remoteIP;
    }

    public boolean isOnline() {
        return Online;
    }

    public void setOnline(boolean online) {
        Online = online;
    }

    @Override
    public String toString() {
        return "Device{" +
                "Manufacturer='" + Manufacturer + '\'' +
                ", Type='" + Type + '\'' +
                ", Password='" + Password + '\'' +
                ", MediaTransport='" + MediaTransport + '\'' +
                ", MediaTransportMode='" + MediaTransportMode + '\'' +
                ", CommandTransport='" + CommandTransport + '\'' +
                ", RecvStreamIP='" + RecvStreamIP + '\'' +
                ", ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", RemoteIP='" + RemoteIP + '\'' +
                ", Online=" + Online +
                '}';
    }}
