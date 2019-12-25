package cn.wang.domain;

public class AddressTown {
    private Integer id;

    private String code;

    private String name;

    private String citycode;
    //省
    private AddressProvince addressprovince;
    //市
    private AddressCity addresscity;

    public AddressCity getAddresscity() {
		return addresscity;
	}

	public void setAddresscity(AddressCity addresscity) {
		this.addresscity = addresscity;
	}

	public AddressProvince getAddressprovince() {
		return addressprovince;
	}

	public void setAddressprovince(AddressProvince addressprovince) {
		this.addressprovince = addressprovince;
	}

	public AddressCity getDaaresscity() {
		return addresscity;
	}

	public void setDaaresscity(AddressCity daaresscity) {
		this.addresscity = daaresscity;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}