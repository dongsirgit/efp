package com.baiwang.einvoice.qz.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
  * @ClassName: OrderDetail
  * @Description: 订单信息实体类
  * @author zhaowei
  * @date 2016年3月14日 下午4:23:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"id",
	"fpqqlsh",
	"zddh",
	"fddh",
	"fpdq",
	"fpkhlx",
    "sqr",
    "hym",
    "hyid",
    "ddsj",
    "sqsj",
    "fksj",
    "spzl",
    "sqrk",
    "shr",
    "shrdh",
    "jsdz",
    "yjsj",
    "fhr",
    "wlgs",
    "wldh",
    "tkzt",
    "fpzt",
    "bzfp",
    "sjhm",
    "yx",
    "fptt",
    "fpttlx"
    
})
public class OrderDetail {
	@XmlElement(name = "ID", required = true)
    private Long id;
	@XmlElement(name = "FPQQLSH", required = true)
	private String fpqqlsh;
	@XmlElement(name = "ZDDH", required = true)
    private String zddh;
	@XmlElement(name = "FDDH", required = true)
    private String fddh;
	@XmlElement(name = "FPDQ", required = true)
	private String fpdq;
	@XmlElement(name = "FPKHLX", required = true)
	private String fpkhlx;
	@XmlElement(name = "FPTT", required = true)
	private String fptt;
	@XmlElement(name = "FPTTLX", required = true)
	private String fpttlx;
	@XmlElement(name = "SQR", required = true)
    private String sqr;
	@XmlElement(name = "HYM", required = true)
    private String hym;
	@XmlElement(name = "HYID", required = true)
    private String hyid;
	@XmlElement(name = "DDSJ", required = true)
    private String ddsj;
	@XmlElement(name = "SQSJ", required = true)
    private String sqsj;
	@XmlElement(name = "FKSJ", required = true)
    private String fksj;
	@XmlElement(name = "SPZL", required = true)
    private String spzl;
	@XmlElement(name = "SQRK", required = true)
    private String sqrk;
	@XmlElement(name = "SHR", required = true)
    private String shr;
	@XmlElement(name = "SHRDH", required = true)
    private String shrdh;
	@XmlElement(name = "JSDZ", required = true)
    private String jsdz;
	@XmlElement(name = "YJSJ", required = true)
    private Date yjsj;

	@XmlElement(name = "FHR", required = true)
    private String fhr;
	@XmlElement(name = "WLGS", required = true)
    private String wlgs;
	@XmlElement(name = "WLDH", required = true)
    private String wldh;
	@XmlElement(name = "TKZT", required = true)
    private String tkzt;
	@XmlElement(name = "FPZT", required = true)
    private String fpzt;
	@XmlElement(name = "BZFP", required = true)
	private String bzfp;
	@XmlElement(name = "SJHM", required = true)
	private String sjhm;
	@XmlElement(name = "YX", required = true)
	private String yx;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr == null ? null : sqr.trim();
    }

    public String getHym() {
        return hym;
    }

    public void setHym(String hym) {
        this.hym = hym == null ? null : hym.trim();
    }

    public String getHyid() {
        return hyid;
    }

    public void setHyid(String hyid) {
        this.hyid = hyid == null ? null : hyid.trim();
    }

    public String getSpzl() {
        return spzl;
    }

    public void setSpzl(String spzl) {
        this.spzl = spzl == null ? null : spzl.trim();
    }

    public String getSqrk() {
        return sqrk;
    }

    public void setSqrk(String sqrk) {
        this.sqrk = sqrk;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr == null ? null : shr.trim();
    }

    public String getShrdh() {
        return shrdh;
    }

    public void setShrdh(String shrdh) {
        this.shrdh = shrdh == null ? null : shrdh.trim();
    }

    public String getJsdz() {
        return jsdz;
    }

    public void setJsdz(String jsdz) {
        this.jsdz = jsdz == null ? null : jsdz.trim();
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public String getFhr() {
        return fhr;
    }

    public void setFhr(String fhr) {
        this.fhr = fhr == null ? null : fhr.trim();
    }

    public String getWlgs() {
        return wlgs;
    }

    public void setWlgs(String wlgs) {
        this.wlgs = wlgs == null ? null : wlgs.trim();
    }

    public String getWldh() {
        return wldh;
    }

    public void setWldh(String wldh) {
        this.wldh = wldh == null ? null : wldh.trim();
    }

    public String getTkzt() {
        return tkzt;
    }

    public void setTkzt(String tkzt) {
        this.tkzt = tkzt == null ? null : tkzt.trim();
    }

    public String getFpzt() {
        return fpzt;
    }

    public void setFpzt(String fpzt) {
        this.fpzt = fpzt == null ? null : fpzt.trim();
    }

	public String getZddh() {
	
		return zddh;
	}

	public void setZddh(String zddh) {
	
		this.zddh = zddh;
	}

	public String getFddh() {
	
		return fddh;
	}

	public void setFddh(String fddh) {
	
		this.fddh = fddh;
	}

	public String getFpqqlsh() {
	
		return fpqqlsh;
	}

	public void setFpqqlsh(String fpqqlsh) {
	
		this.fpqqlsh = fpqqlsh;
	}


	public String getBzfp() {
	
		return bzfp;
	}

	public void setBzfp(String bzfp) {
	
		this.bzfp = bzfp;
	}

	public String getFpdq() {
	
		return fpdq;
	}

	public void setFpdq(String fpdq) {
	
		this.fpdq = fpdq;
	}

	public String getFpkhlx() {
	
		return fpkhlx;
	}

	public void setFpkhlx(String fpkhlx) {
	
		this.fpkhlx = fpkhlx;
	}

	public String getDdsj() {
	
		return ddsj;
	}

	public void setDdsj(String ddsj) {
	
		this.ddsj = ddsj;
	}

	public String getSqsj() {
	
		return sqsj;
	}

	public void setSqsj(String sqsj) {
	
		this.sqsj = sqsj;
	}

	public String getFksj() {
	
		return fksj;
	}

	public void setFksj(String fksj) {
	
		this.fksj = fksj;
	}

	public String getSjhm() {
	
		return sjhm;
	}

	public void setSjhm(String sjhm) {
	
		this.sjhm = sjhm;
	}

	public String getYx() {
	
		return yx;
	}

	public void setYx(String yx) {
	
		this.yx = yx;
	}

	public String getFptt() {
	
		return fptt;
	}

	public void setFptt(String fptt) {
	
		this.fptt = fptt;
	}

	public String getFpttlx() {
	
		return fpttlx;
	}

	public void setFpttlx(String fpttlx) {
	
		this.fpttlx = fpttlx;
	}

    
}