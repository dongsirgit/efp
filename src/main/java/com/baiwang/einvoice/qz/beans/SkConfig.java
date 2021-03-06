package com.baiwang.einvoice.qz.beans;

/***
  * @ClassName: SkConfig
  * @Description: 税控参数配置实体类
  * @author zhaowei
  * @date 2016年3月14日 下午4:26:48
 */
public class SkConfig {
    private Long id;

    private Integer kpdq;

    private String nsrsbh;
    
    private String userId;
    
    private String url;

    private String port;

    private String keypwd;
    
    private String aqm;
    
    private String kpzdbs;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getKpdq() {
        return kpdq;
    }

    public void setKpdq(Integer kpdq) {
        this.kpdq = kpdq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

	public String getKeypwd() {
	
		return keypwd;
	}

	public void setKeypwd(String keypwd) {
	
		this.keypwd = keypwd;
	}

	public String getAqm() {
	
		return aqm;
	}

	public void setAqm(String aqm) {
	
		this.aqm = aqm;
	}

	public String getKpzdbs() {
	
		return kpzdbs;
	}

	public void setKpzdbs(String kpzdbs) {
	
		this.kpzdbs = kpzdbs;
	}

	public String getNsrsbh() {
	
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
	
		this.nsrsbh = nsrsbh;
	}
    
    
}